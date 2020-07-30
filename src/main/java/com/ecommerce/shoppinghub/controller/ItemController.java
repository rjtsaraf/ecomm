package com.ecommerce.shoppinghub.controller;

import com.ecommerce.shoppinghub.DTO.ItemDTO;
import com.ecommerce.shoppinghub.DTO.ListItemDTO;
import com.ecommerce.shoppinghub.services.EcommUser;
import com.ecommerce.shoppinghub.services.ItemService;
import com.ecommerce.shoppinghub.utils.SecurityContextUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController
{
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ListItemDTO getAllItem()
    {
        return itemService.viewAllItems();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ItemDTO getItem(@PathVariable String id)
    {
        return itemService.getItem(new Long(id));
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO addItem(@RequestBody ItemDTO itemDTO)
    {
        EcommUser ecommUser= SecurityContextUtil.getLoggedInUser();
        itemDTO.setAdminId(ecommUser.getId());
        return itemService.addItem(itemDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO updateItem(@PathVariable String id, @RequestBody ItemDTO itemDTO)
    {

        itemDTO.setId(new Long(id));
        return itemService.updateItembyQuantity(itemDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable String id)
    {
        itemService.deleteItem(new Long(id));
    }
}
