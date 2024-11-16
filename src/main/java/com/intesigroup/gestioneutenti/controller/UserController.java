package com.intesigroup.gestioneutenti.controller;

import com.intesigroup.gestioneutenti.dto.UserDtoIn;
import com.intesigroup.gestioneutenti.entity.User;
import com.intesigroup.gestioneutenti.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final UserService utenteService;

    @GetMapping
    @ResponseBody
    public List<User> listaUtenti() {
        return utenteService.userList();
    }

    @GetMapping("{id}")
    @ResponseBody
    public User getUtente(@PathVariable Long id) {
        return utenteService.getUser(id);
    }

    @PostMapping
    @ResponseBody
    public User createUtente(@RequestBody UserDtoIn user) {
        return utenteService.addUser(user);
    }

    @PutMapping("{id}")
    @ResponseBody
    public User updateUtente(@RequestBody UserDtoIn user, @PathVariable Long id) throws BadRequestException {
        return utenteService.updateUser(user, id);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public void deleteUtente(@PathVariable Long id) throws BadRequestException {
        utenteService.deleteUser(id);
    }

}
