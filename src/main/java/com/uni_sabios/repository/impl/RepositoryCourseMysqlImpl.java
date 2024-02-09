package com.uni_sabios.repository.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.uni_sabios.repository.RepositoryCourse;
import com.uni_sabios.repository.models.Course;
import com.uni_sabios.utils.conexiondb.conexionbdmysql.ConexionBDMysql;

public class RepositoryCourseMysqlImpl implements RepositoryCourse {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    @Override
    public List<Course> list() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'list'");
    }

    @Override
    public Course getClassroom(String Code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClassroom'");
    }

    @Override
    public void create(Course course) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void edit(Course course) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'edit'");
    }

    @Override
    public void delete(Course course) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
