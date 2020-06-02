package com.ecommerce.shoppinghub.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhysicalItem extends Base
{

    private Long itemId;
    private Long price;
    private String status;
}
