package com.ecommerce.shoppinghub.controller;

import com.ecommerce.shoppinghub.DTO.LoginDTO;
import com.ecommerce.shoppinghub.DTO.OtpDTO;
import com.ecommerce.shoppinghub.DTO.UserDTO;
import com.ecommerce.shoppinghub.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/ecomm/user/")
public class UserController
{
    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("register")
//    public String CreateNewUser(Model model)
//    {
//        model.addAttribute("UserForm",new UserCommand());
//        return "registerForm";
//    }

    @PostMapping("register/")
    @ResponseStatus(HttpStatus.CREATED)
    public String  CreateNewUser(@RequestBody UserDTO userDTO)
    {
        UserDTO userDTO1=userService.addNewUser(userDTO);
       /* if(userCommand!=null)*/

        if(userDTO1!=null)
            return userDTO1.getId()+"";
        return "Username already exists";
    }

   /* @GetMapping
    @RequestMapping("/login")
    public String LoginUser(Model model)
    {
        model.addAttribute("LoginForm",new LoginUserCommand());
        return  "Login";
    }*/

   /* @GetMapping
    @RequestMapping("/login/")
    @ResponseBody
    public String LoginUser( @ModelAttribute("LoginForm") LoginUserCommand  loginUserCommand)
    {
       Long id=userService.checkLogincredentials(loginUserCommand);
       if(id!=null)
        return "loggedin";
       else
           return "user doesn't exist with this id and password";
    }*/

   /* @PostMapping
    @RequestMapping("/exist/{username}")
    @ResponseBody
    public int CheckExisitingUser(@PathVariable("username") String username)
    {
        if(userService.findByUserName(username)!=null)
            return 1;
        return 0;
    }*/

    @GetMapping("/login/")
    @ResponseBody
    public String LoginUser( @RequestBody LoginDTO loginDTO)
    {
        Long id=userService.checkLogincredentials(loginDTO);
        if(id!=null)
            return "loggedin with id "+id;
        else
            return "user doesn't exist with this id and password";
    }
    @PutMapping("/generateOTP/")
    @ResponseBody
    public String GenerateOTP(@RequestBody OtpDTO otpDTO)
    {
        UserDTO userDTO=userService.generateOTP(otpDTO);
        if(userDTO!=null)
            return "OTP generated for id "+userDTO.getId();
        return "Phone Number is invalid";
    }

    @GetMapping("/validateOTP/")
    @ResponseBody
    public String ValidateOTP(@RequestBody OtpDTO otpDTO)
    {
        UserDTO userDTO=userService.validateOTP(otpDTO);
        if(userDTO!=null)
            return "loggedin with id "+userDTO.getId();
        return "Otp is invalid";
    }
}
