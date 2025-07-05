package com.example.easydb.controllers;

import com.example.easydb.models.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.easydb.services.UserService;

@RestController
@RequestMapping("/auth/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public User registerUser(@Valid @RequestBody User user) {
        User savedUser = null;

        try {
            savedUser = userService.register(user);
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }

        return savedUser;
    }
}
