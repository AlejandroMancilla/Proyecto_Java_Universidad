package com.uni_sabios.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uni_sabios.repository.RepositoryDepartment;
import com.uni_sabios.repository.models.Department;
import com.uni_sabios.utils.conexiondb.conexionbdmysql.ConexionBDMysql;

public class RepositoryDepartmentMysqlImpl implements RepositoryDepartment {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    private Department createDepartment(ResultSet rs) throws SQLException {
        return new Department(rs.getInt("department_id"), rs.getString("department_name"));
    }

    @Override
    public List<Department> list() {
        List<Department> listDepartments = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM departments");) {
            while (rs.next()) {
                listDepartments.add(createDepartment(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDepartments;
    }

    @Override
    public Department getDepartment(int departmentId) {
        Department department = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM departments WHERE department_id = ?");) {
            pstmt.setInt(1, departmentId);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    department = createDepartment(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public void create(Department department) {
        try (PreparedStatement pstmt = getConnection().prepareStatement("INSERT INTO departments (department_name) VALUES (?)");) {
            pstmt.setString(1, department.getName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(Department department) {
        try (PreparedStatement pstmt = getConnection().prepareStatement("UPDATE departments SET department_name = ? WHERE department_id = ?");) {
            pstmt.setString(1, department.getName());
            pstmt.setInt(2, department.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Department department) {
        try (PreparedStatement pstmt = getConnection().prepareStatement("DELETE FROM departments WHERE department_id = ?");) {
            pstmt.setInt(1, department.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
