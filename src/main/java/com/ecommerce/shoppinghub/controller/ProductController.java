package com.ecommerce.shoppinghub.controller;

import com.ecommerce.shoppinghub.DTO.ListProductDTO;
import com.ecommerce.shoppinghub.DTO.ProductDTO;
import com.ecommerce.shoppinghub.domain.Product;
import com.ecommerce.shoppinghub.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController
{
    ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService=productService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ListProductDTO getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProduct(@PathVariable String id)
    {
        return productService.getProductById(new Long(id));
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO addProduct(@RequestBody  ProductDTO productDTO)
    {
        return productService.addProduct(productDTO);
    }

}
