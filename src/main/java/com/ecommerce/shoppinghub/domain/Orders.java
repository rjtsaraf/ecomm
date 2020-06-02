package com.ecommerce.shoppinghub.domain;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Orders extends Base
{
    private Long userId;
    private Long amount;
    private boolean isPaid;
    private boolean isCancelled;
}