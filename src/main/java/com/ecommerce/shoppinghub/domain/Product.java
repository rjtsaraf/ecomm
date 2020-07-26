package com.ecommerce.shoppinghub.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Product extends Base
{
    private String productName;
    private String productCode;
    private Long adminId;
}
