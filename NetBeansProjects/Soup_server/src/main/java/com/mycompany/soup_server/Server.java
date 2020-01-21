/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soup_server;

import javax.xml.ws.Endpoint;



/**
 *
 * @author biar
 */
public class Server {
    public static void main(String args[]) throws InterruptedException {
        BaeldungImpl implementor = new BaeldungImpl();
        String address = "http://localhost:8080/baeldung";
        Endpoint.publish(address, implementor);
        Thread.sleep(60 * 1000);        
        System.exit(0);
    }
}
