package com.ecommerce.shoppinghub.services;


import com.ecommerce.shoppinghub.DTO.ItemDTO;
import com.ecommerce.shoppinghub.DTO.ListItemDTO;

public interface ItemService
{
    public ItemDTO addItem(ItemDTO itemDTO);
    public ListItemDTO viewAllItems();
    public ItemDTO updateItembyQuantity(ItemDTO itemDTO);
    public ListItemDTO findItemByProductId(Long id);

}
