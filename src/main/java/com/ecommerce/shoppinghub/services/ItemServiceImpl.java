package com.ecommerce.shoppinghub.services;


import com.ecommerce.shoppinghub.DTO.ItemDTO;
import com.ecommerce.shoppinghub.DTO.ListItemDTO;
import com.ecommerce.shoppinghub.converter.ItemVoToItem;
import com.ecommerce.shoppinghub.domain.Item;
import com.ecommerce.shoppinghub.domain.PhysicalItem;
import com.ecommerce.shoppinghub.domain.Product;
import com.ecommerce.shoppinghub.exceptions.NotFoundException;
import com.ecommerce.shoppinghub.mapper.ItemMapper;
import com.ecommerce.shoppinghub.DTO.ItemPhysicalItemDTO;
import com.ecommerce.shoppinghub.repositories.ItemRepository;
import com.ecommerce.shoppinghub.repositories.PhysicalItemRepository;
import com.ecommerce.shoppinghub.repositories.ProductRepository;
import com.ecommerce.shoppinghub.vo.ItemProductVo;
import com.ecommerce.shoppinghub.vo.ItemVo;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl  implements ItemService
{
    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;
    private final ProductRepository productRepository;
    private final PhysicalItemRepository physicalItemRepository;
    private final ItemVoToItem itemVoToItem;


    public ItemServiceImpl(ItemMapper itemMapper,  ItemVoToItem itemVoToItem, ItemRepository itemRepository, ProductRepository productRepository, PhysicalItemRepository physicalItemRepository) {
        this.itemMapper = itemMapper;
        this.itemRepository = itemRepository;
        this.productRepository = productRepository;
        this.physicalItemRepository = physicalItemRepository;
        this.itemVoToItem=itemVoToItem;
       // this.itemPhysicalItemDTO = itemPhysicalItemDTO;
    }

    @Override
    public List<ItemProductVo> getItemProductList()
    {
        return itemRepository.findAllItem();
    }

    @Override
    public ListItemDTO viewAllItems(Pageable pageable)
    {
        return  new ListItemDTO( itemRepository.findAll(pageable)
                .stream()
                .map(itemMapper::convertItemToItemDTO)
                .collect(Collectors.toList()));

    }
    @Override
    public ItemVo getItem(Long id)
    {
        //Optional<Item> ItemOptional = itemRepository.findItemByIdAndIsDeleted(id,false);
        ItemVo itemVo=itemRepository.findItemProductByIdAndIsDeleted(id,false);
        if(itemVo==null)
            throw new NullPointerException("Item not found");

        return itemVo;
    }

    @Override
    public ItemDTO addItem(ItemDTO itemDTO)
    {
        Optional<Product> productOptional= productRepository.findByIdAndIsDeleted(itemDTO.getPid(),false);

        if(!productOptional.isPresent())
            throw new NotFoundException("No active Product found");
        Item item=itemRepository.save(itemMapper.convertItemDTOToItem(itemDTO));
        for(int i=0;i<itemDTO.getQuantity();i++)
        {
            physicalItemRepository.save(new PhysicalItem(item.getId(),itemDTO.getPrice(),"available"));
        }

        return itemMapper.convertItemToItemDTO(item);
    }

    @Override
    public ItemDTO updateItemNotQuantity(ItemDTO itemDTO)
    {
        ItemVo itemVo=itemRepository.findItemProductByIdAndIsDeleted(itemDTO.getId(),false);
        if(itemVo==null)
            throw new NullPointerException("Item not found");

        Item item = itemVoToItem.convert(itemVo);
        item.setItemName(itemDTO.getItemName());
        item.setPrice(itemDTO.getPrice());
        return itemMapper.convertItemToItemDTO(itemRepository.save(item));
    }

    @Override
    public ItemDTO updateItemByQuantity(ItemDTO itemDTO)
    {
        ItemVo itemVo=itemRepository.findItemProductByIdAndIsDeleted(itemDTO.getId(),false);
        if(itemVo==null)
            throw new NullPointerException("Item not found");

        Item item = itemVoToItem.convert(itemVo);
        item.setQuantity(item.getQuantity()+itemDTO.getQuantity());
       for(int i=0;i<itemDTO.getQuantity();i++)
           physicalItemRepository.save(new PhysicalItem(itemDTO.getId(),itemDTO.getPrice(),"available"));

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
    @Override
    public List<ItemPhysicalItemDTO> getItemPhysicalItemList()
    {
        List<Item> itemList=itemRepository.findAllByIsDeleted(false);
        List<PhysicalItem> physicalItemList=new ArrayList<>();
        List<ItemPhysicalItemDTO> itemPhysicalItemDTOS =new ArrayList<>();
        for(int i=0;i<itemList.size();i++)
        {
            ItemPhysicalItemDTO itemPhysicalItemDTO=new ItemPhysicalItemDTO();

            Item item = itemList.get(i);
            List<PhysicalItem> available = physicalItemRepository.findByItemIdAndStatus(item.getId(), "available");
            itemPhysicalItemDTO.setPhysicalItemList(available);
            itemPhysicalItemDTO.setId(item.getId());
            itemPhysicalItemDTO.setItemName(item.getItemName());
            itemPhysicalItemDTO.setPrice(item.getPrice());
            itemPhysicalItemDTO.setCapacity(item.getCapacity());
            itemPhysicalItemDTOS.add(itemPhysicalItemDTO);

        }
        return itemPhysicalItemDTOS;
    }


//    @Override
//    public ItemDTO updateItembyQuantity(ItemDTO itemDTO)
//    {
//        Optional<Product> optionalProduct=productRepository.findByIdAndIsDeleted(itemDTO.getPid(), false);
//        if(!optionalProduct.isPresent())
//            throw new NotFoundException("No active Item found");
//        Optional<Item> optionalItem =itemRepository.findItemByIdAndIsDeleted(itemDTO.getId(),false);
//        if(!optionalItem.isPresent())
//            throw new NotFoundException("No active Item found");
//        Item item=optionalItem.get();
//        item.setPrice(itemDTO.getPrice());
////        item.setQuantity(item.getQuantity()+itemDTO.getQuantity());
////        for(int i=0;i<itemDTO.getQuantity();i++)
////            physicalItemRepository.save(new PhysicalItem(itemDTO.getId(),itemDTO.getPrice(),"available"));
//        return itemMapper.convertItemToItemDTO(itemRepository.save(item));
//
//    }

//    @Override
//    public List<ItemPhysicalItemDTO> getItemPhysicalItemList() {
//        return null;
//    }


}
