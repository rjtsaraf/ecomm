package com.ecommerce.shoppinghub.repositories;

import com.ecommerce.shoppinghub.DTO.OrdersListDTO;
import com.ecommerce.shoppinghub.domain.OrderItem;
import com.ecommerce.shoppinghub.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface OrderRepository extends JpaRepository<Orders,Long>
{
    //Orders findAllOrders();
    //Query("select ")
    //OrdersListDTO findOrderById(@long id);
}
