/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abruzzo.restproject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("bank")
@Produces("text/xml")
public class Repository {
     private Map<Integer, BankAccount> accounts = new HashMap<>();
 
    private BankAccount findById(int id) {
        for (Map.Entry<Integer, BankAccount> acc : accounts.entrySet()) {
            if (acc.getKey() == id)
                return acc.getValue();
        }
        return null;
    }
     
    {
    BankAccount account1 = new BankAccount(1, 10, "Carlo Dossini");
    BankAccount account2 = new BankAccount(2, 100, "Andrea");
    BankAccount account3 = new BankAccount(3, 300000, "Francesco Carpineti");
    
    accounts.put(account1.getId(), account1);
    accounts.put(account2.getId(), account2);
    accounts.put(account3.getId(), account3);
    }
    
    @GET
    @Path("accounts/{accountID}")
    public BankAccount getAccount(@PathParam("accountID")int accountID) {
        return findById(accountID);
    }
    
    @PUT
    @Path("accounts/{accountID}/{name}")
    public Response changeName(@PathParam("accountID")int accountID,@PathParam("name") String name){
        BankAccount account= findById(accountID);
        if (account == null) 
            return Response.status(Response.Status.NOT_FOUND).build();
        else {
            if (account.getName().equals(name))
                return Response.status(Response.Status.NOT_MODIFIED).build();
            else 
                account.setName(name);
                accounts.put(accountID, account);
                return Response.ok().build();
        }
    }
    
    @POST
    @Path("accounts/{accountID}")
    public Response addOperation(@PathParam("accountID") int accountID, Operation op){
        BankAccount account= findById(accountID);
        if (account == null) 
            return Response.status(Response.Status.NOT_FOUND).build();
        else {
            for (Operation opp : account.getOperations()) {
                if (opp.getId() == op.getId()) {
                    return Response.status(Response.Status.CONFLICT).build();
                }
        }
            account.addOperation(op);
            accounts.put(accountID, account);
            return Response.ok().build();
        }
    }
}
