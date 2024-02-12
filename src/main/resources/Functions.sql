DELIMITER//
CREATE FUNCTION validate_id_teachers (new_id int)
RETURNS BOOLEAN DETERMINISTIC
BEGIN
	RETURN (new_id IN (SELECT p.person_id FROM persons p INNER JOIN teachers t ON p.person_id = t.person_id));
END; //

CREATE FUNCTION validate_id_students (new_id int)
RETURNS BOOLEAN DETERMINISTIC
BEGIN
	RETURN (new_id IN (SELECT p.person_id FROM persons p INNER JOIN students s ON p.person_id = s.person_id));
END; //


CREATE FUNCTION validate_classroom_day (class_day VARCHAR(10), current_classroom_id int)
RETURNS BOOLEAN DETERMINISTIC
BEGIN
	RETURN (class_day IN (SELECT s.schedule_day  FROM schedules s INNER JOIN classrooms c ON c.classroom_id = current_classroom_id));
END; //

CREATE FUNCTION validate_class_time ( current_start_time TIME, current_end_time TIME, current_classroom_id int)
RETURNS BOOLEAN DETERMINISTIC
BEGIN
	SET @validate_start = (SELECT 1 IN (SELECT current_start_time BETWEEN s.start_time AND s.end_time FROM schedules s WHERE s.classroom_id = current_classroom_id));
	SET @validate_end = (SELECT 1 IN (SELECT current_end_time BETWEEN s.start_time AND s.end_time FROM schedules s WHERE s.classroom_id = current_classroom_id));
	RETURN (@validate_start OR @validate_end);
END; //