/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.federico.client_exam_1;

import edu.uniroma1.msecs.soapserver.Professor;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author biar
 */
class myListener implements MessageListener {
    String Prof_id;
    float rank;

    @Override
    public void onMessage(Message msg) {
        TextMessage msg1 = null;
        try {
            if (msg instanceof TextMessage) {
                msg1 = (TextMessage) msg;
                
                Prof_id = msg1.getStringProperty("id");
                rank = msg1.getFloatProperty("rank");
                
                try { // Call Web Service Operation
            edu.uniroma1.msecs.soapserver.ExamImplService service = new edu.uniroma1.msecs.soapserver.ExamImplService();
            edu.uniroma1.msecs.soapserver.Exam port = service.getExamImplPort();
            
            // TODO initialize WS operation arguments here
            //edu.uniroma1.msecs.soapserver.String arg0 = new edu.uniroma1.msecs.soapserver.GetDetails();
            // TODO process result here
            
            Professor prof = port.getDetails(Prof_id);
            System.out.println("Result = "+ Prof_id + " rank:"+ rank + " bella per " + prof.getName()+ " " + prof.getSurname() );
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
                }
            
             
            else {
                System.out.println("Message of wrong type: " +
                msg.getClass().getName());
            }
        }
        catch (JMSException e) {
            System.out.println("JMSException in onMessage(): " + e.toString());
        } 
        catch (Throwable t) {
            System.out.println("Exception in onMessage():" + t.getMessage());
        }
        
        
    } 
        
    }    

