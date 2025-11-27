package com.lasso.lms.enroll.mappers;

import java.util.List;

import com.lasso.lms.course.model.Course;
import com.lasso.lms.enroll.Dto.EnrollmentDto;
import com.lasso.lms.enroll.model.Enrollment;
import com.lasso.lms.user.model.User;

public class EnrollmentMapper {
    
    public static EnrollmentDto toDto(Enrollment entity) {
        if (entity==null) {
            return null;
        }
        EnrollmentDto dto = new EnrollmentDto();
        dto.setId(entity.getId());
        dto.setEnrolledAt(entity.getEnrolledAt());
        dto.setUserId(entity.getUser().getId());
        dto.setUserName(entity.getUser().getUsername());
        dto.setCourseId(entity.getCourse().getId());
        dto.setCourseTitle(entity.getCourse().getTitle());
        return dto;
    }

    public static List<EnrollmentDto> toDtoList(List<Enrollment> entitys) {
        return entitys.stream()
                .map(EnrollmentMapper::toDto)
                .toList();
    }

    public static Enrollment toEntity(EnrollmentDto dto, User user, Course course) {
        if (dto == null) {
            return null;
        }
        Enrollment entity = new Enrollment();
        entity.setUser(user);
        entity.setCourse(course);
        // Note: User and Course entities should be set separately, as we only have their IDs here.
        return entity;
    }
}
