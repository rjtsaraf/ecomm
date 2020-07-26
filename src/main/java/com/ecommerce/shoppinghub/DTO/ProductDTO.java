package com.ecommerce.shoppinghub.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProductDTO
{
    private Long id;
    private Long admin_id;
    private String product_name;
    @NotBlank(groups = Create.class, message = "product code can not be null")
    private String product_code;
    private boolean isDeleted;

    /**
     * This interface is used as a group for validating update of Existing instances.
     */
    public interface Update {
    }

    /**
     * This interface is used as a group for validating creation of New instances.
     */
    public interface Create {
    }
}
