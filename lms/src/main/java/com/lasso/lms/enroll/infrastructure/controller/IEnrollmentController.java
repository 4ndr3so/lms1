package com.lasso.lms.enroll.infrastructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lasso.lms.enroll.Dto.EnrollmentDto;
import com.lasso.lms.enroll.model.Enrollment;

@RequestMapping("/api/v1/enrollments")
public interface IEnrollmentController {
    
    @GetMapping("/all") 
    List<EnrollmentDto> getAllEnrollments();

    @GetMapping("/{id}")
    EnrollmentDto getEnrollmentById(@PathVariable Long id);

    @PostMapping("/create")
    EnrollmentDto createEnrollment(@RequestBody EnrollmentDto enrollment);
}
