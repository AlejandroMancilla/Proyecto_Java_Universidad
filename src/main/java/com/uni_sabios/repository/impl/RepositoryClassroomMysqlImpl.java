package com.uni_sabios.repository.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.uni_sabios.repository.RepositoryClassroom;
import com.uni_sabios.repository.models.Classroom;
import com.uni_sabios.utils.conexiondb.conexionbdmysql.ConexionBDMysql;

public class RepositoryClassroomMysqlImpl implements RepositoryClassroom {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    @Override
    public List<Classroom> list() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'list'");
    }

    @Override
    public Classroom getClassroom(String Code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClassroom'");
    }

    @Override
    public void create(Classroom Classroom) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void edit(Classroom Classroom) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'edit'");
    }

    @Override
    public void delete(Classroom Classroom) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
