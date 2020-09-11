package com.ecommerce.shoppinghub.DTO;

import com.ecommerce.shoppinghub.domain.PhysicalItem;
import lombok.Data;

import java.util.List;

@Data
public class ItemPhysicalItemDTO
{
    private Long id;
    private String itemName;
    private Long quantity;
    private Long price;
    private String capacity;
    private List<PhysicalItem> physicalItemList;

}
