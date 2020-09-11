package com.ecommerce.shoppinghub.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Product extends Base
{
    private String productName;
    private String productCode;
    private Long adminId;
//    @OneToMany(mappedBy = "product")
//    private Set<Item> itemSet;
}
