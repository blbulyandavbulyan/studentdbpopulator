CREATE OR REPLACE FUNCTION average_mark_for_student(studentid BIGINT) RETURNS DECIMAL
LANGUAGE SQL
RETURNS NULL ON NULL INPUT
AS 'SELECT AVG(mark) FROM exam_results er WHERE er.student_id = studentid';

CREATE OR REPLACE FUNCTION average_mark_for_subject(name VARCHAR) RETURNS DECIMAL
LANGUAGE SQL
RETURNS NULL ON NULL INPUT
AS 'SELECT AVG(mark) FROM exam_results WHERE subject_name = name';

CREATE OR REPLACE FUNCTION find_student_at_red_zone() RETURNS BIGINT
LANGUAGE SQL
AS $$ SELECT s.student_id FROM students s
    INNER JOIN exam_results er ON er.student_id = s.student_id
    WHERE mark <= 3
    GROUP BY s.student_id
    HAVING COUNT(mark) >= 2 LIMIT 1 $$;
