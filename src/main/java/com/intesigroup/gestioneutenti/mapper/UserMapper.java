package com.intesigroup.gestioneutenti.mapper;

import com.intesigroup.gestioneutenti.dto.UserDtoIn;
import com.intesigroup.gestioneutenti.entity.User;

public class UserMapper {

    public static User userDtoInToUser(UserDtoIn userDtoIn) {
        User user = new User();

        user.setUsername(userDtoIn.getUsername());
        user.setEmail(userDtoIn.getEmail());
        user.setRoles(userDtoIn.getRoles());

        return user;
    }

}
