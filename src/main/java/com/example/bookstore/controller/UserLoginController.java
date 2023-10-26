package com.example.bookstore.controller;

import com.example.bookstore.model.User;
import com.example.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class UserLoginController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<String> loginUser (@RequestBody User loginUser) {
        User user = userRepository.findByEmailId(loginUser.getEmailId());
        if (user != null && loginUser.getPassword().equals(user.getPassword())){
            return ResponseEntity.ok("Login Successful");
        } else {
            return ResponseEntity.status(401).body("Invalid Credentials");
        }
    }
}
