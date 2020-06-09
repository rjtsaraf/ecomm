package com.ecommerce.shoppinghub.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(	name = "user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username", name = "uniq_name"),
                @UniqueConstraint(columnNames = "email", name = "uniq_email")
        })
public class User extends  Base
{

    @NotBlank
    @Size(max = 20)
    private String username;

    @Size(max = 20)
    private String name;

    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    private String address;
    private String phoneNo;


    private int otp;
}
