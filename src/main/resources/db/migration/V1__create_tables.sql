CREATE TABLE students(
    student_id BIGSERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	surname VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    primary_skill VARCHAR(100) NOT NULL,
    created_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_timestamp TIMESTAMP
);

CREATE TABLE student_phones(
    student_id BIGINT NOT NULL,
    phone_number VARCHAR(16) NOT NULL PRIMARY KEY,
    FOREIGN KEY(student_id) REFERENCES students(student_id)
);

CREATE TABLE tutors(
    tutor_id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
	surname VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    primary_skill VARCHAR(100) NOT NULL,
    created_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_timestamp TIMESTAMP
);

CREATE TABLE subjects(
    subject_name VARCHAR(100) NOT NULL PRIMARY KEY,
    tutor_id BIGINT NOT NULL,
    FOREIGN KEY (tutor_id) REFERENCES tutors (tutor_id)
);

CREATE TABLE exam_results(
    exam_id BIGSERIAL NOT NULL PRIMARY KEY,
    student_id BIGINT NOT NULL,
    subject_name VARCHAR(100) NOT NULL,
    mark INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (subject_name) REFERENCES subjects(subject_name)
);