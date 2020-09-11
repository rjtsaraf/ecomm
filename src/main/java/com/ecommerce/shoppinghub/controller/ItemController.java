package com.ecommerce.shoppinghub.controller;

import com.ecommerce.shoppinghub.DTO.ItemDTO;
import com.ecommerce.shoppinghub.DTO.ListItemDTO;
import com.ecommerce.shoppinghub.DTO.ItemPhysicalItemDTO;
import com.ecommerce.shoppinghub.services.EcommUser;
import com.ecommerce.shoppinghub.services.ItemService;
import com.ecommerce.shoppinghub.utils.SecurityContextUtil;
import com.ecommerce.shoppinghub.vo.ItemProductVo;
import com.ecommerce.shoppinghub.vo.ItemVo;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController
{
    private final ItemService itemService;


    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/withoutProductDetail")
    @ResponseStatus(HttpStatus.OK)
    public ListItemDTO getAllItem(Pageable pageable)
    {
        //localhost:8080/api/v1/item/?sort=quantity&page=0&size=10
        return itemService.viewAllItems(pageable);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemProductVo> getItemProductDetail()
    {
        return itemService.getItemProductList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ItemVo getItem(@PathVariable String id)
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

    @PutMapping("updateQuantity/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO updateItemByQuantity(@PathVariable String id, @RequestBody ItemDTO itemDTO)
    {

        itemDTO.setId(new Long(id));
        return itemService.updateItemByQuantity(itemDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO updateItem(@PathVariable String id, @RequestBody ItemDTO itemDTO)
    {

        itemDTO.setId(new Long(id));
        return itemService.updateItemNotQuantity(itemDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable String id)
    {
        itemService.deleteItem(new Long(id));
    }



     @GetMapping("/withPhysicalItemDetail")
     @ResponseStatus(HttpStatus.OK)
     public List<ItemPhysicalItemDTO> getItemPhysicalItemDetails(){ return itemService.getItemPhysicalItemList();}

}

