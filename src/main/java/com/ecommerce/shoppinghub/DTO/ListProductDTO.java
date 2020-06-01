package com.ecommerce.shoppinghub.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListProductDTO
{
    private List<ProductDTO> productDTOList;
}
