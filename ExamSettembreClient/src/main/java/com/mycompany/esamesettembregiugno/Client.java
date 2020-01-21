/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.esamesettembregiugno;

import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.*;

public class Client {
    static java.sql.Connection dbConnection;

    public static void main(String[] args) throws NamingException, JMSException, SQLException, ClassNotFoundException {
       
        Properties properties = null;
        Context jndiContext = null;
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        Destination destination = null;
        String destinationName = "dynamicTopics/Flights";
                        
        properties = new Properties();
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        properties.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        jndiContext = new InitialContext(properties);
        
        connectionFactory = (ConnectionFactory)jndiContext.lookup("ConnectionFactory");
        destination = (Destination)jndiContext.lookup("dynamicTopics/Flights");

        connection = connectionFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        MessageConsumer consumer = session.createConsumer(destination);
        MessageListener listener = new TheListener();
        consumer.setMessageListener(listener);
        connection.start();
        
    }
    private static class TheListener implements MessageListener {
        
        public TheListener() {
            try {
                dbConnection = DriverManager.getConnection("jdbc:sqlite:/home/biar/se-2019_09.db");
                try {
                    Class.forName("org.sqlite.JDBC");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        @Override
        public void onMessage(Message msg) {
            TextMessage message= null;
            String status = null;
            String flight = null;
                
            try {
                if (msg instanceof TextMessage) {
                    message = (TextMessage) msg;
                    status = message.getStringProperty("status");
                    flight = message.getStringProperty("flight");
                    Statement stat = dbConnection.createStatement();
                    stat.executeUpdate("INSERT INTO flights VALUES('"+flight +"','"+status+"');");
                    System.out.println("Inserito nel database il valore: "+flight+" "+status);
                }
            }
            catch (JMSException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

}
