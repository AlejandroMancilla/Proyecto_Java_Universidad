SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE uni_sabios.addresses;
TRUNCATE TABLE uni_sabios.buildings;
TRUNCATE TABLE uni_sabios.cities;
TRUNCATE TABLE uni_sabios.classrooms;
TRUNCATE TABLE uni_sabios.courses;
TRUNCATE TABLE uni_sabios.departments;
TRUNCATE TABLE uni_sabios.periods;
TRUNCATE TABLE uni_sabios.persons;
TRUNCATE TABLE uni_sabios.programs;
TRUNCATE TABLE uni_sabios.registers;
TRUNCATE TABLE uni_sabios.schedules;
TRUNCATE TABLE uni_sabios.signatures;
TRUNCATE TABLE uni_sabios.students;
TRUNCATE TABLE uni_sabios.teachers;
TRUNCATE TABLE uni_sabios.tuitions;

SET FOREIGN_KEY_CHECKS = 1;

SELECT * FROM registers r INNER JOIN students s ON r.student_id = s.student_id INNER JOIN persons p ON p.person_id = s.person_id WHERE r.period_id = 1;
