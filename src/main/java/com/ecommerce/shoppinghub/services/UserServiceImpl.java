package com.ecommerce.shoppinghub.services;

import com.ecommerce.shoppinghub.DTO.LoginDTO;
import com.ecommerce.shoppinghub.DTO.OtpDTO;
import com.ecommerce.shoppinghub.DTO.UserDTO;
import com.ecommerce.shoppinghub.command.LoginUserCommand;
import com.ecommerce.shoppinghub.command.UserCommand;
import com.ecommerce.shoppinghub.domain.Type;
import com.ecommerce.shoppinghub.domain.User;
import com.ecommerce.shoppinghub.exceptions.BadRequestException;
import com.ecommerce.shoppinghub.exceptions.NotFoundException;
import com.ecommerce.shoppinghub.mapper.UserMapper;
import com.ecommerce.shoppinghub.repositories.TypeRepository;
import com.ecommerce.shoppinghub.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService
{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final TypeRepository typeRepository;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, TypeRepository typeRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.typeRepository = typeRepository;
    }


    @Override
    public UserDTO addNewUser(UserDTO userDTO)
    {

        User user=userMapper.UserDTOtoUser(userDTO);
        if(userRepository.findByName(userDTO.getName())!=null)
            throw new NotFoundException("user already exists");
        Type type =typeRepository.findByValue("User");
        user.setTypeid(type.getId());
        return userMapper.UserTOUSerDTO(userRepository.save(user));
    }


    @Override
    public Long  checkLogincredentials(LoginDTO loginDTO)
    {
        if(loginDTO.getPassword()==null)
            throw new BadRequestException("Password not found");
        User user=userRepository.findByName(loginDTO.getName());
        if(user!=null)
        {
            if(user.getPassword().equals(loginDTO.getPassword()))
            {
                return user.getId();
            }
            else
                throw new NotFoundException("Incorrect password");
        }
        throw new NotFoundException("User doesn't exist");
    }

    @Override
    public User findByUserName(String name) {
        User user=userRepository.findByName(name);
        return user;
    }

    @Override
    public UserDTO generateOTP(OtpDTO otpDTO) {
        int otp = new Random().nextInt((9999 - 100) + 1) + 10;
        System.out.println(otp+"OTP");
        User user=userRepository.findByPhoneNo(otpDTO.getPhoneNo());
        if(user==null)
            throw new NotFoundException("user is not registered with given phone number");
        user.setOtp(otp);
        User usernew=userRepository.save(user);
        return userMapper.UserTOUSerDTO(usernew);
    }

    @Override
    public UserDTO validateOTP(OtpDTO otpDTO) {
        User user=userRepository.findByPhoneNo(otpDTO.getPhoneNo());
      if (user.getOtp()==otpDTO.getOtp())
        return userMapper.UserTOUSerDTO(user);
        throw new NotFoundException("Incorrect OTP");
    }


}
