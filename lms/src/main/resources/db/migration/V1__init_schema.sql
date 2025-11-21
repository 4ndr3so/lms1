CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    username varchar(50) unique not null,
    password varchar(200) not null,
    role varchar(20) not null,
    email varchar(100) unique not null,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)