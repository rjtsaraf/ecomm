package com.ecommerce.shoppinghub.repositories;

import com.ecommerce.shoppinghub.domain.PhysicalItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.method.P;

import java.util.List;

public interface PhysicalItemRepository extends JpaRepository<PhysicalItem,Long>
{
//    @Query("select p from PhysicalItem p where p.id=?1 and p.status=?2 limit ?3")
//    public List<PhysicalItem> findPhysicalItem(Long itemid,String status,Long quantity);
// Added a comment from mona soni

    List<PhysicalItem> findByItemIdAndStatus(Long itemid,String status);

    Page<PhysicalItem> findByItemIdAndStatus(Long itemid, String status, Pageable page);
    //OrderBy
    List<PhysicalItem> findByItemIdAndStatus(Long itemid, String status, Sort sort);

}
