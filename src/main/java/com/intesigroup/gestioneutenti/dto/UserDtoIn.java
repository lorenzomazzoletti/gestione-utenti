package com.intesigroup.gestioneutenti.dto;

import com.intesigroup.gestioneutenti.entity.Role;
import lombok.Getter;

import java.util.List;

@Getter
public class UserDtoIn {

    private String username;
    private String email;
    private List<Role> roles;

}
