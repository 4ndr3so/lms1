package com.lasso.lms.course.infrastructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.lasso.lms.course.model.Course;
import com.lasso.lms.course.service.ICourseService;

@RestController
public class CourseControllerImp implements ICourseController {

    private final ICourseService courseService;

    public CourseControllerImp(ICourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public List<Course> getAllCourses() {
        // TODO Auto-generated method stub
       return courseService.getAllCourses();
    }

    @Override
    public Course getCourseById(Long id) {
        // TODO Auto-generated method stub
       return courseService.getCourseById(id);
    }

    @Override
    public Course createCourse(Course course) {
        // TODO Auto-generated method stub
        return courseService.createCourse(course);
    }
    
}
