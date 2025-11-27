package com.lasso.lms.course.service;

import java.util.List;

import com.lasso.lms.course.model.Course;

public interface ICourseService {
    // Define course-related service methods here
    List<Course> getAllCourses();
    Course getCourseById(Long id);  
    Course createCourse(Course course);
    
}
