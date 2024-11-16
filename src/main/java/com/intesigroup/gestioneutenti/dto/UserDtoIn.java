package com.intesigroup.gestioneutenti.dto;

import com.intesigroup.gestioneutenti.entity.Role;

import java.util.List;

public record UserDtoIn(String username, String email, List<Role> roles) {

}
