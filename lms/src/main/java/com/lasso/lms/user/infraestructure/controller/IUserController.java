package com.lasso.lms.user.infraestructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lasso.lms.user.model.User;


@RequestMapping("/api/v1/users")
public interface IUserController {
    
    @GetMapping("/all")
    List<User> getAllUsers();

    @GetMapping("/{id}")
    User getUserById(@PathVariable("id") Long id);

    @PostMapping("/create")
    User createUser(@RequestBody User user);

}
