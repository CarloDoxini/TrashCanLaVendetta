import javax.jms.Connection;
//import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author biar
 */
public class Client {
    
    public static void main(String[] args) throws NamingException, JMSException, ClassNotFoundException, SQLException {
       
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
        MessageListener listener = new Listener();
        consumer.setMessageListener(listener);
        connection.start();
    }
}
