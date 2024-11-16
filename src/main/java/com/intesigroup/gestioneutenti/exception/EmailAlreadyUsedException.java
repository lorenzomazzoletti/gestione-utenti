package com.intesigroup.gestioneutenti.exception;

public class EmailAlreadyUsedException extends Exception {
    public EmailAlreadyUsedException(String email){
        super("User with email: " + email + " already exists");
    }
}
