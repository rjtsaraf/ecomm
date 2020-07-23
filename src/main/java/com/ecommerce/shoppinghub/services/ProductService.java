package com.ecommerce.shoppinghub.services;

import com.ecommerce.shoppinghub.DTO.ListProductDTO;
import com.ecommerce.shoppinghub.DTO.ProductDTO;

public interface ProductService
{
    ProductDTO addProduct(ProductDTO productDTO);
    ListProductDTO getAllProducts();
    ProductDTO getProductById(Long id);
    ProductDTO updateProduct(ProductDTO productDTO);
}
