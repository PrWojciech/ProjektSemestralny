-- Drop the table if it exists
-- DROP TABLE IF EXISTS users;
-- DROP TABLE IF EXISTS user_courses;
-- DROP TABLE IF EXISTS courses;
-- DROP TABLE IF EXISTS lessons;
-- DROP TABLE IF EXISTS sections;
-- DROP TABLE IF EXISTS user_courses;
-- DROP TABLE IF EXISTS courses;
-- DROP TABLE IF EXISTS users;



CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela kursów
CREATE TABLE courses (
                         id SERIAL PRIMARY KEY,
                         title VARCHAR(255) NOT NULL,
                         description TEXT,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE user_courses (
                              id SERIAL PRIMARY KEY,
                              user_id INT NOT NULL,
                              course_id INT NOT NULL

);

-- Sekcje kursów
CREATE TABLE sections (
                          id SERIAL PRIMARY KEY,
                          course_id INT NOT NULL,
                          section_name VARCHAR(255) NOT NULL,
                          description TEXT

);

-- Lekcje w sekcjach
CREATE TABLE lessons (
                         id SERIAL PRIMARY KEY,
                         lesson_index float not null,
                         section_id INT NOT NULL,
                         lesson_title VARCHAR(255) NOT NULL,
                         movie_title VARCHAR(255) NOT NULL,
                         movie_length TIME,
                         movie_localization VARCHAR(255) NOT NULL,
                         description TEXT
);

-- Insert the provided data into the users table
INSERT INTO users (username, password, created_at) VALUES
                                                      ('aaa@aaa', '$2a$12$iJjTrlnJa2ObWiFZ3Ddwqurv9JuwlnSTt2JPbxByVzeZPOB3.KrO2', '2024-01-01 12:00:00'),
                                                      ('aa@aa', '$2a$12$jyAV2FJKUCyt29cAU0NHkOkPUcLzFNQxNpJ1gYqRXdGX/SaNWsJPC', '2024-01-01 12:00:00'),
                                                      ('qwe@qwe', '$2a$12$lzud/EtbIe6u7ZBCWDty0uLssIdUUYQYET/E1.lrcBcRcP1liMnQW', '2024-01-01 12:00:00'),
                                                      ('qqq@QQQ', '$2a$12$sMP29lJy2hW2YRRwEXcnZ.rFW1qA2S47qKj44OJ8pLO9C9D4GMVQK', '2024-01-01 12:00:00'),
                                                      ('q@q', '$2a$12$VLNH8lL1PW0rKRxbnLEukec7pp4nieMHDRzkNdBKH6hLdTf6/jlXK', '2024-01-01 12:00:00');




INSERT INTO user_courses (user_id, course_id) VALUES
                                                  (1, 1),
                                                  (1, 3);
INSERT INTO user_courses (user_id, course_id) VALUES
                                                  (2, 2),
                                                  (2, 4);
INSERT INTO user_courses (user_id, course_id) VALUES
                                                  (3, 1),
                                                  (3, 5);
INSERT INTO user_courses (user_id, course_id) VALUES
                                                  (4, 2),
                                                  (4, 4);
INSERT INTO user_courses (user_id, course_id) VALUES
                                                  (5, 3),
                                                  (5, 5);

