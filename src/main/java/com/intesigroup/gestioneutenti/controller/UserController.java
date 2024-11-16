package com.intesigroup.gestioneutenti.controller;

import com.intesigroup.gestioneutenti.dto.UserDtoIn;
import com.intesigroup.gestioneutenti.entity.User;
import com.intesigroup.gestioneutenti.exception.EmailAlreadyUsedException;
import com.intesigroup.gestioneutenti.exception.UserNotFoundException;
import com.intesigroup.gestioneutenti.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public User getUtente(@PathVariable Long id) throws UserNotFoundException {
        return utenteService.getUser(id);
    }

    @PostMapping
    @ResponseBody
    public User createUtente(@RequestBody UserDtoIn user) throws EmailAlreadyUsedException {
        return utenteService.addUser(user);
    }

    @PutMapping("{id}")
    @ResponseBody
    public User updateUtente(@RequestBody UserDtoIn user, @PathVariable Long id) throws UserNotFoundException {
        return utenteService.updateUser(user, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUtente(@PathVariable Long id) throws UserNotFoundException {
        utenteService.deleteUser(id);
    }

}
