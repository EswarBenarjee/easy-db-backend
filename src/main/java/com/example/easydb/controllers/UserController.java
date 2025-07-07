package com.example.easydb.controllers;

import com.example.easydb.models.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @PostMapping("login")
    public String loginUser(@Valid @RequestBody User user){
        String loginStatus = null;

        try {
            loginStatus = userService.findByMail(user);
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }

        return loginStatus;
    }
}
