package com.ecommerce.shoppinghub.services;


import com.ecommerce.shoppinghub.DTO.ItemDTO;
import com.ecommerce.shoppinghub.DTO.ListItemDTO;
import com.ecommerce.shoppinghub.DTO.ItemPhysicalItemDTO;
import com.ecommerce.shoppinghub.vo.ItemProductVo;
import com.ecommerce.shoppinghub.vo.ItemVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService
{
    ItemDTO addItem(ItemDTO itemDTO);
    ListItemDTO viewAllItems(Pageable pageable);
    ItemDTO updateItemNotQuantity(ItemDTO itemDTO);
    ListItemDTO findItemByProductId(Long id);
    ItemDTO updateItemByQuantity(ItemDTO itemDTO);
    ItemVo getItem(Long id);
    void deleteItem(Long id);

    List<ItemProductVo> getItemProductList();
     List<ItemPhysicalItemDTO> getItemPhysicalItemList();

}
