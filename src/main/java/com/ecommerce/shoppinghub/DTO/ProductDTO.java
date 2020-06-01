package com.ecommerce.shoppinghub.DTO;

import lombok.Data;

@Data
public class ProductDTO
{
    private Long id;
    private Long admin_id;
    private String product_name;
    private String product_code;
}
