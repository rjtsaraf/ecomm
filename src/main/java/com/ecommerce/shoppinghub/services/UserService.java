package com.ecommerce.shoppinghub.services;

import com.ecommerce.shoppinghub.command.LoginUserCommand;
import com.ecommerce.shoppinghub.command.UserCommand;
import com.ecommerce.shoppinghub.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService
{
    public UserCommand addNewUser(UserCommand  userCommand);
    public Long  checkLogincredentials(LoginUserCommand loginUserCommand);
    public User findByUserName(String name);
}
