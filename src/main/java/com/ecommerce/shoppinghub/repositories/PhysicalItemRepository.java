package com.ecommerce.shoppinghub.repositories;

import com.ecommerce.shoppinghub.domain.PhysicalItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhysicalItemRepository extends JpaRepository<PhysicalItem,Long>
{
    @Query("select p from PhysicalItem p where p.id=?1 and p.status=?2 limit ?3")
    public List<PhysicalItem> findPhysicalItem(Long itemid,String status,Long quantity);
}