package com.uni_sabios.repository.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni_sabios.repository.RepositoryReport;
import com.uni_sabios.repository.impl.implregisters.RepositoryRegisterMysqlImpl;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Register;

public class RepositoryReportsMysqlImpl implements RepositoryReport {

    public List<Person> getStudentbyProgram(int program) throws SQLException {
        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        return repositoryPersonMysqlImpl.listStudentsByProgram(program);
    }

    @Override
    public List<Register> calculateSemester(String document, int period) {
        RepositoryRegisterMysqlImpl repositoryRegisterMysqlImpl = new RepositoryRegisterMysqlImpl();
        return repositoryRegisterMysqlImpl.listByStudentId(document, period);
    }


    
}
