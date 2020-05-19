package com.ecommerce.shoppinghub.repositories;

import com.ecommerce.shoppinghub.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type,Integer>
{
    public Type findByValue(String value);
}
