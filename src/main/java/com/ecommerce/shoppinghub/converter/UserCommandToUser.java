package com.ecommerce.shoppinghub.converter;

import com.ecommerce.shoppinghub.command.UserCommand;
import com.ecommerce.shoppinghub.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserCommandToUser implements Converter<UserCommand, User>
{

    @Override
    public User convert(UserCommand userCommand) {
        if(userCommand==null)
            return null;

        User user=new User();
        user.setId(userCommand.getId());
        user.setUsername(userCommand.getName());
        user.setPhoneNo(userCommand.getPhoneNo());
        user.setEmail(userCommand.getEmail());
        user.setPassword(userCommand.getPassword());
        user.setAddress(userCommand.getAddress());
        return user;
    }
}