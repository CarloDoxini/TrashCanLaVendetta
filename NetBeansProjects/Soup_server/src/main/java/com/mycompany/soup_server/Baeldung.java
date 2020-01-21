/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soup_server;

import java.util.Map;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author biar
 */
@WebService
public interface Baeldung {
    public String hello(String name);
 
    public String helloStudent(Student student);
 
    @XmlJavaTypeAdapter(StudentMapAdapter.class)
    public Map<Integer, Student> getStudents();
}