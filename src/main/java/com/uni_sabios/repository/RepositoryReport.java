package com.uni_sabios.repository;

import java.sql.SQLException;
import java.util.List;

import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Student;

public interface RepositoryReport {

    List<Person> getStudentbyProgram(int program) throws SQLException;
}
