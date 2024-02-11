package com.uni_sabios.repository.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.uni_sabios.repository.RepositoryStudent;
import com.uni_sabios.utils.conexiondb.conexionbdmysql.ConexionBDMysql;

public class RepositoryStudentMysqlImpl implements RepositoryStudent{
    
    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }
}
