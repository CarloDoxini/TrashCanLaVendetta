/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examluglioserver;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.xml.ws.Endpoint;

public class Server {
    static String db = "database.db";
    static String url = "jdbc:sqlite:" + db;
        
    public static void main(String args[]) throws InterruptedException {
        Director director1 = new Director(1,"Fabrizio D'Amore","20-10-1800");
        Director director2 = new Director(2,"Federico Gioia","3-4-1900");
        Director director3 = new Director(3,"Tony Effe","25-12-1996");
        
        Movie mov1 = new Movie("Sopra il culo del cuculo", director1, "10-1-2001", 1);
        Movie mov2 = new Movie("Puttanic", director2, "20-7-2006", 2);
        Movie mov3 = new Movie("Lo svarione degli anelli", director3, "23-5-2019", 3);
        
        Connection conn = SQLiteConnection.connect(url);
        
	createNewDatabase(conn);
	createTables(conn);
        
        insertDirector(conn, director1);
        insertDirector(conn, director2);
        insertDirector(conn, director3);
        
        insertMovie(conn, mov1);
        insertMovie(conn, mov2);
        insertMovie(conn, mov3);
        
        ServiceImpl implementor = new ServiceImpl();
        String address = "http://localhost:8080/MovieService";
        Endpoint.publish(address, implementor);
        System.out.println("Server ready...");
    }
    
    public static ArrayList<Movie> getList(Connection conn) {
        ArrayList<Movie> lista = new ArrayList();
        ArrayList<Director> direttori = new ArrayList();
        String sql = "SELECT id,title,year,directorID FROM movies";
        String sql1 = "SELECT id,name,year from directors";
 
	try {
            Statement stmt = conn.createStatement();
            ResultSet rsdir = stmt.executeQuery(sql1);
            while (rsdir.next()) {
                Director dir = new Director(rsdir.getInt("id"),rsdir.getString("name"),rsdir.getString("year"));
                direttori.add(dir);
            }
            ResultSet rsmovies = stmt.executeQuery(sql);
            while (rsmovies.next()) {
                for (Director dir : direttori) {
                    if (dir.getId() == rsmovies.getInt("directorID")) {
                        Movie mov = new Movie(rsmovies.getString("title"), dir, rsmovies.getString("year"), rsmovies.getInt("id"));
                        lista.add(mov);
                    }
                    
                }
            }
	} 
        catch (SQLException e) {
		System.out.println(e.getMessage());
	}
        
        return lista;
        
    }
    
    public static void createNewDatabase(Connection conn) {
        try {
            if (conn != null) {
                String sql = "DROP TABLE IF EXISTS 'movies' ";
                String sql1= "DROP TABLE IF EXISTS 'directors' ";
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                stmt.executeUpdate(sql1);
                
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Il nome del driver è " + meta.getDriverName());
                System.out.println("E' stato creato il datadase " + db);
            }	
	} 
        catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    
    public static void createTables(Connection conn) {
        String sql1 = "CREATE TABLE IF NOT EXISTS directors (\n"
        + " id INTEGER PRIMARY KEY,\n"
        + " name STRING,\n"
        + " year STRING\n"
        + ");";

        String sql2 = "CREATE TABLE IF NOT EXISTS movies (\n"
        + " id INTEGER PRIMARY KEY,\n"
        + " title STRING,\n"
        + " year STRING,\n"
        + " directorID INTEGER,\n"
        + " FOREIGN KEY (directorID) REFERENCES directors(id)\n"
        + ");";
        
	Statement stmt;
	try {
		stmt = conn.createStatement();
		System.out.println("E' stata creata la tabella");
		stmt.execute(sql1);
                stmt.execute(sql2);
	} 
        catch (SQLException e) {
		e.printStackTrace();
	}
    }	
    
    public static void insertDirector(Connection conn, Director dic) {
	String sql = "INSERT INTO directors(id,name,year) VALUES(?,?,?)";
 
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, dic.getId());
		pstmt.setString(2, dic.getName());
                pstmt.setString(3, dic.getYear());
		pstmt.executeUpdate();
	}
        catch (SQLException e) {
		System.out.println(e.getMessage());
	}
    } 
    
    public static void insertMovie(Connection conn, Movie mov) {
	String sql = "INSERT INTO movies(id,title,year,directorId) VALUES(?,?,?,?)";
 
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, mov.getId());
		pstmt.setString(2, mov.getTitle());
                pstmt.setString(3, mov.getYear());
                pstmt.setInt(4, mov.getDirector().getId());
		pstmt.executeUpdate();
	}
        catch (SQLException e) {
                System.out.println("a zi errori insert");
		System.out.println(e.getMessage());
	}
    } 
 
}
