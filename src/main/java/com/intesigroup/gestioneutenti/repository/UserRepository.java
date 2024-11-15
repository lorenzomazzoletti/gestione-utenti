package com.intesigroup.gestioneutenti.repository;

import com.intesigroup.gestioneutenti.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
