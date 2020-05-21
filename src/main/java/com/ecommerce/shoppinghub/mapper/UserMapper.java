package com.ecommerce.shoppinghub.mapper;


import com.ecommerce.shoppinghub.DTO.UserDTO;
import com.ecommerce.shoppinghub.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper
{
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public User UserDTOtoUser(UserDTO userDTO);
    public UserDTO UserTOUSerDTO(User user);

}
