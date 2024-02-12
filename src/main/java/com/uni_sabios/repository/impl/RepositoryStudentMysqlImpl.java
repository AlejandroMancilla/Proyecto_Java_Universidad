package com.uni_sabios.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.uni_sabios.repository.RepositoryStudent;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Student;
import com.uni_sabios.utils.conexiondb.conexionbdmysql.ConexionBDMysql;



public class RepositoryStudentMysqlImpl implements RepositoryStudent{
    
    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    @Override
    public List<Person> list() {
        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        return repositoryPersonMysqlImpl.listStudents();
    }

    @Override
    public Person getPerson(String document) {
        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        return repositoryPersonMysqlImpl.getPerson(document);
    }

    @Override
    public void create(Student student) {

        String sql = "INSERT INTO students (person_id, program_id) VALUES (?, ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setInt(1, student.getPersonId());
            stmt.setInt(2, student.getProgramId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(Person person, int programId) {

        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        repositoryPersonMysqlImpl.create(person);

        Person personCreated = repositoryPersonMysqlImpl.getPerson(person.getNumId());

        Student student = new Student(programId, personCreated.getId());

        create(student);

    }

    @Override
    public void modify(Student student) {
        String sql = "UPDATE students SET program_id = ? WHERE person_id = ?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setInt(1, student.getProgramId());
            stmt.setInt(2, student.getPersonId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Student student) {
        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        String sql = "DELETE FROM students WHERE person_id = ?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setInt(1, student.getId());
            stmt.executeUpdate();
            repositoryPersonMysqlImpl.delete(student.getPersonId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int personId) {
        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        String sql = "DELETE FROM students WHERE person_id = ?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setInt(1, personId);
            stmt.executeUpdate();
            repositoryPersonMysqlImpl.delete(personId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}