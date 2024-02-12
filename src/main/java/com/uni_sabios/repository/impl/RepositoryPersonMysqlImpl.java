package com.uni_sabios.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uni_sabios.repository.RepositoryPerson;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.utils.conexiondb.conexionbdmysql.ConexionBDMysql;

public class RepositoryPersonMysqlImpl implements RepositoryPerson {
    
    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    @Override
    public List<Person> list() {
        List<Person> listPersons = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM persons");) {
            while (rs.next()) {
                listPersons.add(createPerson(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPersons;
    }

    public List<Person> listStudents() {
        List<Person> listPersons = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM persons p INNER JOIN students s ON p.person_id = s.person_id");) {
            while (rs.next()) {
                listPersons.add(createPerson(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPersons;
    }

    public List<Person> listStudentsByProgram(int program) throws SQLException {
        List<Person> listPersons = new ArrayList<>();
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM persons p INNER JOIN students s ON p.person_id = s.person_id WHERE s.program_id = ?");) {
                pstmt.setInt(1, program);
                try(ResultSet rs = pstmt.executeQuery();) {
                    while (rs.next()) {
                        listPersons.add(createPerson(rs));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        return listPersons;
        }
    }

    public List<Person> listTeachers() {
        List<Person> listPersons = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM persons p INNER JOIN teachers t ON p.person_id = t.person_id");) {
            while (rs.next()) {
                listPersons.add(createPerson(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPersons;
    }

    @Override
    public Person getPerson(String document) {
        Person person = null;
        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM persons WHERE document_numb = ?");) {
            stmt.setString(1, document);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    person = createPerson(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public void create(Person person) {
        try (PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO persons (document_type, document_numb, name, last_name, address_id, city_id) VALUES (?, ?, ?, ?, ?, ?)");) {
            stmt.setString(1, person.getTypeId());
            stmt.setString(2, person.getNumId());
            stmt.setString(3, person.getName());
            stmt.setString(4, person.getLastName());
            stmt.setInt(5, person.getAddressId());
            stmt.setInt(6, person.getCityResidence());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(Person person) {
        try (PreparedStatement stmt = getConnection().prepareStatement("UPDATE persons SET document_type = ?, document_numb = ?, name = ?, last_name = ?, address_id = ?, city_id = ? WHERE document_numb = ?");) {
            stmt.setString(1, person.getTypeId());
            stmt.setString(2, person.getNumId());
            stmt.setString(3, person.getName());
            stmt.setString(4, person.getLastName());
            stmt.setInt(5, person.getAddressId());
            stmt.setInt(6, person.getCityResidence());
            stmt.setString(7, person.getNumId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Person person) {
        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM persons WHERE document_numb = ?");) {
            stmt.setString(1, person.getNumId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int personId) {
        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM persons WHERE person_id = ?");) {
            stmt.setInt(1, personId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private Person createPerson(ResultSet rs) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("person_id"));
        person.setTypeId(rs.getString("document_type"));
        person.setNumId(rs.getString("document_numb"));
        person.setName(rs.getString("name"));
        person.setLastName(rs.getString("last_name"));
        person.setAddressId(rs.getInt("address_id"));
        person.setCityResidence(rs.getInt("city_id"));

        return person;
    }
}