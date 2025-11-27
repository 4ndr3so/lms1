package com.lasso.lms.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lasso.lms.user.model.User;
import com.lasso.lms.user.repository.PostgressUserRepository;

@Service
public class UserServiceImp implements IUserService {

    
    private final PostgressUserRepository userRepository;

    public UserServiceImp(PostgressUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id).orElse(null);    
    }

    @Override
    @Transactional
    public User createUser(User user) {
        // TODO Auto-generated method stub
        
        return userRepository.save(user);
    }
    
}
