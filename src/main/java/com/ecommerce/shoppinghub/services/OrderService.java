package com.ecommerce.shoppinghub.services;

import com.ecommerce.shoppinghub.DTO.OrderDTO;
import com.ecommerce.shoppinghub.DTO.OrderplacedDTO;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

public interface OrderService
{
     OrderplacedDTO orderItems(OrderDTO orderDTO);
}
