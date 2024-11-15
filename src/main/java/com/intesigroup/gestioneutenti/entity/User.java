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
    private String email;

    @ElementCollection
    @Enumerated(EnumType.STRING) // Use STRING to store enum names, or ORDINAL for index
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "id_utente"))
    @Column(name = "role")
    private List<Ruolo> roles;

}
