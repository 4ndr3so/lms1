package com.lasso.lms.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lasso.lms.user.model.User;


public interface PostgressUserRepository extends CrudRepository<User, Long> {
    // Additional query methods can be defined here if needed
}
