/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.federico.jms_flights_server;

/**
 *
 * @author biar
 */
public class Server {
    public static void main(String args[]) throws Exception {

	FlightsGenerator generator = new FlightsGenerator();
        generator.start();
    }
}
