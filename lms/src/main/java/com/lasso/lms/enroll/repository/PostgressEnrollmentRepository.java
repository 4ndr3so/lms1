package com.lasso.lms.enroll.repository;

import org.springframework.data.repository.CrudRepository;

import com.lasso.lms.enroll.model.Enrollment;

public interface PostgressEnrollmentRepository extends CrudRepository<Enrollment, Long> {


}
