package com.ecommerce.shoppinghub.mapper;


import com.ecommerce.shoppinghub.DTO.ItemDTO;
import com.ecommerce.shoppinghub.domain.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemMapper
{
    ItemMapper Instance= Mappers.getMapper(ItemMapper.class);

    ItemDTO convertItemToItemDTO(Item item);
    Item convertItemDTOToItem(ItemDTO itemDTO);
}
