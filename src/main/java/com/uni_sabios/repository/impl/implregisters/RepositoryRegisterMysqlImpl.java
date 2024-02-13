package com.uni_sabios.repository.impl.implregisters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uni_sabios.repository.RepositoryRegister;
import com.uni_sabios.repository.models.Register;
import com.uni_sabios.utils.conexiondb.conexionbdmysql.ConexionBDMysql;

public class RepositoryRegisterMysqlImpl implements RepositoryRegister{

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }
    
    @Override
    public List<Register> list() {
        
        List<Register> listRegisters = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM registers");) {
            while (rs.next()) {
                listRegisters.add(createRegister(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listRegisters;
    }

    @Override
    public Register getRegister(int registerId) {
        
        Register register = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM registers WHERE register_id = ?");) {
            pstmt.setInt(1, registerId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    register = createRegister(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return register;

    }

    @Override
    public List<Register> listByStudentId(String document, int period) {
        List<Register> listRegisters = new ArrayList<>();
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM registers r INNER JOIN students s ON r.student_id = s.student_id INNER JOIN persons p ON p.person_id = s.person_id WHERE p.document_numb = ? AND r.period_id = ?");) {
            pstmt.setString(1, document);
            pstmt.setInt(2, period);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    listRegisters.add(createRegister(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listRegisters;
    }

    @Override
    public int listByPeriod(int periodId) {
        int income = 0;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT si.credits, t.credit_cost FROM registers r INNER JOIN students s ON r.student_id = s.student_id INNER JOIN signatures si ON si.signature_id = r.signature_id INNER JOIN tuitions t ON (t.period_id = r.period_id) AND (t.program_id = s.program_id) WHERE r.period_id = ?");) {
            pstmt.setInt(1, periodId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    income+= rs.getInt("credits") * rs.getInt("credit_cost");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return income;
    }

    @Override
    public void create(Register register) {

        try (PreparedStatement pstmt = getConnection().prepareStatement("INSERT INTO registers (student_id, period_id, signature_id) VALUES (?, ?, ?)");) {
            pstmt.setInt(1, register.getStudentId());
            pstmt.setInt(2, register.getPeriodId());
            pstmt.setInt(3, register.getSubjectId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void modify(Register register) {

        try (PreparedStatement pstmt = getConnection().prepareStatement("UPDATE registers SET student_id = ?, period_id = ?, signature_id = ? WHERE register_id = ?");) {
            pstmt.setInt(1, register.getStudentId());
            pstmt.setInt(2, register.getPeriodId());
            pstmt.setInt(3, register.getSubjectId());
            pstmt.setInt(4, register.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Register createRegister(ResultSet rs) throws SQLException {
        return new Register(rs.getInt("register_id"), rs.getInt("student_id"), rs.getInt("period_id"), rs.getInt("signature_id"));
    }

    
}
