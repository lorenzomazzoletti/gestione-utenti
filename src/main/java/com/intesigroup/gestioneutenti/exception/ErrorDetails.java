package com.intesigroup.gestioneutenti.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@AllArgsConstructor
@Data
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private Map<?,?> details;
}
