package com.uni_sabios.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uni_sabios.repository.RepositorySchedule;
import com.uni_sabios.repository.models.Schedule;
import com.uni_sabios.utils.conexiondb.conexionbdmysql.ConexionBDMysql;

public class RepositoryScheduleMysqlImpl implements RepositorySchedule {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    @Override
    public List<Schedule> list() {
        List <Schedule> listSchedules = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM schedules");) {
            while (rs.next()) {
                listSchedules.add(createSchedule(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSchedules;
    }

    @Override
    public Schedule getSchedule(int scheduleId) {
        Schedule schedule = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM schedules WHERE schedule_id = ?");) {
            pstmt.setInt(1, scheduleId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    schedule = createSchedule(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return schedule;
    }

    @Override
    public void create(Schedule schedule) {
        try (PreparedStatement pstmt = getConnection().prepareStatement("INSERT INTO schedules (schedule_day, start_time, end_time, classroom_id, signature_id) VALUES (?, ?, ?, ?, ?)");) {
            pstmt.setString(1, schedule.getDay());
            pstmt.setString(2, schedule.getStart());
            pstmt.setString(3, schedule.getEnd());
            pstmt.setInt(4, schedule.getClassroomId());
            pstmt.setInt(5, schedule.getSignatureId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(Schedule schedule) {
        try (PreparedStatement pstmt = getConnection().prepareStatement("UPDATE schedules SET schedule_day = ?, start_time = ?, end_time = ?, classroom_id = ?, signature_id = ? WHERE schedule_id = ?");) {
            pstmt.setString(1, schedule.getDay());
            pstmt.setString(2, schedule.getStart());
            pstmt.setString(3, schedule.getEnd());
            pstmt.setInt(4, schedule.getClassroomId());
            pstmt.setInt(5, schedule.getSignatureId());
            pstmt.setInt(6, schedule.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    @Override
    public List<Schedule> listByStudentId(int studentId) {
        
        List <Schedule> listSchedules = new ArrayList<>();

        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM schedules WHERE signature_id IN (SELECT siganture_id FROM registers WHERE student_id = ?)");) {
            pstmt.setInt(1, studentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    listSchedules.add(createSchedule(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listSchedules;

    }

    @Override
    public List<Schedule> listByTeacherId(int teacherId) {

        List <Schedule> listSchedules = new ArrayList<>();

        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM schedules WHERE signature_id IN (SELECT siganture_id FROM signatures WHERE teacher_id = ?)");) {
            pstmt.setInt(1, teacherId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    listSchedules.add(createSchedule(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listSchedules;

    }

    @Override
    public List<Schedule> listBySignatureId(int signatureId) {
        
        List <Schedule> listSchedules = new ArrayList<>();

        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM schedules WHERE signature_id = ?");) {
            pstmt.setInt(1, signatureId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    listSchedules.add(createSchedule(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listSchedules;

    }

    @Override
    public List<Schedule> listByClassroomId(int classroomId) {

        List <Schedule> listSchedules = new ArrayList<>();

        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM schedules WHERE classroom_id = ?");) {
            pstmt.setInt(1, classroomId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    listSchedules.add(createSchedule(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listSchedules;

    }

    @Override
    public List<Schedule> listByDay(String day) {

        List <Schedule> listSchedules = new ArrayList<>();

        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM schedules WHERE schedule_day = ?");) {
            pstmt.setString(1, day);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    listSchedules.add(createSchedule(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listSchedules;

    }
    
    private Schedule createSchedule(ResultSet rs) throws SQLException {
        return new Schedule(rs.getInt("schedule_id"), rs.getString("schedule_day"), rs.getString("start_time"), rs.getString("end_time"), rs.getInt("classroom_id"), rs.getInt("signature_id"));
    }
}
