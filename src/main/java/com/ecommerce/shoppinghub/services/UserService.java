package com.ecommerce.shoppinghub.services;

import com.ecommerce.shoppinghub.DTO.LoginDTO;
import com.ecommerce.shoppinghub.DTO.OtpDTO;
import com.ecommerce.shoppinghub.DTO.UserDTO;
import com.ecommerce.shoppinghub.command.LoginUserCommand;
import com.ecommerce.shoppinghub.command.UserCommand;
import com.ecommerce.shoppinghub.domain.User;
import javassist.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService
{
    public UserDTO addNewUser(UserDTO  userDTO) throws NotFoundException;
    public Long  checkLogincredentials(LoginDTO loginDTO);
    public User findByUserName(String name);
    public UserDTO generateOTP(OtpDTO otpDTO);
    public UserDTO validateOTP(OtpDTO otpDTO);
}
