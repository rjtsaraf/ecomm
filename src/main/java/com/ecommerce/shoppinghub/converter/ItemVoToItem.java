package com.ecommerce.shoppinghub.converter;

import com.ecommerce.shoppinghub.command.UserCommand;
import com.ecommerce.shoppinghub.domain.Item;
import com.ecommerce.shoppinghub.domain.User;
import com.ecommerce.shoppinghub.vo.ItemVo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemVoToItem implements Converter<ItemVo,Item>
{
    @Override
    public Item convert(ItemVo itemVo) {
        if(itemVo==null)
            return null;

       Item item=new Item();
       item.setId(itemVo.getId());
       item.setItemName(itemVo.getItemName());
       item.setPid(itemVo.getPid());
       item.setPrice(itemVo.getPrice());
       item.setQuantity(itemVo.getQuantity());
       item.setCapacity(itemVo.getCapacity());

        return item;
    }
}
