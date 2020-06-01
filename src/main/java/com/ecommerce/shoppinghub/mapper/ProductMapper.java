package com.ecommerce.shoppinghub.mapper;

import com.ecommerce.shoppinghub.DTO.ProductDTO;
import com.ecommerce.shoppinghub.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper
{
    ProductMapper INSTANCE= Mappers.getMapper(ProductMapper.class);

    public ProductDTO convertProductToProductDTO(Product product);
    public Product convertProductDTOToProduct(ProductDTO productDTO);
}
