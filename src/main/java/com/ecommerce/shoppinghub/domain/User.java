package com.ecommerce.shoppinghub.domain;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import javax.persistence.*;
//comment
@Entity
@Data
public class User extends Base
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phoneNo;
    private String password;
    private String email;
    private int otp;
    private int typeid;
}
