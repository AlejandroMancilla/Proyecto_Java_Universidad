package com.uni_sabios.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni_sabios.repository.RepositoryReport;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Register;
import com.uni_sabios.services.ServiceReport;

public class ServiceReportImpl implements ServiceReport{

    private final RepositoryReport crudRepositoryReport;

    public ServiceReportImpl(RepositoryReport crudRepositoryReport) {
        this.crudRepositoryReport = crudRepositoryReport;
    }

    @Override
    public List<Person> getStudentbyProgram(int program) throws SQLException {
        return this.crudRepositoryReport.getStudentbyProgram(program);
    }

    public List<Register> calculateSemester(String document, int period) {
        return this.crudRepositoryReport.calculateSemester(document, period);
    }
    
}
