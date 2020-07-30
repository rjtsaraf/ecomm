package com.ecommerce.shoppinghub.services;


import com.ecommerce.shoppinghub.DTO.ItemDTO;
import com.ecommerce.shoppinghub.DTO.ListItemDTO;
import com.ecommerce.shoppinghub.domain.Item;
import com.ecommerce.shoppinghub.domain.PhysicalItem;
import com.ecommerce.shoppinghub.domain.Product;
import com.ecommerce.shoppinghub.exceptions.NotFoundException;
import com.ecommerce.shoppinghub.mapper.ItemMapper;
import com.ecommerce.shoppinghub.repositories.ItemRepository;
import com.ecommerce.shoppinghub.repositories.PhysicalItemRepository;
import com.ecommerce.shoppinghub.repositories.ProductRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl  implements ItemService
{
    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;
    private final ProductRepository productRepository;
    private final PhysicalItemRepository physicalItemRepository;

    public ItemServiceImpl(ItemMapper itemMapper, ItemRepository itemRepository, ProductRepository productRepository, PhysicalItemRepository physicalItemRepository) {
        this.itemMapper = itemMapper;
        this.itemRepository = itemRepository;
        this.productRepository = productRepository;
        this.physicalItemRepository = physicalItemRepository;
    }


    @Override
    public ItemDTO getItem(Long id)
    {
        Optional<Item> ItemOptional = itemRepository.findById(id);
        if(!ItemOptional.isPresent())
            throw new NotFoundException("Item not found");;
            Item item=ItemOptional.get();
            return itemMapper.convertItemToItemDTO(item);
    }

    @Override
    public ItemDTO addItem(ItemDTO itemDTO)
    {
        Optional<Product> productOptional= productRepository.findByIdAndIsDeleted(itemDTO.getPid(),false);

        if(!productOptional.isPresent())
            throw new NotFoundException("No active Item found");
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
                .map(itemMapper::convertItemToItemDTO)
                .collect(Collectors.toList()));

    }

    @Override
    public ItemDTO updateItembyQuantity(ItemDTO itemDTO)
    {
        Optional<Product> optionalProduct=productRepository.findByIdAndIsDeleted(itemDTO.getPid(), false);
        if(!optionalProduct.isPresent())
            throw new NotFoundException("No active Item found");
        Optional<Item> optionalItem =itemRepository.findItemByIdAndIsDeleted(itemDTO.getId(),false);
        if(!optionalItem.isPresent())
            throw new NotFoundException("No active Item found");
        Item item=optionalItem.get();
        item.setPrice(itemDTO.getPrice());
//        item.setQuantity(item.getQuantity()+itemDTO.getQuantity());
//        for(int i=0;i<itemDTO.getQuantity();i++)
//            physicalItemRepository.save(new PhysicalItem(itemDTO.getId(),itemDTO.getPrice(),"available"));
        return itemMapper.convertItemToItemDTO(itemRepository.save(item));

    }

    @Override
    public ListItemDTO findItemByProductId(Long id)
    {
         return new ListItemDTO(itemRepository.findByPid(id).stream()
                .map(item -> itemMapper.convertItemToItemDTO(item)
                ).collect(Collectors.toList()));
    }
    @Override
    public void deleteItem(Long id)
    {
        Optional<Item> optionalItem=itemRepository.findItemByIdAndIsDeleted(id, false);
        if(!optionalItem.isPresent())
            throw new NotFoundException("no active item found");
        Item item=optionalItem.get();
        item.setDeleted(true);
        itemRepository.save(item);
    }
}
