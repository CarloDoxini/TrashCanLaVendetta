/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.federico.jms_client;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author biar
 */
class myListener implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        TextMessage msg1 = null;
        try {
            if (msg instanceof TextMessage) {
                msg1 = (TextMessage) msg;
                if (msg1.getStringProperty("Nome").equals("Oracle")){
                    System.out.println("Reading message: " + msg1.getText());
                }
                else {
                        System.out.println("Messaggio filtrato");
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
