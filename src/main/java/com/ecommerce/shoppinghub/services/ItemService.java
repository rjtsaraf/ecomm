package com.ecommerce.shoppinghub.services;


import com.ecommerce.shoppinghub.DTO.ItemDTO;
import com.ecommerce.shoppinghub.DTO.ListItemDTO;

public interface ItemService
{
    ItemDTO addItem(ItemDTO itemDTO);
    ListItemDTO viewAllItems();
    ItemDTO updateItembyQuantity(ItemDTO itemDTO);
    ListItemDTO findItemByProductId(Long id);
    ItemDTO getItem(Long id);
    void deleteItem(Long id);

}
