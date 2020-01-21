package com.abruzzo.restclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class RestClient {
    static Client client;
    private static CloseableHttpClient clientxml;
    
    public static void main(String[] args) {
        client =  ClientBuilder.newClient();   
        clientxml= HttpClients.createDefault();
        WebTarget webtarget = client.target("http://localhost:8000/bank");
        
        System.out.println("PRIMA GET:");
        
        //printo la prima get
        WebTarget getTarget= webtarget.path("accounts/1");
        Invocation.Builder build = getTarget.request("text/xml");
        BankAccount account = build.accept(MediaType.TEXT_XML).get(BankAccount.class);
        System.out.println(account.toString());
        
        System.out.println("ESEGUO LA PUT:");
        
        //printo la put cioe la modifica
        WebTarget putTarget= webtarget.path("accounts/1/down");
        Invocation.Builder build_put = putTarget.request("text/xml");
        Response put_response= build_put.put(Entity.entity("down", MediaType.TEXT_XML));
        System.out.println(put_response.getStatus());
        
        System.out.println("GET DOPO LA PUT:");
       
        //printo per controllare se abbiamo cambiato
        getTarget= webtarget.path("accounts/1");
        build = getTarget.request("text/xml");
        BankAccount pippo = build.accept(MediaType.TEXT_XML).get(BankAccount.class);
        System.out.println(pippo.toString());
        
        System.out.println("AGGIUNGO OPERAZIONE IN POST:");
        
        //post nuova operazione
        Operation op = new Operation(1,1,"20-12-96",100,"svapo di federico");
        WebTarget postTargetOp= webtarget.path("accounts/1");
        Invocation.Builder build_post_op = postTargetOp.request("text/xml");
        Response post_op_response= build_post_op.post(Entity.entity(op, MediaType.TEXT_XML));
        System.out.println(post_op_response.getStatus());
        
        System.out.println("GET DOPO LA POST:");
        
        //printo per controllare se abbiamo cambiato
        getTarget= webtarget.path("accounts/1");
        build = getTarget.request("text/xml");
        pippo = build.accept(MediaType.TEXT_XML).get(BankAccount.class);
        System.out.println(pippo.toString());
    }
    
}

