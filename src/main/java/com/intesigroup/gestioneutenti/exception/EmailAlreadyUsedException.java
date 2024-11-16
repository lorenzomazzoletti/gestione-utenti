package com.intesigroup.gestioneutenti.exception;

public class EmailAlreadyUsedException extends RuntimeException{
    public EmailAlreadyUsedException(String email){
        super("User with email: " + email + " already exists");
    }
}
