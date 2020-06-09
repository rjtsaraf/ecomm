package com.ecommerce.shoppinghub.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO
{
    private Long id;
    private String username;
    private String authToken;
    private Set<String> role;
    private String name;
    private String address;
    private String phoneNo;
    private String password;
    private String email;
    private int otp;
}
