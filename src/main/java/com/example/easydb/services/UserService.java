package com.example.easydb.services;

import com.example.easydb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.easydb.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(User user) {
        if(user == null) {
            return null;
        }

        // Hash the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
    public String findByMail(User user){
        String loggedinMail = user.getMail();


        if (loggedinMail == null) {
            return "loginFailed";
        }
        List<User> userByMail=  userRepository.findByMail(loggedinMail);
        User loggedInUser = new User();
        if(!userByMail.isEmpty()){
            loggedInUser = userByMail.get(0);
        }
        else{
            return "loginFailed";
        }
        //password check
        if(passwordEncoder.matches(user.getPassword(),loggedInUser.getPassword())){
             return "loginSuccessfull" ;
        }
        return "loginFailed";
    }
}
