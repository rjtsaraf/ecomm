package com.ecommerce.shoppinghub.services;

import com.ecommerce.shoppinghub.DTO.LoginDTO;
import com.ecommerce.shoppinghub.DTO.OtpDTO;
import com.ecommerce.shoppinghub.DTO.UserDTO;
import com.ecommerce.shoppinghub.exceptions.BadRequestException;
import com.ecommerce.shoppinghub.exceptions.NotFoundException;
import com.ecommerce.shoppinghub.mapper.UserMapper;
import com.ecommerce.shoppinghub.domain.Role;
import com.ecommerce.shoppinghub.domain.RoleType;
import com.ecommerce.shoppinghub.domain.User;
import com.ecommerce.shoppinghub.repositories.RoleRepository;
import com.ecommerce.shoppinghub.repositories.UserRepository;
import com.ecommerce.shoppinghub.security.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    PasswordEncoder encoder;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO addNewUser(UserDTO userDTO) {

        User user = userMapper.UserDTOtoUser(userDTO);
        if (userRepository.findByUsername(userDTO.getName()).isPresent()) throw new NotFoundException("user already "
                                                                                                      + "exists");
        Set<String> strRoles = userDTO.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByType(RoleType.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByType(RoleType.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByType(RoleType.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByType(RoleType.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        user.setPassword(encoder.encode(userDTO.getPassword()));

        return userMapper.UserTOUSerDTO(userRepository.save(user));
    }


    @Override
    public UserDTO checkLogincredentials(LoginDTO loginDTO) {
        if (loginDTO.getPassword() == null) throw new BadRequestException("Password not found");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        EcommUser ecommUser = (EcommUser) authentication.getPrincipal();
        List<String> roles = ecommUser.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        logger.info("user loggedIn with roles:{}",roles);
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(ecommUser.getUsername());
        userDTO.setAuthToken(jwt);
        return userDTO;
//        Optional<User> userOptional= userRepository.findByUsername(loginDTO.getUsername());
//        if (userOptional.isPresent()) {
//
//            if (userOptional.get().getPassword().equals(loginDTO.getPassword())) {
//                return userMapper.UserTOUSerDTO(userOptional.get()) ;
//            }
//            else throw new NotFoundException("Incorrect password");
//        }
//        throw new NotFoundException("User doesn't exist");
    }

    @Override
    public User findByUserName(String name) {
        Optional<User> userOptional = userRepository.findByUsername(name);
        return userOptional.orElse(null);
    }

    @Override
    public UserDTO generateOTP(OtpDTO otpDTO) {
        int otp = new Random().nextInt((9999 - 100) + 1) + 10;
        System.out.println(otp + "OTP");
        Optional<User> userOptional = userRepository.findByPhoneNo(otpDTO.getPhoneNo());
        if (!userOptional.isPresent()) throw new NotFoundException("user is not registered with given phone number");
        User user = userOptional.get();
        user.setOtp(otp);
        User usernew = userRepository.save(user);
        return userMapper.UserTOUSerDTO(usernew);
    }

    @Override
    public UserDTO validateOTP(OtpDTO otpDTO) {
        Optional<User> userOptional = userRepository.findByPhoneNo(otpDTO.getPhoneNo());
        User user = userOptional.get();
        if (user.getOtp() == otpDTO.getOtp()) return userMapper.UserTOUSerDTO(user);
        throw new NotFoundException("Incorrect OTP");
    }


}
