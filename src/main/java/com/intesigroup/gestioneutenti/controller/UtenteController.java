package com.intesigroup.gestioneutenti.controller;

import com.intesigroup.gestioneutenti.entity.User;
import com.intesigroup.gestioneutenti.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UtenteController {

    private final UserService utenteService;

    @GetMapping
    public List<User> listaUtenti() {
        return utenteService.userList();
    }

    @GetMapping("{id}")
    public User getUtente(@PathVariable Long id) {
        return utenteService.getUser(id);
    }

}
