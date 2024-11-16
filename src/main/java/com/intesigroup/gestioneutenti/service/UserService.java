package com.intesigroup.gestioneutenti.service;

import com.intesigroup.gestioneutenti.dto.UserDtoIn;
import com.intesigroup.gestioneutenti.entity.User;
import com.intesigroup.gestioneutenti.exception.UserNotFoundException;
import com.intesigroup.gestioneutenti.mapper.UserMapper;
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
        log.info("Retrieving all users list");

        return userRepository.findAll();
    }


    public User getUser(Long id) {
        log.info("Retrieving user with id: {}", id);

        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User addUser(UserDtoIn user) {
        log.info("Adding user with email: {}", user.email());

        return userRepository.save(UserMapper.userDtoInToUser(user));
    }

    public User updateUser(UserDtoIn user, Long id) {
        log.info("Updating user with id: {}", id);

        Optional<User> userOptional = userRepository.findById(id);

        if(userOptional.isPresent()) {
            User userToUpdate = userOptional.get();
            userToUpdate.setUsername(user.username());
            userToUpdate.setEmail(user.email());
            userToUpdate.setRoles(user.roles());
            return userRepository.save(userToUpdate);
        } else {
            throw new UserNotFoundException();
        }
    }

    public void deleteUser(Long id) throws BadRequestException {
        log.info("Deleting User with id: {}", id);

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new BadRequestException("User with id " + id + " not found");
        }
    }


}
