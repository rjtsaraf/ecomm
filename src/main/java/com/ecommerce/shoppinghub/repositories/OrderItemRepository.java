package com.ecommerce.shoppinghub.repositories;

import com.ecommerce.shoppinghub.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository  extends JpaRepository<OrderItem,Long> {
}
