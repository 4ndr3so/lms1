package com.lasso.lms.course.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lasso.lms.course.model.Course;
import com.lasso.lms.course.repository.PostgressCourseRepository;

@Service
public class CourseServiceImp implements ICourseService {

    private final PostgressCourseRepository courseRepository;

    public CourseServiceImp(PostgressCourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);    
    }

    @Override
    @Transactional
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }
    
}
