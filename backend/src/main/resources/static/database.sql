-- Drop the table if it exists
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_courses;
DROP TABLE IF EXISTS courses;

-- Create the table to store user data
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL
);
CREATE TABLE user_courses (
                              id SERIAL PRIMARY KEY,
                              user_id INT,
                              course_id INT
);
CREATE TABLE courses (
                         id SERIAL PRIMARY KEY,
                         title VARCHAR(255) NOT NULL,
                         description TEXT

);

-- Insert the provided data into the users table
INSERT INTO users (username, password) VALUES
                                           ('aaa@aaa', '$2a$12$iJjTrlnJa2ObWiFZ3Ddwqurv9JuwlnSTt2JPbxByVzeZPOB3.KrO2'),
                                           ('aa@aa', '$2a$12$jyAV2FJKUCyt29cAU0NHkOkPUcLzFNQxNpJ1gYqRXdGX/SaNWsJPC'),
                                           ('qwe@qwe', '$2a$12$lzud/EtbIe6u7ZBCWDty0uLssIdUUYQYET/E1.lrcBcRcP1liMnQW'),
                                           ('qqq@QQQ', '$2a$12$sMP29lJy2hW2YRRwEXcnZ.rFW1qA2S47qKj44OJ8pLO9C9D4GMVQK'),
                                           ('q@q', '$2a$12$VLNH8lL1PW0rKRxbnLEukec7pp4nieMHDRzkNdBKH6hLdTf6/jlXK');

-- Insert some example courses
INSERT INTO courses (title, description) VALUES
                                             ('Java Basics', 'An introductory course to Java programming, including syntax and basic concepts.'),
                                             ('Advanced Java', 'A course covering advanced Java features like streams, concurrency, and more.'),
                                             ('Web Development with Spring Boot', 'Learn how to create web applications using Spring Boot.'),
                                             ('Frontend Development with React', 'A comprehensive guide to building UIs with React.'),
                                             ('Database Management Systems', 'An in-depth course on database theory, design, and SQL.');


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

