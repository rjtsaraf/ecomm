package com.ecommerce.shoppinghub.controller;

import com.ecommerce.shoppinghub.DTO.LoginDTO;
import com.ecommerce.shoppinghub.DTO.OtpDTO;
import com.ecommerce.shoppinghub.DTO.UserDTO;
import com.ecommerce.shoppinghub.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Virender Bhargav
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private  final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createNewUser(@RequestBody UserDTO userDTO) throws javassist.NotFoundException {
        UserDTO userDTO1=userService.addNewUser(userDTO);
        /* if(userCommand!=null)*/
        return userDTO1;
    }

    @PostMapping("/login")
    @ResponseBody
    public UserDTO LoginUser( @RequestBody LoginDTO loginDTO)
    {

        UserDTO userDTO =userService.checkLogincredentials(loginDTO);
        return userDTO;


    }
    @PostMapping("/generateOTP/")
    @ResponseBody
    public OtpDTO GenerateOTP(@RequestBody OtpDTO otpRequest)
    {
        return userService.generateOTP(otpRequest);
    }


    @PostMapping("/validateOTP/")
    @ResponseBody
    public UserDTO ValidateOTP(@RequestBody OtpDTO otpDTO)
    {
        return userService.validateOTP(otpDTO);

    }
}
