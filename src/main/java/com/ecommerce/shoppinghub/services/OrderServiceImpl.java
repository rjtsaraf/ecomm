package com.ecommerce.shoppinghub.services;

import com.ecommerce.shoppinghub.DTO.ItemDTO;
import com.ecommerce.shoppinghub.DTO.OrderDTO;
import com.ecommerce.shoppinghub.DTO.OrderplacedDTO;
import com.ecommerce.shoppinghub.domain.Item;
import com.ecommerce.shoppinghub.domain.PhysicalItem;
import com.ecommerce.shoppinghub.mapper.ItemMapper;
import com.ecommerce.shoppinghub.repositories.OrderItemRepository;
import com.ecommerce.shoppinghub.repositories.OrderRepository;
import com.ecommerce.shoppinghub.repositories.PhysicalItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements  OrderService
{
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final PhysicalItemRepository physicalItemRepository;
    private final ItemMapper itemMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository, PhysicalItemRepository physicalItemRepository, ItemMapper itemMapper) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.physicalItemRepository = physicalItemRepository;
        this.itemMapper = itemMapper;
    }


    @Override
    public OrderplacedDTO orderItems(OrderDTO orderDTO)
    {
        Long Amount=0L;
        List<ItemDTO> itemList=orderDTO.getItemDTOList();
        List<PhysicalItem> physicalItems=new ArrayList<>();
        for(int i=0;i<orderDTO.getItemDTOList().size();i++)
        {
            Item item=  itemMapper.convertItemDTOToItem( itemList.get(i));
//            List<PhysicalItem>  physicalItems1= physicalItemRepository.findPhysicalItem(item.getId(),"available",item.getQuantity());
            List<PhysicalItem>  physicalItems1= physicalItemRepository.findByItemIdAndStatus(item.getId(),"available");

            Sort sort = Sort.by("itemId");
            List<PhysicalItem>  physicalItems2= physicalItemRepository.findByItemIdAndStatus(item.getId(),"available",sort);

            Pageable pageable= PageRequest.of(0,item.getQuantity().intValue());
            Page<PhysicalItem> physicalItemsPage= physicalItemRepository.findByItemIdAndStatus(item.getId(),"available",pageable);

            List<PhysicalItem> l= physicalItemsPage.getContent();
        }
        return null;

    }
}
