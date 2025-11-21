create table enrollments(
    id BIGSERIAL PRIMARY key,
    user_id BIGINT not null,
    course_id BIGINT not null,
    enrolled_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (course_id) REFERENCES courses(id)
);