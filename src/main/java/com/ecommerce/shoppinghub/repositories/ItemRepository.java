package com.ecommerce.shoppinghub.repositories;

import com.ecommerce.shoppinghub.DTO.ItemProductDTO;
import com.ecommerce.shoppinghub.domain.Item;
import com.ecommerce.shoppinghub.vo.ItemProductVo;
import com.ecommerce.shoppinghub.vo.ItemVo;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface ItemRepository extends JpaRepository<Item, Long>
{
    @Query("select i from Item i where i.pid = ?1 and i.capacity= ?2")
    Item findItemByPidAndCapacity(Long pid, String capacity);

    @Query("select i from Item i where i.pid = :pid and i.capacity= :cap")
    Item findItemByPidAndCapacity2(@Param(value = "pid") Long pid,
                                   @Param(value = "cap") String capacity);

    public List<Item> findByPid(Long id);
    Optional<Item> findItemByPidAndIsDeleted(Long pid, boolean isDeleted);
    Optional<Item> findItemByIdAndIsDeleted(Long id,boolean isDeleted);


    List<Item> findAllByIsDeleted(boolean isDeleted);

    List<Item> findAllByIsDeleted(boolean isDeleted, Sort sort);

 //   @Query("select item.id,item.itemName from item inner join item.product.id on item.pid=item.product.id where item.product.isDeleted=false and item.isDeleted=false")
    @Query("select i from Item i")
    Page<Item> findAll(Pageable pageable);
    //List<Item> findAll(Sort sort);

    @Query(value = "select i.id as id,i.itemName as itemName," +
            "i.pid as pid ,i.capacity as capacity , i.price as price," +
            " i.quantity as quantity from Item i Join Product p  " +
            "on i.pid=p.id where  i.isDeleted=false and p.isDeleted=false")
    List<ItemProductVo> findAllItem();

    @Query("select i.id as id,i.itemName as itemName, i.pid as pid ,i.price as price " +
            ",i.capacity as capacity ,i.quantity as quantity " +
            "from Item i Join Product p on i.pid=p.id" +
            " where i.id=:Id and i.isDeleted=:ItemDeleted and p.isDeleted=:ItemDeleted ")
    ItemVo findItemProductByIdAndIsDeleted(@Param(value="Id") Long id, @Param( value="ItemDeleted") boolean isDeleted);




}
