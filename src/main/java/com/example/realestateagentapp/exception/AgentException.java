package com.example.realestateagentapp.exception;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AgentException extends RuntimeException {
    private String message;
}