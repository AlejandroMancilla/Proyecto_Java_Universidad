package com.uni_sabios.services;

import java.sql.SQLException;
import java.util.List;

import com.uni_sabios.repository.models.Person;

public interface ServiceReport {

    List<Person> getStudentbyProgram(int program) throws SQLException;
    
}
