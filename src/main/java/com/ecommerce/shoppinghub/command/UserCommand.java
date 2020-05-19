package com.ecommerce.shoppinghub.command;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
public class UserCommand
{
    private Long id;
    private String name;
    private String address;
    private String phoneNo;
    private String password;
    private String Email;
    private int typeid;

}
