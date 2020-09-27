package com.ecommerce.shoppinghub.controller;



import com.ecommerce.shoppinghub.DTO.OrderDTO;
import com.ecommerce.shoppinghub.DTO.OrderplacedDTO;
import com.ecommerce.shoppinghub.DTO.OrdersListDTO;
import com.ecommerce.shoppinghub.services.EcommUser;
import com.ecommerce.shoppinghub.services.ItemService;
import com.ecommerce.shoppinghub.services.OrderService;
import com.ecommerce.shoppinghub.utils.SecurityContextUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderplacedDTO addOrder(@RequestBody OrderDTO orderDTO)
    {
        EcommUser ecommUser= SecurityContextUtil.getLoggedInUser();
        orderDTO.setUserid(ecommUser.getId());
        return orderService.orderItems(orderDTO);
    }
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<OrdersListDTO> viewAllOrders()
    {
        return orderService.viewAllOrders();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrdersListDTO viewOrderById(@PathVariable long id)
    {
        return orderService.getOrderById(id);
    }

}
