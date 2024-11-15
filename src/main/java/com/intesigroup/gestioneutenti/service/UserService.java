package com.intesigroup.gestioneutenti.service;

import com.intesigroup.gestioneutenti.entity.User;
import com.intesigroup.gestioneutenti.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {

    private final UserRepository userRepository;

    public List<User> userList() {
        log.info("Lista utenti");

        return userRepository.findAll();
    }


    public User getUser(Long id) {
        log.info("getUser with id: {}", id);

        return userRepository.findById(id).orElse(null);
    }

    public User addUser(User user) {
        log.info("addUser with id: {}", user.getId());

        return userRepository.save(user);
    }

    public User updateUser(User user, long id) throws BadRequestException {
        log.info("updateUser with id: {}", id);

        Optional<User> userOptional = userRepository.findById(id);

        return userOptional.map(userRepository::save).orElseThrow(() -> new BadRequestException("User with id " + id + " not found"));
    }

    public void deleteUser(Long id) throws BadRequestException {
        log.info("deleteUser with id: {}", id);

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new BadRequestException("User with id " + id + " not found");
        }
    }


}
