package com.ecommerce.shoppinghub.DTO;


import com.ecommerce.shoppinghub.domain.PhysicalItem;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class ItemProductDTO
{
    private Long id;

    private String itemName;
    private Long pid;
    private Long quantity;
    private Long price;
    private String capacity;
    private List<PhysicalItem> physicalItemList;
}
