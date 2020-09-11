package com.ecommerce.shoppinghub.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
public class Item extends Base
{

    private Long pid;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="pid")
//    private Product product;

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
