/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.federico.settembre_rest_client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
/**
 *
 * @author biar
 */
public class RestClient {
    static Client client;
    private static CloseableHttpClient clientxml;
    
    public static void main(String[] args) {
        client =  ClientBuilder.newClient();   
        clientxml= HttpClients.createDefault();
        WebTarget webtarget = client.target("http://localhost:8080/film");
        
        System.out.println("PRIMA GET:");
        
        //printo la prima get
        WebTarget getTarget= webtarget.path("films");
        Invocation.Builder build = getTarget.request("text/xml");
        Films films = build.accept(MediaType.TEXT_XML).get(Films.class);
        System.out.println(films.toString());
    }
}
