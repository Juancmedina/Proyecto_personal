package com.mycompany.proyecto_personal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jmedina
 */
public class ConnectionUtil {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/universidad";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Juankmilo07";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    } 
}
