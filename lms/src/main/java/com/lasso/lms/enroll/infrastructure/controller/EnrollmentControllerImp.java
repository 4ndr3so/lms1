package com.lasso.lms.enroll.infrastructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lasso.lms.enroll.Dto.EnrollmentDto;
import com.lasso.lms.enroll.model.Enrollment;
import com.lasso.lms.enroll.service.IEnrollmentService;

@RestController
public class EnrollmentControllerImp implements IEnrollmentController {

    public final IEnrollmentService enrollmentService;

    public EnrollmentControllerImp(IEnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @Override
    public List<EnrollmentDto> getAllEnrollments() {
        // TODO Auto-generated method stub
        return enrollmentService.getAllEnrollments();
    }

    @Override
    public EnrollmentDto getEnrollmentById(Long id) {
        // TODO Auto-generated method stub
        return enrollmentService.getEnrollmentById(id);
    }

    @Override
    public EnrollmentDto createEnrollment(EnrollmentDto enrollment) {
        // TODO Auto-generated method stub
        return enrollmentService.createEnrollment(enrollment);
    }
    
}
