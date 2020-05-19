package com.ecommerce.shoppinghub.services;

import com.ecommerce.shoppinghub.command.LoginUserCommand;
import com.ecommerce.shoppinghub.command.UserCommand;
import com.ecommerce.shoppinghub.converter.UserCommandToUser;
import com.ecommerce.shoppinghub.converter.UserToUserCommand;
import com.ecommerce.shoppinghub.domain.Type;
import com.ecommerce.shoppinghub.domain.User;
import com.ecommerce.shoppinghub.repositories.TypeRepository;
import com.ecommerce.shoppinghub.repositories.UserRepository;
import org.omg.SendingContext.RunTime;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{

    private final UserRepository userRepository;
    private final UserToUserCommand userToUserCommand;
    private final UserCommandToUser userCommandToUser;
    private final TypeRepository typeRepository;



    public UserServiceImpl(UserRepository userRepository, UserToUserCommand userToUserCommand, UserCommandToUser userCommandToUser, TypeRepository typeRepository) {
        this.userRepository = userRepository;
        this.userToUserCommand = userToUserCommand;
        this.userCommandToUser = userCommandToUser;
        this.typeRepository = typeRepository;
    }

    @Override
    public UserCommand addNewUser(UserCommand userCommand)
    {

        User user=userCommandToUser.convert(userCommand);
        if(userRepository.findByName(userCommand.getName())!=null)
        {
            return new UserCommand();
        }
        Type type =typeRepository.findByValue("User");
        user.setTypeid(type.getId());
        return userToUserCommand.convert(userRepository.save(user));
    }

    @Override
    public Long  checkLogincredentials(LoginUserCommand loginUserCommand)
    {
        User user=userRepository.findByName(loginUserCommand.getName());
        if(user!=null)
        {
            if(user.getPassword().equals(loginUserCommand.getPassword()))
            {
                return user.getId();
            }
        }
        return null;
    }

    @Override
    public User findByUserName(String name) {
        User user=userRepository.findByName(name);
        return user;
    }
}
