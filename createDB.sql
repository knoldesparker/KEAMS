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

CREATE TABLE exsams (
    exsam_id INT,
    exsam_name VARCHAR(25),
    PRIMARY KEY (exsam_id)
);

CREATE TABLE studentteacherexsam (
	fk_exsam_id INT,
    fk_student_id INT,
    fk_teacher_id INT,
    exsam_grade INT,
    PRIMARY KEY (fk_exsam_id,fk_student_id,fk_teacher_id),
		FOREIGN KEY(fk_exsam_id)
			REFERENCES exsams (exsam_id),
		FOREIGN KEY (fk_student_id)
			REFERENCES students (student_id),
		FOREIGN KEY (fk_teacher_id)
			REFERENCES teachers (teacher_id)
);

CREATE TABLE studentcourses (
    fk_student_id INT,
    fk_course_id INT,
    PRIMARY KEY (fk_student_id , fk_course_id),
    FOREIGN KEY (fk_student_id)
        REFERENCES students (student_id),
    FOREIGN KEY (fk_course_id)
        REFERENCES courses (course_id)
);

CREATE TABLE assignments(
	assignment_id INT AUTO_INCREMENT,
    assignment_name VARCHAR(50),
    fk_course_id INT,
    PRIMARY KEY(assignment_id, fk_course_id),
    FOREIGN KEY(fk_course_id) REFERENCES courses(course_id)
);
