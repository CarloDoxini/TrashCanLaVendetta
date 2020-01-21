/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examgiugnoclient;

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

public class Client {
    public static void main (String args[]) throws NamingException, JMSException{
        //JMS part
        
        Properties properties = null;
        Context jndiContext = null;
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        Destination destination = null;
        String destinationName = "dynamicTopics/professors";
        
        properties = new Properties();
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        properties.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        jndiContext = new InitialContext(properties);
        
        connectionFactory = (ConnectionFactory)jndiContext.lookup("ConnectionFactory");
        destination = (Destination)jndiContext.lookup("dynamicTopics/professors");

        connection = connectionFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        MessageConsumer consumer = session.createConsumer(destination);
        MessageListener listener = new TheListener();
        consumer.setMessageListener(listener);
        connection.start();
        
    }

    private static class TheListener implements MessageListener {

        @Override
        public void onMessage(Message msg) {
            TextMessage message= null;
            String id = null;
            float rank = 0;
            
            try {
                if (msg instanceof TextMessage) {
                    message = (TextMessage) msg;
                    id = message.getStringProperty("id");
                    rank = message.getFloatProperty("rank");
                }   
                //SOAP part
                try {
                    edu.uniroma1.msecs.soapserver.ExamImplService service = new edu.uniroma1.msecs.soapserver.ExamImplService();
                    edu.uniroma1.msecs.soapserver.Exam port = service.getExamImplPort();
                    edu.uniroma1.msecs.soapserver.Professor prof = port.getDetails(id);
                    System.out.println("Ricevuto id:"+ id +", con rank:"+ rank +" "+prof.getName() +" "+ prof.getSurname());
                } 
                catch (Exception ex) {
                    System.out.println("ERRORE");
                }
            } 
            catch (JMSException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
    
}
