package com.ecommerce.shoppinghub.DTO;

import com.ecommerce.shoppinghub.domain.Item;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
public class ItemDTO
{
    private Long id;
    @NotBlank(groups = ProductDTO.Create.class, message = "product code can not be null")
    private String itemName;
    private Long pid;
    private Long quantity;
    @NotBlank
    private Long price;
    @NotBlank(groups = ProductDTO.Create.class, message = "product code can not be null")

    private String capacity;
    private Long adminId;
    private boolean isDeleted;

}
