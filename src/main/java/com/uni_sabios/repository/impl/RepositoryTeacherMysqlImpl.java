package com.uni_sabios.repository.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.uni_sabios.repository.RepositoryTeacher;
import com.uni_sabios.utils.conexiondb.conexionbdmysql.ConexionBDMysql;

public class RepositoryTeacherMysqlImpl implements RepositoryTeacher {
    
    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }
}
