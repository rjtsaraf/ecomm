package com.ecommerce.shoppinghub.controller;

import com.ecommerce.shoppinghub.DTO.ListProductDTO;
import com.ecommerce.shoppinghub.DTO.ProductDTO;
import com.ecommerce.shoppinghub.services.EcommUser;
import com.ecommerce.shoppinghub.services.ProductService;
import com.ecommerce.shoppinghub.utils.SecurityContextUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
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
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO addProduct(@RequestBody @Validated(ProductDTO.Create.class) ProductDTO productDTO)
    {
        EcommUser loggedInUser = SecurityContextUtil.getLoggedInUser();
        Long id = loggedInUser.getId();
        productDTO.setAdminId(id);
        return productService.addProduct(productDTO);
    }

    @PutMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO updateProduct(@PathVariable String id,  @RequestBody @Validated(ProductDTO.Update.class)  ProductDTO productDTO)
    {
        productDTO.setId(new Long(id));
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable String id)
    {
         productService.deleteProduct(new Long(id));
    }
}
