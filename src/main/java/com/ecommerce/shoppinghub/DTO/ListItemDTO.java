package com.ecommerce.shoppinghub.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class ListItemDTO
{
    List<ItemDTO> itemDTOList;
}
