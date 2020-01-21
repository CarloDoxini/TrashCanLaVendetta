
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author biar
 */
class Listener implements MessageListener {
    Connection connection;
    Statement statement;
    public Listener() throws SQLException, ClassNotFoundException{
        String url = "jdbc:sqlite:/home/biar/se-2019_09.db";
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection(url);
        }
        catch (SQLException ex){
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void onMessage(Message msg) {
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        }
        TextMessage msg1 = null;
        String flight;
        boolean haslanded;
        try {
            if (msg instanceof TextMessage) {
                msg1 = (TextMessage) msg;
                
                flight = msg1.getStringProperty("flight");
                
                
                haslanded = msg1.getBooleanProperty("landed");
           
                String sql = "INSERT INTO flights(flight, haslanded) VALUES(?,?)";
                System.out.println("il messaggio" + msg1.getText() + " è stato inserito nel db");
                PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, flight);
                pstmt.setBoolean(2, haslanded);
        }
    

        }
        catch (SQLException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JMSException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
