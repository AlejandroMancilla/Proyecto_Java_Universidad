package com.uni_sabios.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uni_sabios.repository.RepositorySubject;
import com.uni_sabios.repository.models.Subject;
import com.uni_sabios.utils.conexiondb.conexionbdmysql.ConexionBDMysql;

public class RepositorySubjectMysqlImpl implements RepositorySubject {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    @Override
    public List<Subject> list() {
        List<Subject> listsubjects = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM signatures");) {
            while (rs.next()) {
                listsubjects.add(createSubject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listsubjects;
    }

    @Override
    public Subject getSubject(int subjectId) {
        Subject subject = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM signatures WHERE signature_id = ?");) {
            pstmt.setInt(1, subjectId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    subject = createSubject(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subject;
    }

    @Override
    public void create(Subject subject) {
        try (PreparedStatement pstmt = getConnection().prepareStatement("INSERT INTO signatures (credits, capacity, duration, name, teacher_id, course_id, period_id) VALUES (?, ?, ?, ?, ?, ?, ?)");) {
            pstmt.setInt(1, subject.getCredits());
            pstmt.setInt(2, subject.getCapacity());
            pstmt.setInt(3, subject.getDuration());
            pstmt.setString(4, subject.getName());
            pstmt.setInt(5, subject.getTeacherId());
            pstmt.setInt(6, subject.getCourseId());
            pstmt.setInt(7, subject.getPeriodId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(Subject subject) {
        try (PreparedStatement pstmt = getConnection().prepareStatement("UPDATE signatures SET credits = ?, capacity = ?, duration = ?, name = ?, teacher_id = ?, course_id = ?, period_id = ? WHERE signature_id = ?");) {
            pstmt.setInt(1, subject.getCredits());
            pstmt.setInt(2, subject.getCapacity());
            pstmt.setInt(3, subject.getDuration());
            pstmt.setString(4, subject.getName());
            pstmt.setInt(5, subject.getTeacherId());
            pstmt.setInt(6, subject.getCourseId());
            pstmt.setInt(7, subject.getPeriodId());
            pstmt.setInt(8, subject.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Subject subject) {
        try (PreparedStatement pstmt = getConnection().prepareStatement("DELETE FROM signatures WHERE signature_id = ?");) {
            pstmt.setInt(1, subject.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Subject createSubject(ResultSet rs) throws SQLException {
        return new Subject(rs.getInt("signatire_id"), rs.getInt("credits"), rs.getInt("capacity"), rs.getInt("duration"), rs.getString("name"), rs.getInt("teacher_id"), rs.getInt("course_id"), rs.getInt("period_id"));
    }
    
}
