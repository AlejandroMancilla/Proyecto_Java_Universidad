package com.uni_sabios.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.uni_sabios.repository.RepositoryTeacher;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Teacher;
import com.uni_sabios.utils.conexiondb.conexionbdmysql.ConexionBDMysql;

public class RepositoryTeacherMysqlImpl implements RepositoryTeacher {
    
    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    @Override
    public List<Person> list(){
        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        return repositoryPersonMysqlImpl.listTeachers();
    }
    
    @Override
    public Person getPerson(String document){
        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        return repositoryPersonMysqlImpl.getPerson(document);
    }

    @Override
    public void create(Teacher teacher){
        
        String sql = "INSERT INTO teachers (person_id, department_id) VALUES (?, ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setInt(1, teacher.getPersonId());
            stmt.setInt(2, teacher.getDepartmentId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void create(Person person, int departmentId){
        
        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        repositoryPersonMysqlImpl.create(person);

        Person personCreated = repositoryPersonMysqlImpl.getPerson(person.getNumId());

        Teacher teacher = new Teacher(departmentId, personCreated.getId());

        create(teacher);

    }

    @Override
    public void modify(Teacher teacher){
        
        String sql = "UPDATE teachers SET department_id = ? WHERE person_id = ?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setInt(1, teacher.getDepartmentId());
            stmt.setInt(2, teacher.getPersonId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Teacher teacher){
        System.out.println("Deleting teacher");
    }
}
