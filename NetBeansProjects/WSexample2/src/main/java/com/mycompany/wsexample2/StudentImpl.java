/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wsexample2;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author biar
 */
@XmlType(name = "Student")
public class StudentImpl implements Student{
    private String name;

    public StudentImpl() {
    }

    public StudentImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
