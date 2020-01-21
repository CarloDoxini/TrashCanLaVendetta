/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest_web_application;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author biar
 */
@XmlRootElement(name = "Operation")
class Operation {
    private int id;
    private int id_bankAccount;
    private String data;
    private String description;

    public Operation(int id, int id_bankAccount, String data, String description) {
        this.id = id;
        this.id_bankAccount = id_bankAccount;
        this.data = data;
        this.description = description;
    }

    public Operation(){};
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_bankAccount() {
        return id_bankAccount;
    }

    public void setId_bankAccount(int id_bankAccount) {
        this.id_bankAccount = id_bankAccount;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Operation{" + "id=" + id + ", id_bankAccount=" + id_bankAccount + ", data=" + data + ", description=" + description + '}';
    }
    
    
}
