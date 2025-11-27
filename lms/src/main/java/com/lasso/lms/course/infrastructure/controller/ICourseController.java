package com.lasso.lms.course.infrastructure.controller;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lasso.lms.course.model.Course;

@RequestMapping("/api/v1/courses")
public interface ICourseController {

    @GetMapping("/all")
    List<Course> getAllCourses();

    @GetMapping("/{id}")
    Course getCourseById(@PathVariable Long id);

    @PostMapping("/create")
    Course createCourse(@RequestBody Course course);

} 
