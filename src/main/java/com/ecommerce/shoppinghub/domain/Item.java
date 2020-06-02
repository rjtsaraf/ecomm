package com.ecommerce.shoppinghub.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
public class Item extends Base
{
    private Long pid;
    private Long quantity;
    private Long price;
    private String capacity;

}
