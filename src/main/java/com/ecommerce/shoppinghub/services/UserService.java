package com.ecommerce.shoppinghub.services;

import com.ecommerce.shoppinghub.DTO.LoginDTO;
import com.ecommerce.shoppinghub.DTO.OtpDTO;
import com.ecommerce.shoppinghub.DTO.UserDTO;
import com.ecommerce.shoppinghub.domain.User;
import javassist.NotFoundException;

public interface UserService
{
    UserDTO addNewUser(UserDTO  userDTO) throws NotFoundException;
    UserDTO  checkLogincredentials(LoginDTO loginDTO);
    User findByUserName(String name);
    UserDTO generateOTP(OtpDTO otpDTO);
    UserDTO validateOTP(OtpDTO otpDTO);
}
