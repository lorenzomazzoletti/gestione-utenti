package com.intesigroup.gestioneutenti.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;

    @Column(unique=true)
    private String email;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"))
    @Column(name = "role")
    private List<Role> roles;

}
