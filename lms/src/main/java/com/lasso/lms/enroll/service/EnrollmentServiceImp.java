package com.lasso.lms.enroll.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lasso.lms.course.repository.PostgressCourseRepository;
import com.lasso.lms.enroll.Dto.EnrollmentDto;
import com.lasso.lms.enroll.infrastructure.controller.EnrollmentControllerImp;
import com.lasso.lms.enroll.mappers.EnrollmentMapper;
import com.lasso.lms.enroll.model.Enrollment;
import com.lasso.lms.enroll.repository.PostgressEnrollmentRepository;
import com.lasso.lms.user.model.User;
import com.lasso.lms.user.repository.PostgressUserRepository;

@Service
public class EnrollmentServiceImp implements IEnrollmentService {



    private final PostgressEnrollmentRepository enrollmentRepository;
    private final PostgressUserRepository userRepository;
    private final PostgressCourseRepository courseRepository;
    
    

    public EnrollmentServiceImp(PostgressEnrollmentRepository enrollmentRepository, PostgressUserRepository userRepository,
            PostgressCourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EnrollmentDto> getAllEnrollments() {

       
        //1. fetch data from repository
        List<Enrollment> entitieList = (List<Enrollment>) enrollmentRepository.findAll();
        

        return  EnrollmentMapper.toDtoList(entitieList);
    }

    @Override
    @Transactional(readOnly = true)
    public EnrollmentDto getEnrollmentById(Long id) {
        // TODO Auto-generated method stub
        Enrollment entitiesEnrollment = enrollmentRepository.findById(id).orElse(null);
        return EnrollmentMapper.toDto(entitiesEnrollment);
       
    }

    @Override
    @Transactional
    public EnrollmentDto createEnrollment(EnrollmentDto enrollment) {
        
        if(enrollment.getUserId() == null || enrollment.getCourseId() == null) {
            throw new IllegalArgumentException("User ID and Course ID must be provided");
        }


        User user = userRepository.findById(enrollment.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid User ID: " + enrollment.getUserId()));

        var course = courseRepository.findById(enrollment.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Course ID: " + enrollment.getCourseId()));

        Enrollment enrollmentEntity = EnrollmentMapper.toEntity(enrollment, user, course);
        Enrollment savedEnrollment = enrollmentRepository.save(enrollmentEntity);
        
        return EnrollmentMapper.toDto(savedEnrollment);
    }
    
}
