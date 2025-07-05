package com.example.easydb.services;

import com.example.easydb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.easydb.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        if(user == null) {
            return null;
        }

        return userRepository.save(user);
    }
}
