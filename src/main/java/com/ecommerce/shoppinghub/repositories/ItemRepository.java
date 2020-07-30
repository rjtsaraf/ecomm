package com.ecommerce.shoppinghub.repositories;

import com.ecommerce.shoppinghub.DTO.ItemDTO;
import com.ecommerce.shoppinghub.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ItemRepository extends JpaRepository<Item, Long>
{
    @Query("select i from Item i where i.pid = ?1 and i.capacity= ?2")
    Item findItemByPidAndCapacity(Long pid, String capacity);

    public List<Item> findByPid(Long id);
    Optional<Item> findItemByPidAndIsDeleted(Long pid, boolean isDeleted);
    Optional<Item> findItemByIdAndIsDeleted(Long id,boolean isDeleted);
}
