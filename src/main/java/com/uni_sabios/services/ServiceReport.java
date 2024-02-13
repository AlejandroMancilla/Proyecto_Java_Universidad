package com.uni_sabios.services;

import java.sql.SQLException;
import java.util.List;

import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Register;

public interface ServiceReport {

    List<Person> getStudentbyProgram(int program) throws SQLException;

    List<Register> calculateSemester(String document, int period);

    int incomeSemester(int periodId) throws SQLException;
    
    void orderProgramsByStudents();
}
