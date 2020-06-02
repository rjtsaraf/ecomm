package com.ecommerce.shoppinghub.repositories;

import com.ecommerce.shoppinghub.domain.Role;
import com.ecommerce.shoppinghub.domain.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Virender Bhargav
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByType(RoleType type);
}
