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
CREATE TABLE exsams(
  exsam_id int primary key,
  exsam_name varchar (25),
);
CREATE TABLE

-- AUTHOR(S): ECS
CREATE TABLE product_orders(
	order_id INT,
    product_ean VARCHAR(13),
    quantity INT DEFAULT 1,
    PRIMARY KEY(order_id, product_ean),
    FOREIGN KEY(order_id) REFERENCES orders(id),
    FOREIGN KEY(product_ean) REFERENCES products(ean)
);
