/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abruzzo.soapserver;

import javax.xml.ws.Endpoint;

/**
 *
 * @author biar
 */
public class Server {
    public static void main(String args[]) throws InterruptedException {
        WSImpl implementor = new WSImpl();
        String address = "http://localhost:8080/ws2";
        Endpoint.publish(address, implementor);
        while(true);
    }
}
