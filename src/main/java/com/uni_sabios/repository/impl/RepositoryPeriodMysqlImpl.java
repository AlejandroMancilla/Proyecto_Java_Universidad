package com.uni_sabios.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uni_sabios.exceptions.periodexceptions.PeriodExceptionInsertDataBase;
import com.uni_sabios.repository.RepositoryPeriod;
import com.uni_sabios.repository.models.Period;
import com.uni_sabios.utils.conexiondb.conexionbdmysql.ConexionBDMysql;

public class RepositoryPeriodMysqlImpl implements RepositoryPeriod {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    @Override
    public List<Period> list() {
        List<Period> listPeriods = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM periods");) {
            while (rs.next()) {
                listPeriods.add(createPeriod(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPeriods;
    }

    @Override
    public Period getPeriod(int periodId) {
        Period period = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM periods WHERE period_id = ?");) {
            pstmt.setInt(1, periodId);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    period = createPeriod(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return period;
    }

    @Override
    public void create(Period period) throws PeriodExceptionInsertDataBase {

        Connection conn = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO periods (period_year, semester, period_code) VALUES (?, ?, ?)",Statement.RETURN_GENERATED_KEYS);){
                pstmt.setString(1, period.getYear());
                pstmt.setString(2, period.getSemester());
                pstmt.setString(3, period.getCode());
                pstmt.executeUpdate();

                try (ResultSet rs = pstmt.getGeneratedKeys();) {
                    if (rs.next()) {
                        period.setId(rs.getInt(1));
                    } else {
                        throw new SQLException("Error inserting period in the database");
                    }
                } 
            }

            conn.commit();
        } catch (SQLException e) {
            try {
                if (conn != null){ 
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new PeriodExceptionInsertDataBase("Error inserting period in the database");
        }
        
    }

    @Override
    public void modify(Period period) {
        
        try (PreparedStatement pstmt = getConnection().prepareStatement("UPDATE periods SET period_year = ?, semester = ?, period_code = ? WHERE period_id = ?");) {
            pstmt.setString(1, period.getYear());
            pstmt.setString(2, period.getSemester());
            pstmt.setString(3, period.getCode());
            pstmt.setInt(4, period.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    private Period createPeriod(ResultSet rs) throws SQLException {
        Period period = new Period();
        period.setId(rs.getInt("period_id"));
        period.setCode(rs.getString("period_code"));
        period.setYear(rs.getString("period_year"));
        period.setSemester(rs.getString("semester"));
        return period;
    }
    
}
