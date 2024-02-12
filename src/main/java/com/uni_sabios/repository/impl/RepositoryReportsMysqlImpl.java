package com.uni_sabios.repository.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.uni_sabios.repository.RepositoryReport;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.utils.conexiondb.conexionbdmysql.ConexionBDMysql;

public class RepositoryReportsMysqlImpl implements RepositoryReport {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    public List<Person> getStudentbyProgram(int program) throws SQLException {
        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        return repositoryPersonMysqlImpl.listStudentsByProgram(program);
    }

    public void createStudent() {

    }

    
}
