package com.example.controller;

import com.example.models.User;
import com.example.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController

public class UserController {

    private final UserRepository userRepository;

    @GetMapping("users")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @PostMapping("users")
    public User create(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("users/{id}")
    public User update(@PathVariable Long id,@RequestBody User user){
        return userRepository.save(user);
    }




}
