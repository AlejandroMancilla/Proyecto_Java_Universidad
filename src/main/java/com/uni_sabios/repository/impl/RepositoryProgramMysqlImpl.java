package com.uni_sabios.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import com.uni_sabios.repository.RepositoryProgram;
import com.uni_sabios.repository.models.Program;
import com.uni_sabios.utils.conexiondb.conexionbdmysql.ConexionBDMysql;

public class RepositoryProgramMysqlImpl implements RepositoryProgram{
    
    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    private Program createProgram(ResultSet rs) throws SQLException {
        return new Program(rs.getInt("program_id"), rs.getString("program_name"), rs.getString("program_level"));
    }

    @Override
    public List<Program> list() {
        List<Program> listPrograms = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM programs");) {
            while (rs.next()) {
                listPrograms.add(createProgram(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPrograms;
    }

    @Override
    public Program getProgram(int programId) {
        Program program = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM programs WHERE program_id = ?");) {
            pstmt.setInt(1, programId);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    program = createProgram(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return program;
    }

    @Override
    public void create(Program program) {
        try (PreparedStatement pstmt = getConnection().prepareStatement("INSERT INTO programs (program_name, program_level) VALUES (?, ?)");) {
            pstmt.setString(1, program.getName());
            pstmt.setString(2, program.getLevel());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(Program program) {
        try (PreparedStatement pstmt = getConnection().prepareStatement("DELETE FROM programs WHERE program_id = ?");) {
            pstmt.setInt(1, program_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Program program) {
        try (PreparedStatement pstmt = getConnection().prepareStatement("UPDATE programs SET program_name = ?, program_level = ? WHERE program_id = ?");) {
            pstmt.setString(1, program.getName());
            pstmt.setString(2, program.getLevel());
            pstmt.setInt(3, program.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
