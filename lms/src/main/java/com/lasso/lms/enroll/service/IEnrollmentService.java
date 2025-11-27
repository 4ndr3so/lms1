package com.lasso.lms.enroll.service;

import java.util.List;

import com.lasso.lms.enroll.Dto.EnrollmentDto;
import com.lasso.lms.enroll.model.Enrollment;

public interface IEnrollmentService {
    
    List<EnrollmentDto> getAllEnrollments();
    EnrollmentDto getEnrollmentById(Long id);
    EnrollmentDto createEnrollment(EnrollmentDto enrollment);
}
