package com.ecommerce.shoppinghub.domain;


import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Product extends Base
{
    private String product_name;
    private String product_code;
    private Long admin_id;
}
