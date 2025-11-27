package com.lasso.lms.enroll.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lasso.lms.course.model.Course;

import com.lasso.lms.user.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enrollments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date enrolledAt;

    // 1. RELATIONSHIP MAPPING: Many Enrollment records belong to ONE User.
    // The @JoinColumn specifies the foreign key column in the 'enrollments' table.
    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY) // Always use LAZY for relationships unless necessary
    @JoinColumn(name = "user_id", nullable = false) // user_id is the FK in the 'enrollments' table
    private User user;

    // 2. RELATIONSHIP MAPPING: Many Enrollment records belong to ONE Course.
    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

}
