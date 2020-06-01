package com.ecommerce.shoppinghub.controller;

import com.ecommerce.shoppinghub.DTO.ItemDTO;
import com.ecommerce.shoppinghub.DTO.ListItemDTO;
import com.ecommerce.shoppinghub.DTO.ListProductDTO;
import com.ecommerce.shoppinghub.DTO.ProductDTO;
import com.ecommerce.shoppinghub.services.ItemService;
import com.ecommerce.shoppinghub.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecomm/Admin")
@ResponseBody
public class AdminController
{

    private  final ProductService productService;
    private final ItemService itemService;

    public AdminController(ProductService productService, ItemService itemService) {
        this.productService = productService;
        this.itemService = itemService;
    }


    @PostMapping("/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO addProduct(  @RequestBody  ProductDTO productDTO)
    {
       return productService.addProduct(productDTO);
    }

    @GetMapping("/viewProducts")
    @ResponseStatus(HttpStatus.OK)
    public ListProductDTO getAllProducts()
    {
        return productService.getAllProducts();
    }

    @PostMapping("/addItem")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO addItem(@RequestBody ItemDTO itemDTO)
    {
        return itemService.addItem(itemDTO);
    }

    @GetMapping("/viewItems")
    @ResponseStatus(HttpStatus.OK)
    public ListProductDTO getAllItems()
    {
        return productService.getAllProducts();
    }


    @PutMapping("/updateItem")
    @ResponseStatus(HttpStatus.OK)
    public ItemDTO updateItem(@RequestBody ItemDTO itemDTO)
    {
        return itemService.updateItembyQuantity(itemDTO);
    }

    @GetMapping("/findItemByPid")
    @ResponseStatus(HttpStatus.OK)
    public ListItemDTO findItemByProductId(@RequestParam  Long pid)
    {
        return itemService.findItemByProductId(pid);
    }

    @GetMapping("/viewAllItems")
    @ResponseStatus(HttpStatus.OK)
    public ListItemDTO viewAllItems()
    {
        return itemService.viewAllItems();
    }
}
