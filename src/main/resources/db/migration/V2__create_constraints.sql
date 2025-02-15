ALTER TABLE students
ADD CONSTRAINT fn_constraint CHECK (name ~ ('^[^@\$\#]*$'));

ALTER TABLE students
ADD CONSTRAINT surname_constraint CHECK (surname ~ ('^[^@\$\#]*$'));

ALTER TABLE tutors
ADD CONSTRAINT fn_constraint CHECK (name ~ ('^[^@\$\#]*$'));

ALTER TABLE tutors
ADD CONSTRAINT surname_constraint CHECK (surname ~ ('^[^@\$\#]*$'));