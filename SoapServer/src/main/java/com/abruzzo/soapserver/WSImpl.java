/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abruzzo.soapserver;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.jws.WebService;

/**
 *
 * @author biar
 */
@WebService(endpointInterface="com.mycompany.wsexample2.WS")
public class WSImpl implements WS{
    private Map<Integer,Student> students = new LinkedHashMap<Integer,Student>();
    public String hello(String name){
        return "Hello " + name;
    }
    public String helloStudent(Student student){
        students.put(students.size()+1, student);
        return "Hello " + student.getName();
    }

    @Override
    public Map<Integer, Student> getStudents() {
        return students;
    }
}
