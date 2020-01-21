/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.federico.jms_flights_server;

import java.util.Properties;
import java.util.Random;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author biar
 */
class FlightsGenerator {
    private Random randomGen = new Random();
    private static final String uppercaseCharacters = "QWERTYUIOPASDFGHJKLZXCVBNM";


    private String getFlight() {
        return String.format("%c%c%03d", // 2 characters + 3 digits
                uppercaseCharacters.charAt(randomGen.nextInt(uppercaseCharacters.length())),
                uppercaseCharacters.charAt(randomGen.nextInt(uppercaseCharacters.length())),
                randomGen.nextInt(1000));
    }
    public void start() throws NamingException, JMSException {
        Context jndiContext = null;
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        Destination destination = null;
        MessageProducer producer = null;
        String destinationName = "dynamicTopics/Flights";
        
        try {
    
            Properties props = new Properties();
    
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
            jndiContext = new InitialContext(props);        
    
        } catch (NamingException e) {
            System.out.println("ERROR in JNDI: " + e.toString());
            System.exit(1);
        }
        connectionFactory = (ConnectionFactory)jndiContext.lookup("ConnectionFactory");
        destination = (Destination)jndiContext.lookup("dynamicTopics/Flights");

        connection = connectionFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        producer = session.createProducer(destination);

        int item = 0;
        String flight;
        String text;
        Boolean landed;
        TextMessage message = session.createTextMessage();
        while(true){
            flight = getFlight();
            item += 1;
            landed = randomGen.nextBoolean();
            message.setStringProperty("flight", flight);
            message.setStringProperty("item", Integer.toString(item));
            message.setBooleanProperty("landed", landed);
            text = String.format("Item %d >> flight %s has landed : %b", item, flight, landed);
            message.setText(text);
            producer.send(message);
            System.out.println(text);
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    

}
