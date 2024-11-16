package com.intesigroup.gestioneutenti.mapper;

import com.intesigroup.gestioneutenti.dto.UserDtoIn;
import com.intesigroup.gestioneutenti.entity.User;

public class UserMapper {

    public static User userDtoInToUser(UserDtoIn userDtoIn) {
        User user = new User();

        user.setUsername(userDtoIn.username());
        user.setEmail(userDtoIn.email());
        user.setRoles(userDtoIn.roles());

        return user;
    }

}
