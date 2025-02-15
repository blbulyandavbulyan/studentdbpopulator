CREATE OR REPLACE FUNCTION update_timestamp() RETURNS trigger
LANGUAGE plpgsql
AS $$
BEGIN
  new.updated_timestamp := current_timestamp;
  RETURN new;
END;
$$;


CREATE TRIGGER update_timestamp
BEFORE UPDATE ON students
FOR EACH ROW
EXECUTE PROCEDURE update_timestamp();

CREATE TRIGGER update_timestamp
BEFORE UPDATE ON tutors
FOR EACH ROW
EXECUTE PROCEDURE update_timestamp();
