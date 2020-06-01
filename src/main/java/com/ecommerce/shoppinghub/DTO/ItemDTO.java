package com.ecommerce.shoppinghub.DTO;

import lombok.Data;

@Data
public class ItemDTO
{
    private Long id;
    private Long pid;
    private Long quantity;
    private Long price;
    private String capacity;

}
