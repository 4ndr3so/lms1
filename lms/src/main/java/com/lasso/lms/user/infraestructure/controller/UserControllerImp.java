package com.lasso.lms.user.infraestructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.lasso.lms.user.model.User;
import com.lasso.lms.user.service.IUserService;

@RestController
public class UserControllerImp implements IUserController {

    private final IUserService userService; 

    public UserControllerImp(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return userService.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        // TODO Auto-generated method stub
        
        return userService.getUserById(id);
    }

    @Override
    public User createUser(User user) {
        // TODO Auto-generated method stub
        
        return userService.createUser(user);
    }
    
}
