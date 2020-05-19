package com.ecommerce.shoppinghub.controller;

import com.ecommerce.shoppinghub.command.LoginUserCommand;
import com.ecommerce.shoppinghub.command.UserCommand;
import com.ecommerce.shoppinghub.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController
{
    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @RequestMapping("/register")
    public String CreateNewUser(Model model)
    {
        model.addAttribute("UserForm",new UserCommand());
        return "registerForm";
    }

    @PostMapping
    @RequestMapping("/register/")
    @ResponseBody
    public String CreateNewUser( @ModelAttribute("UserForm") UserCommand  userCommand)
    {
        UserCommand userCommand1=userService.addNewUser(userCommand);
       /* if(userCommand!=null)*/

        return "hello";
    }

    @GetMapping
    @RequestMapping("/login")
    public String LoginUser(Model model)
    {
        model.addAttribute("LoginForm",new LoginUserCommand());
        return  "Login";
    }

    @PostMapping
    @RequestMapping("/login/")
    @ResponseBody
    public String LoginUser( @ModelAttribute("LoginForm") LoginUserCommand  loginUserCommand)
    {
       Long id=userService.checkLogincredentials(loginUserCommand);
       if(id!=null)
        return "loggedin";
       else
           return "user doesn't exist with this id and password";
    }

    @PostMapping
    @RequestMapping("/exist/{username}")
    @ResponseBody
    public int CheckExisitingUser(@PathVariable("username") String username)
    {
        if(userService.findByUserName(username)!=null)
            return 1;
        return 0;
    }
}
