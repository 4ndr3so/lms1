create table courses(
    id BIGSERIAL primary key,
    title varchar(100) not null,
    description text,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);