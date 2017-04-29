CREATE TABLE d_department (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  CONSTRAINT name_unique UNIQUE (name)
);

CREATE TABLE e_employee (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  skype VARCHAR(255),
  d_department_id INT NOT NULL,
  FOREIGN KEY (d_department_id) REFERENCES d_department
);

CREATE SEQUENCE seq_e_employee START WITH 100 INCREMENT BY 1;

CREATE SEQUENCE seq_d_department START WITH 100 INCREMENT BY 1;