package com.lasso.lms.course.repository;

import org.springframework.data.repository.CrudRepository;

import com.lasso.lms.course.model.Course;

public interface PostgressCourseRepository extends CrudRepository<Course, Long> {
    // Additional query methods can be defined here if needed
    
}
