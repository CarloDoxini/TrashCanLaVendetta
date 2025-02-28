package com.abruzzo.soapserver;


import java.util.Map;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author biar
 */
@WebService
public interface WS {
    public String hello(String name);
    
    public String helloStudent(Student student);
    
    @XmlJavaTypeAdapter(StudentMapAdapter.class)
    public Map<Integer,Student> getStudents();
}
