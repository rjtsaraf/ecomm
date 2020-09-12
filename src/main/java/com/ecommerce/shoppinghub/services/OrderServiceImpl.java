package com.ecommerce.shoppinghub.services;

import com.ecommerce.shoppinghub.DTO.ItemDTO;
import com.ecommerce.shoppinghub.DTO.ItemPlacedDTO;
import com.ecommerce.shoppinghub.DTO.OrderDTO;
import com.ecommerce.shoppinghub.DTO.OrderplacedDTO;
import com.ecommerce.shoppinghub.converter.ItemVoToItem;
import com.ecommerce.shoppinghub.domain.*;
import com.ecommerce.shoppinghub.exceptions.NotFoundException;
import com.ecommerce.shoppinghub.mapper.ItemMapper;
import com.ecommerce.shoppinghub.repositories.ItemRepository;
import com.ecommerce.shoppinghub.repositories.OrderItemRepository;
import com.ecommerce.shoppinghub.repositories.OrderRepository;
import com.ecommerce.shoppinghub.repositories.PhysicalItemRepository;
import com.ecommerce.shoppinghub.vo.ItemVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class  OrderServiceImpl implements  OrderService
{
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final PhysicalItemRepository physicalItemRepository;
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final ItemVoToItem itemVoToItem;

    public OrderServiceImpl(OrderRepository orderRepository,ItemVoToItem itemVoToItem, OrderItemRepository orderItemRepository, PhysicalItemRepository physicalItemRepository,ItemRepository itemRepository, ItemMapper itemMapper) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.physicalItemRepository = physicalItemRepository;
        this.itemRepository=itemRepository;
        this.itemMapper = itemMapper;
        this.itemVoToItem=itemVoToItem;
    }


    @Override
    public OrderplacedDTO orderItems(OrderDTO orderDTO)
    {
        List<ItemPlacedDTO> itemList=orderDTO.getItemplacedDTOList();
        List<PhysicalItem> physicalItems=new ArrayList<>();
        long amount=0L;
        for(int i=0;i<itemList.size();i++)
        {
            ItemVo itemVo= itemRepository.findItemProductByIdAndIsDeleted(itemList.get(i).getItemId(),false);
            if(itemVo==null)
                throw new NotFoundException("Item not found");
            amount+=(itemList.get(i).getQuantity()*itemVo.getPrice());
        }
        Orders order=new Orders();
        order.setAmount(amount);
        order.setPaid(true);
        order.setCancelled(false);
        order.setUserId(orderDTO.getUserid());
        Orders placedOrder=orderRepository.save(order);
        for(int i=0;i<orderDTO.getItemplacedDTOList().size();i++)
        {

            ItemVo itemVo= itemRepository.findItemProductByIdAndIsDeleted(itemList.get(i).getItemId(),false);
            int quantity=(int)itemList.get(i).getQuantity();
            //Item item=  itemMapper.convertItemDTOToItem( itemList.get(i));
////            List<PhysicalItem>  physicalItems1= physicalItemRepository.findPhysicalItem(item.getId(),"available",item.getQuantity());
            if(itemVo==null)
                throw new NotFoundException();
            if(itemVo.getQuantity()<itemList.get(i).getQuantity())
                throw new NotFoundException("Ordered Quantity not available");
          //  List<PhysicalItem>  physicalItemsList= physicalItemRepository.findByItemIdAndStatus(itemVo.getId(),"available");

            //Sort sort = Sort.by("itemId");
//            List<PhysicalItem>  physicalItems2= physicalItemRepository.findByItemIdAndStatus(itemVo.getId(),"available",sort);

            Pageable pageable= PageRequest.of(0,quantity);
            Page<PhysicalItem> physicalItemsPage= physicalItemRepository.findByItemIdAndStatus(itemVo.getId(),"available",pageable);
            List<PhysicalItem> l= physicalItemsPage.getContent();

            for(int j=0;j<l.size();j++)
            {
                l.get(j).setStatus("Sold Out");
                physicalItemRepository.save(l.get(j));
                OrderItem orderItem=new OrderItem();
                orderItem.setOrderId(placedOrder.getId());
                orderItem.setPhysicalId(l.get(j).getId());
                orderItem.setStatus(Status.ORDER_PLACED);
                orderItemRepository.save(orderItem);
            }
        }
        for(int i=0;i<itemList.size();i++)
        {
            ItemVo itemVo= itemRepository.findItemProductByIdAndIsDeleted(itemList.get(i).getItemId(),false);
            if(itemVo==null)
                throw new NotFoundException("Item not found");
            Item item= itemVoToItem.convert(itemVo);
            item.setQuantity(item.getQuantity()-itemList.get(i).getQuantity());
           itemRepository.save(item);
        }
        OrderplacedDTO orderplacedDTO=new OrderplacedDTO();
        orderplacedDTO.setAmount(amount);
        orderplacedDTO.setOrderid(placedOrder.getId());
        orderplacedDTO.setUserid(orderDTO.getUserid());
        //orderplacedDTO.setTime(new Date());
        return orderplacedDTO;

    }
}
