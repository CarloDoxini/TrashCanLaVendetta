
package com.mycompany.client_web_application;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {
    static Client client;
    private static CloseableHttpClient clientxml;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        client = ClientBuilder.newClient();
        clientxml = HttpClients.createDefault();
        /*
        //get 
        WebTarget webTarget  = client.target("http://localhost:8080/Bank/");
        WebTarget depWebTarget = webTarget.path("accounts/1");
        Invocation.Builder builder = depWebTarget.request("text/xml");
        BankAccount dep = builder.accept(MediaType.TEXT_XML).get(BankAccount.class);
        System.out.println(dep.toString());
        
        //put
        webTarget = client.target("http://localhost:8080/Bank/accounts/2/JacopoCaccola");
        builder = webTarget.request("text/xml");
        Response res = builder.put(Entity.entity("JacopoCaccola", MediaType.TEXT_XML));
        System.out.println(res.getStatus());
        
        //get sul elemento modificato sulla put 
        webTarget  = client.target("http://localhost:8080/Bank/");
        depWebTarget = webTarget.path("accounts/2");
        builder = depWebTarget.request("text/xml");
        dep = builder.accept(MediaType.TEXT_XML).get(BankAccount.class);
        System.out.println(dep.toString());
        */
        System.out.println("AGGIUNGO OPERAZIONE IN POST:");
        
        //post nuova operazione
        Operation op = new Operation(1,1,"20-12-96","svapo di federico");
        WebTarget webTarget2  = client.target("http://localhost:8080/Bank/");
        WebTarget postTargetOp= webTarget2.path("accounts/1");
        Invocation.Builder build_post_op = postTargetOp.request("text/xml");
        Response post_op_response= build_post_op.post(Entity.entity(op, MediaType.TEXT_XML));
        System.out.println(post_op_response.getStatus());
        
        /*
        Operation newOperation = new Operation();
        newOperation.setId(6);
        newOperation.setId_bankAccount(1);
        newOperation.setData("19/12/96");
        newOperation.setDescription("Prelievo");
        
        //post 
        WebTarget webTarget2 = client.target("http://localhost:8080/Bank/accounts/1/operations");
        
        Invocation.Builder builder2 = webTarget2.request("text/xml");
        Response res2 = builder2.post(Entity.entity(newOperation, MediaType.TEXT_XML));
        System.out.println(res2.getStatus());
        
        
        //get sul elemento nuovo
        WebTarget webTarget3  = client.target("http://localhost:8080/Bank/accounts/1");
        
        Invocation.Builder builder3 = webTarget3.request("text/xml");
        
        BankAccount dep1 = builder3.accept(MediaType.TEXT_XML).get(BankAccount.class);
        System.out.println(dep1.toString());/*
        */
        
        System.out.println("GET DOPO LA POST:");
        
        //printo per controllare se abbiamo cambiato
        WebTarget target33= client.target("http://localhost:8080/Bank/");
        WebTarget getTarget= target33.path("accounts/1");
        Invocation.Builder build = getTarget.request("text/xml");
        BankAccount pippo = build.accept(MediaType.TEXT_XML).get(BankAccount.class);
        System.out.println(pippo.toString());
        System.out.println(pippo.getOperations().isEmpty());
    }
}
