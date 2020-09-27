package com.ecommerce.shoppinghub.DTO;

import com.ecommerce.shoppinghub.domain.OrderItem;
import com.ecommerce.shoppinghub.domain.Status;
import lombok.Data;

import java.util.List;

@Data
public class OrdersListDTO
{
    private long orderId;
    private long amount;
    private List<OrderItem> orderedItem;
}
