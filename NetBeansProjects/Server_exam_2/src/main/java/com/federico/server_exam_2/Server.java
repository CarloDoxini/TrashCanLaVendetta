/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.federico.server_exam_2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.xml.ws.Endpoint;

/**
 *
 * @author biar
 */
public class Server {
    static String db = "database.db";
    static String url = "jdbc:sqlite:" + db;
 
    public static void createNewDatabase(Connection conn) {
 
       	try {
		if (conn != null) {
                        String sql1 = "DROP TABLE IF EXISTS 'movies' ";
                        String sql2 = "DROP TABLE IF EXISTS 'directors' ";
                        
                        Statement stmt = conn.createStatement();
                        stmt.executeUpdate(sql1);
                        stmt.executeUpdate(sql2);
                        
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println("Il nome del driver è " + meta.getDriverName());
			System.out.println("E' stato creato il datadase " + db);
		}	
	} catch(Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
    }
    public static void createNewTables(Connection conn) {
 
	// SQL statement for creating a new table
        String sql1 = "CREATE TABLE IF NOT EXISTS directors (\n"
                        + "     id integer PRIMARY KEY,\n"
                        + "     name string NOT NULL,\n"
                        + "     yearOfBirth string NOT NULL\n"
                        + ");";
	String sql2 = "CREATE TABLE IF NOT EXISTS movies (\n"
			+ "	id integer PRIMARY KEY,\n"
			+ "	title string NOT NULL,\n"
			+ "	year string NOT NULL,\n"
                        + "	directorID integer,\n"
                        + "     FOREIGN KEY (directorID) REFERENCES directors(id)\n"
			+ ");";
 
 
	Statement stmt;
	try {
		stmt = conn.createStatement();
		// create a new table
		System.out.println("E' stata creata la tabella movies");
		stmt.execute(sql1);
                stmt.execute(sql2);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
    public static void insertDirectors(Connection conn, int id, String name, String yearOfBirth) {
	String sql = "INSERT INTO directors(id,name,yearOfBirth) VALUES(?,?,?)";
 
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
                pstmt.setString(3, yearOfBirth);
		pstmt.executeUpdate();
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
    }
    public static void insertMovies(Connection conn, int id, String title, String year, int directorID) {
	String sql = "INSERT INTO movies(id,title,year,directorID) VALUES(?,?,?,?)";
 
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.setString(2, title);
                pstmt.setString(3, year);
                pstmt.setInt(4, directorID);
		pstmt.executeUpdate();
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
    } 
    public static ArrayList<String> naturalJoin (Connection conn) {
        String sql = "SELECT * FROM movies JOIN directors ON (movies.directorID = directors.id)";
         
        ArrayList<String> lista = new ArrayList();
	try {
		Statement stmt  = conn.createStatement();
		ResultSet rs    = stmt.executeQuery(sql);
 
		// loop through the result set
		while (rs.next()) {
			lista.add("Il film con id: " + Integer.toString(rs.getInt("id")) + ", ha come titolo: " + 
					rs.getString("title") + ", prodotto nell'anno: " +
					rs.getString("year") + ", dal regista: " +
                                        rs.getString("name") + ", nato: "+
                                        rs.getString("yearOfBirth"));
		}
                
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
        return lista;
    }
    public static void main(String args[]) throws InterruptedException {
        Director director1 = new Director(1, "Victor Flaming", "3/11/1937");
        Director director2 = new Director(2, "Ridley Scott", "30/11/1973");
        Director director3 = new Director(3, "Steven Spielberg", "18/12/1946");
        
        Movie movie1 = new Movie(1, "via col vento", "1951", director1);
        Movie movie2 = new Movie(2, "il gladiatore", "1993", director2);
        Movie movie3 = new Movie(3, "alien", "1980", director2);
        Movie movie4 = new Movie(4, "jurassic park", "1985", director3);
        
        ExamImpl implementor = new ExamImpl();
        String address = "http://localhost:8000/MovieService";
        Endpoint.publish(address, implementor);
        System.out.println("Server ready...");
        
        Connection conn = SQLiteJDBCDriverConnection.connect(url);
        createNewDatabase(conn);
        createNewTables(conn);
	//SQLiteJDBCDRiverConnection.closeConnection(conn);
        
        insertDirectors(conn, director1.getId(), director1.getName(), director1.getYearOfBirth());
        insertDirectors(conn, director2.getId(), director2.getName(), director2.getYearOfBirth());
        insertDirectors(conn, director3.getId(), director3.getName(), director3.getYearOfBirth());
        
        insertMovies(conn, movie1.getId(), movie1.getTitle(), movie1.getYear(), movie1.getDirector().getId());
        insertMovies(conn, movie2.getId(), movie2.getTitle(), movie2.getYear(), movie2.getDirector().getId());
        insertMovies(conn, movie3.getId(), movie3.getTitle(), movie3.getYear(), movie3.getDirector().getId());
        insertMovies(conn, movie4.getId(), movie4.getTitle(), movie4.getYear(), movie4.getDirector().getId());
        
        
        SQLiteJDBCDriverConnection.closeConnection(conn);
    }
}
