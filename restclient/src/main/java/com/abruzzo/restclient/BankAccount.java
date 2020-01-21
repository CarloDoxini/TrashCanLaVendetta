/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abruzzo.restclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BankAccount")
public class BankAccount {
    private int id;
    private float money;
    private String name;
    private List<Operation> operations = new ArrayList();
    
    public BankAccount(){}

    public BankAccount(int id, float money, String name) {
        this.id = id;
        this.money = money;
        this.name = name;
        this.operations = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
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
    
    public void addOperation(Operation op) {
        this.operations.add(op);
    }

    @Override
    public String toString() {
        return "BankAccount{" + "id=" + id + ", money=" + money + "$, name=" + name + ", operations=" + operations.toString() + '}';
    }
    
    
}
