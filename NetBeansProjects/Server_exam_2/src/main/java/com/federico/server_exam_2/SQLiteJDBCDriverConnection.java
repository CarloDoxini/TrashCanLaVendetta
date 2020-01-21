/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.federico.server_exam_2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
/**
 *
 * @author biar
 */
public class SQLiteJDBCDriverConnection {
    public static Connection connect(String url) {
    	
        Connection conn = null;
        
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url);            
            System.out.println("La connessione a SQLite è stata eseguita con successo.");              
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
    }
    
    /**
     * Chiusura della connessione al database
     * @return 
     */
    public static void closeConnection(Connection conn) {
    	try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
