package com.ecommerce.shoppinghub.controller;

import com.ecommerce.shoppinghub.DTO.ListProductDTO;
import com.ecommerce.shoppinghub.DTO.ProductDTO;
import com.ecommerce.shoppinghub.domain.Product;
import com.ecommerce.shoppinghub.services.EcommUser;
import com.ecommerce.shoppinghub.services.ProductService;
import com.ecommerce.shoppinghub.utils.SecurityContextUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ProductDTO addProduct(@RequestBody  ProductDTO productDTO)
    {
        EcommUser loggedInUser = SecurityContextUtil.getLoggedInUser();
        Long id = loggedInUser.getId();
        productDTO.setAdmin_id(id);
        return productService.addProduct(productDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO updateProduct(@PathVariable String id,  @RequestBody ProductDTO productDTO)
    {

        EcommUser loggedInUser=SecurityContextUtil.getLoggedInUser();
        Long productId= loggedInUser.getId();
        productDTO.setAdmin_id(productId);
        productDTO.setId(productId);
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO deleteProduct(@PathVariable String id)
    {
        return new ProductDTO();
    }
}
