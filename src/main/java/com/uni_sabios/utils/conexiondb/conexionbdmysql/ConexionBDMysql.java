package com.uni_sabios.utils.conexiondb.conexionbdmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.uni_sabios.utils.Configuration;

public class ConexionBDMysql {
    
    private static String url = Configuration.getValue("db.url");
    private static String username = Configuration.getValue("db.username");
    private static String password = Configuration.getValue("db.password");
    private static Connection connection;
    
    public static Connection getInstance() throws SQLException {
        if(connection == null) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
