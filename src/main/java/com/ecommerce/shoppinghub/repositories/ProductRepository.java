package com.ecommerce.shoppinghub.repositories;

import com.ecommerce.shoppinghub.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
