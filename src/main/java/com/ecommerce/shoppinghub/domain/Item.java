package com.ecommerce.shoppinghub.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
public class Item extends Base
{
    private Long pid;
    @NotBlank
    @Size(max = 20)
    private String itemName;


    private Long quantity;
    private Long price;
    private String capacity;
    private Long adminId;

//    @ManyToOne
//    @JoinColumn(name="item_id")
//    private Product product;
}
