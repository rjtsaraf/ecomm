package com.ecommerce.shoppinghub.services;


import com.ecommerce.shoppinghub.DTO.ItemDTO;
import com.ecommerce.shoppinghub.DTO.ListItemDTO;
import com.ecommerce.shoppinghub.domain.Item;
import com.ecommerce.shoppinghub.domain.PhysicalItem;
import com.ecommerce.shoppinghub.exceptions.NotFoundException;
import com.ecommerce.shoppinghub.mapper.ItemMapper;
import com.ecommerce.shoppinghub.repositories.ItemRepository;
import com.ecommerce.shoppinghub.repositories.PhysicalItemRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ItemServiceImpl  implements ItemService
{
    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;
    private final PhysicalItemRepository physicalItemRepository;

    public ItemServiceImpl(ItemMapper itemMapper, ItemRepository itemRepository, PhysicalItemRepository physicalItemRepository) {
        this.itemMapper = itemMapper;
        this.itemRepository = itemRepository;
        this.physicalItemRepository = physicalItemRepository;
    }


    @Override
    public ItemDTO addItem(ItemDTO itemDTO)
    {
        Item item=itemRepository.save(itemMapper.convertItemDTOToItem(itemDTO));
        for(int i=0;i<itemDTO.getQuantity();i++)
        {
            physicalItemRepository.save(new PhysicalItem(item.getId(),itemDTO.getPrice(),"available"));
        }

        return itemMapper.convertItemToItemDTO(item);
    }

    @Override
    public ListItemDTO viewAllItems()
    {
        return  new ListItemDTO( itemRepository.findAll()
                .stream()
                .map(item -> itemMapper.convertItemToItemDTO(item))
                .collect(Collectors.toList()));

    }

    @Override
    public ItemDTO updateItembyQuantity(ItemDTO itemDTO)
    {
        Item item=itemRepository.findItemByPidAndCapacity(itemDTO.getPid(),itemDTO.getCapacity());
        item.setPrice(itemDTO.getPrice());
        item.setQuantity(item.getQuantity()+itemDTO.getQuantity());
        for(int i=0;i<itemDTO.getQuantity();i++)
            physicalItemRepository.save(new PhysicalItem(item.getId(),itemDTO.getPrice(),"available"));
        return itemMapper.convertItemToItemDTO(itemRepository.save(item));

    }

    @Override
    public ListItemDTO findItemByProductId(Long id) {
         return new ListItemDTO(itemRepository.findByPid(id).stream()
                .map(item ->
                 itemMapper.convertItemToItemDTO(item)
                ).collect(Collectors.toList()));
    }


}
