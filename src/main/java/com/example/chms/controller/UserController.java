package com.example.chms.controller;

import com.example.chms.Model.User;
import com.example.chms.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository repository;
    public UserController(UserRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/User/{uuid}")
    User one(@PathVariable String uuid){
        for (User user:repository.findAll()
             ) {
            if (user.getUuid().equals(uuid)){
                return repository.getOne(user.getId());
            }
        };
        return null;
    }
}
