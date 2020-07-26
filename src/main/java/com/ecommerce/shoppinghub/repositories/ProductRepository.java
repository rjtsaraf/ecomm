package com.ecommerce.shoppinghub.repositories;

import com.ecommerce.shoppinghub.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>
{
    Optional<Product> findByIdAndIsDeleted(Long id, boolean isDeleted);
}
