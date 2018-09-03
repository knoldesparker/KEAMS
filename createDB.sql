DROP DATABASE IF EXISTS kea;
CREATE DATABASE kea;
USE kea;

-- AUTHOR(S): CPS
CREATE TABLE students(
	student_id INT AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(50) NOT NULL
);

-- AUTHOR(S): ECS
CREATE TABLE teachers(
	teacher_id INT AUTO_INCREMENT PRIMARY KEY,
	teacher_name VARCHAR(50)
);

-- AUTHOR(S): ECS
CREATE TABLE courses(
	course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(50)
);

CREATE TABLE assignments(
	assignment_id INT AUTO_INCREMENT PRIMARY KEY,
    assignment_name VARCHAR(50),
    fk_course_id INT not null,
    FOREIGN KEY(fk_course_id) REFERENCES course(course_id)
);

-- AUTHOR(S): ECS
CREATE TABLE studentcourses(
	fk_student_id INT,
    fk_course_id INT(13),
    PRIMARY KEY(fk_student_id, fk_course_id),
    FOREIGN KEY(fk_student_id) REFERENCES students(student_id),
    FOREIGN KEY(fk_course_id) REFERENCES courses(course_id)
);
