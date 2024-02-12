package com.uni_sabios.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        List<Course> listCourse = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM courses");
            while (rs.next()) {
                listCourse.add(createCourse(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCourse;
    }

    @Override
    public Course getCourse(int courseId) {
        Course course = null;
        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM courses WHERE course_id = ?");) {
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                course = createCourse(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public void create(Course course) {
        try (PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO courses (course_name, course_guide) VALUES (?, ?)");) {
            stmt.setString(1, course.getName());
            stmt.setString(2, course.getGuideDoc());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(Course course) {
        try (PreparedStatement stmt = getConnection().prepareStatement("UPDATE courses SET course_name = ?, course_guide = ? WHERE course_id = ?");) {
            stmt.setString(1, course.getName());
            stmt.setString(2, course.getGuideDoc());
            stmt.setInt(3, course.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Course course) {
        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM courses WHERE course_id = ?");) {
            stmt.setInt(1, course.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Course createCourse(ResultSet rs) throws SQLException{
        
        return new Course(rs.getInt("course_id"), rs.getString("course_name"), rs.getString("course_guide"));
    }
    
}
