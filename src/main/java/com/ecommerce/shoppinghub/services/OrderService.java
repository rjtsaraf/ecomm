package com.ecommerce.shoppinghub.services;

import com.ecommerce.shoppinghub.DTO.OrderDTO;
import com.ecommerce.shoppinghub.DTO.OrderplacedDTO;
import com.ecommerce.shoppinghub.DTO.OrdersListDTO;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.List;

public interface OrderService
{
     OrderplacedDTO orderItems(OrderDTO orderDTO);
     List<OrdersListDTO> viewAllOrders();
     OrdersListDTO getOrderById(long id);
}
