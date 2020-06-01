package com.ecommerce.shoppinghub.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderplacedDTO
{
    private Long orderid;
    private Long userid;
    private Long Amount;
    private LocalDateTime time;

}
