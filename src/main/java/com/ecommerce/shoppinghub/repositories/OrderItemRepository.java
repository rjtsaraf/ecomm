package com.ecommerce.shoppinghub.repositories;

import com.ecommerce.shoppinghub.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository  extends JpaRepository<OrderItem,Long> {
    List<OrderItem> findAllByOrderId(long id);
}
