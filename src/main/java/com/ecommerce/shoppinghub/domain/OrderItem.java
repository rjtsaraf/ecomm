package com.ecommerce.shoppinghub.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem extends Base
{
    private Long OrderId;
    private Long PhysicalId;
    @Enumerated(value = EnumType.STRING)
    private Status status;
}
