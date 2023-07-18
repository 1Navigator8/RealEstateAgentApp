package com.example.realestateagentapp.controller;

import com.example.realestateagentapp.entity.Users;
import com.example.realestateagentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogInController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/signIn")
    @ResponseStatus(code = HttpStatus.OK)
    public Users getLoggedInUsersHandler(Authentication auth) {
        System.out.println(auth);
        Users user = userRepo.findByUserEmail(auth.getName())
                .orElseThrow(() -> new BadCredentialsException("Incorrect authentication data (username and password)"));
        return user;
    }
}
