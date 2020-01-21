/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.federico.client_settembre_2019;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author biar
 */
class myListener implements MessageListener {

    Connection connection;
    Statement statement;
    myListener() throws SQLException, ClassNotFoundException {
        String url = "jdbc:sqlite:/home/biar/se-2019_09.db";
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection(url);
        }
        catch (SQLException ex){
            Logger.getLogger(myListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void onMessage(Message msg) {
        
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(myListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        TextMessage msg1 = null;
        String flight;
        boolean status;
        try {
            if (msg instanceof TextMessage) {
                msg1 = (TextMessage) msg;
                flight = msg1.getStringProperty("flight");
                status = msg1.getBooleanProperty("status");
           
                String sql = "INSERT INTO flights(flight, status) VALUES(?,?)";
                System.out.println("il messaggio" + msg1.getText() + " è stato inserito nel db");
                PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, flight);
                System.out.println(status);
                if (status){
                    pstmt.setString(2, "landed");
                }
                else{
                    pstmt.setString(2, "not landed");
                }
		pstmt.executeUpdate();
            }
            else {
                System.out.println("Message of wrong type: " +
                msg.getClass().getName());
            }
        }
        catch (JMSException e) {
            System.out.println("JMSException in onMessage(): " + e.toString());
        } 
        catch (SQLException t) {
            System.out.println("Exception in onMessage():" + t.getMessage());
        }
        
    }
    
}
