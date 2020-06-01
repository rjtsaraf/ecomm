package com.ecommerce.shoppinghub.repositories;

import com.ecommerce.shoppinghub.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Orders,Long>
{
}
