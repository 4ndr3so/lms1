package com.lasso.lms.user.service;

import java.util.List;

import com.lasso.lms.user.model.User;

public interface IUserService {
    // Define user-related service methods here
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
}
