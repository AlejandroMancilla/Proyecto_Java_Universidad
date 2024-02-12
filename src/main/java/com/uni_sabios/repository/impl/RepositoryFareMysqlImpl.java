package com.uni_sabios.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uni_sabios.repository.RepositoryFare;
import com.uni_sabios.repository.models.Fare;
import com.uni_sabios.utils.conexiondb.conexionbdmysql.ConexionBDMysql;

public class RepositoryFareMysqlImpl implements RepositoryFare {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    @Override
    public List<Fare> list() {
        

        List<Fare> listTuition = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tuitions");) {
            while (rs.next()) {
                listTuition.add(createFare(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTuition;

    }

    @Override
    public Fare getFare(int fareId) {
        Fare fare = null;
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tuitions WHERE tuition_id = " + fareId);) {
            if (rs.next()) {
                fare = createFare(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fare;
    }

    @Override
    public void create(Fare fare) {
        try (PreparedStatement pstmt = getConnection().prepareStatement("INSERT INTO tuitions (credit_cost, program_id, period_id) VALUES (?, ?, ?)");) {
            pstmt.setInt(1, fare.getCreditValue());
            pstmt.setInt(2, fare.getProgramId());
            pstmt.setInt(3, fare.getPeriodId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(Fare fare) {
        try (PreparedStatement pstmt = getConnection().prepareStatement("UPDATE tuitions SET credit_cost = ?, program_id = ?, period_id = ? WHERE tuition_id = ?");) {
            pstmt.setInt(1, fare.getCreditValue());
            pstmt.setInt(2, fare.getProgramId());
            pstmt.setInt(3, fare.getPeriodId());
            pstmt.setInt(4, fare.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Fare fare) {
        try (PreparedStatement pstmt = getConnection().prepareStatement("DELETE FROM tuitions WHERE tuition_id = ?");) {
            pstmt.setInt(1, fare.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private Fare createFare(ResultSet rs) throws SQLException {
        return new Fare(rs.getInt("tuition_id"), rs.getInt("credit_cost"), rs.getInt("program_id"), rs.getInt("period_id"));
    }

    @Override
    public int getFarebyPeriodSubject(String document, int period) {
        int fare = 0;
        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM tuitions t INNER JOIN programs p ON t.program_id = p.program_id INNER JOIN students s ON s.program_id = p.program_id INNER JOIN persons pe ON pe.person_id = s.person_id WHERE t.period_id = ? AND pe.document_numb = ?" );) {
            stmt.setInt(1, period);
            stmt.setString(2, document);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    fare = rs.getInt("credit_cost");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fare;
    }
}
