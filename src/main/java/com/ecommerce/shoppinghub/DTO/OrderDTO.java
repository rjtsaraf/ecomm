package com.ecommerce.shoppinghub.DTO;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO
{
    private Long userid;
    private List<ItemDTO> itemDTOList;


}
