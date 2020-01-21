/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abruzzo.restclient;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Operation")
class Operation {
    private int id;
    private int id_account;
    private String data;
    private float amount;
    private String description;

    public Operation(int id, int id_account, String data, float amount, String description) {
        this.id = id;
        this.id_account = id_account;
        this.data = data;
        this.amount = amount;
        this.description = description;
    }
    
    public Operation(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Operation{" + "id=" + id + ", id_account=" + id_account + ", data=" + data + ", amount=" + amount + ", description=" + description + '}';
    }
    
}
