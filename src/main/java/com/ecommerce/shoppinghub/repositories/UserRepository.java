package com.ecommerce.shoppinghub.repositories;

import com.ecommerce.shoppinghub.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
    public User findByName(String Name);
    public User findByPhoneNo(String phoneNo);
}
