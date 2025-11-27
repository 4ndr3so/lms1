package com.lasso.lms.enroll.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDto {
    // 1. Enrollment's own data
    private Long id;
    private Date enrolledAt;

    // 2. Decoupled User Data (Replaces the whole User entity)
    private Long userId;
    private String userName; // Optional, but useful for quick display

    // 3. Decoupled Course Data (Replaces the whole Course entity)
    private Long courseId;
    private String courseTitle; // Optional, but useful for quick display
}
