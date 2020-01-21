/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest_web_application;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author biar
 */
@Path("Bank")
@Produces("text/xml")
public class BankAccountRepository {
    private Map<Integer, BankAccount> BankAccounts = new HashMap<>();
    
    private BankAccount findById(int id) {
        for (Map.Entry<Integer, BankAccount> BankAccount : BankAccounts.entrySet()) {
            if (BankAccount.getKey() == id) {
                return BankAccount.getValue();
            }
        }
        return null;
    }
    {
        BankAccount account1 = new BankAccount(1, 10000, "Federico Gioia");
        BankAccount account2 = new BankAccount(2, 20000, "Giuliano Abruzzo");
        BankAccount account3 = new BankAccount(3, 15000, "Francesco Carpineti");
        
        BankAccounts.put(account1.getId(), account1);
        BankAccounts.put(account2.getId(), account2);
        BankAccounts.put(account3.getId(), account3);
        
    }
    @GET
    @Path("accounts/{bankaccountId}")
    public BankAccount getBankAccount(@PathParam("bankaccountId") int bankaccountId) {
        return findById(bankaccountId);
    }
    @PUT
    @Path("accounts/{bankaccountId}/{newname}")
    public Response updateBankAccountName(@PathParam("bankaccountId") int bankaccountId, @PathParam("newname") String name) {
        BankAccount existingAccount = findById(bankaccountId);        
        if (existingAccount == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (existingAccount.getName().equals(name)) {
            return Response.status(Response.Status.NOT_MODIFIED).build();  
            
        }
        else {
            existingAccount.setName(name);
            BankAccounts.put(existingAccount.getId(), existingAccount);
            return Response.ok().build();
        }
    }
    /*
    @POST
    @Path("accounts/{bankaccountId}")
    public Response addOperationtoAccount(@PathParam("bankaccountId") int bankaccountId, Operation actual_op) {
        BankAccount existingAccount = findById(bankaccountId);
        if (existingAccount == null) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        else {
            for (Operation op: existingAccount.getOperations()) {
                if (op.getId() == actual_op.getId()) {
                    return Response.status(Response.Status.CONFLICT).build();
                }
            }
            
            existingAccount.addOperations(actual_op);
            System.out.println(existingAccount.getOperations());
            BankAccounts.put(existingAccount.getId(), existingAccount);
            System.out.println(BankAccounts);
            return Response.ok().build();
        }
    }

    @Path("accounts/{bankaccountId}/operations")
    public BankAccount pathToStudent(@PathParam("bankaccountId") int courseId) {
        return findById(courseId);
    }
    */
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
            account.addOperations(op);
            BankAccounts.put(accountID, account);
            return Response.ok().build();
        }
    }
}
