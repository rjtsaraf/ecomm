package com.ecommerce.shoppinghub.converter;

import com.ecommerce.shoppinghub.command.UserCommand;
import com.ecommerce.shoppinghub.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserCommand implements Converter<User, UserCommand>
{

    @Override
    public UserCommand convert(User user) {
        if(user==null)
            return null;

        UserCommand userCommand=new UserCommand();
        userCommand.setId(user.getId());
        userCommand.setName(user.getUsername());
        userCommand.setPhoneNo(user.getPhoneNo());
        userCommand.setEmail(user.getEmail());
        userCommand.setPassword(user.getPassword());
        userCommand.setAddress(user.getAddress());
        return userCommand;
    }
}
