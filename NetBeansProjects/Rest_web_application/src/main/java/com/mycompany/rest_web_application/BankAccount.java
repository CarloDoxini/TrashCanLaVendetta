/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest_web_application;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author biar
 */
@XmlRootElement(name = "BankAccount")
public class BankAccount {
    private int id;
    private float conto;
    private String name;
    private List<Operation> operations = new ArrayList<>();

    public BankAccount(){};
    
    public BankAccount(int id, float conto, String name) {
        this.id = id;
        this.conto = conto;
        this.name = name;
        this.operations = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getConto() {
        return conto;
    }

    public void setConto(float conto) {
        this.conto = conto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
    
    

    public void addOperations(Operation e) {
        this.operations.add(e);
    }

    @Override
    public String toString() {
        return "BankAccount{" + "id=" + id + ", conto=" + conto + ", name=" + name + ", operations=" + operations.toString() + '}';
    }

    /*
    @POST
    public Response addOperationtoAccount(Operation actual_op) {
        
        
            for (Operation op: operations) {
                if (op.getId() == actual_op.getId()) {
                    return Response.status(Response.Status.CONFLICT).build();
                }
            }
            
            this.addOperations(actual_op);
            
            return Response.ok().build();
        
    }*/
    
}
