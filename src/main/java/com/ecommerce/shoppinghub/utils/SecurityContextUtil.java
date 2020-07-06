package com.ecommerce.shoppinghub.utils;

import com.ecommerce.shoppinghub.services.EcommUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Virender Bhargav
 */
public class SecurityContextUtil {
    /**
     * Get the already authenticated EcommUser from the spring security security context
     *
     * @return
     */
    public static EcommUser getLoggedInUser() {
        return (EcommUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
