/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soup_server;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.jws.WebService;

/**
 *
 * @author biar
 */
@WebService(endpointInterface = "com.mycompany.soup_server")
public class BaeldungImpl implements Baeldung{
    private Map<Integer, Student> students 
      = new LinkedHashMap<Integer, Student>();
 
    public String hello(String name) {
        return "Hello " + name;
    }
 
    public String helloStudent(Student student) {
        students.put(students.size() + 1, student);
        return "Hello " + student.getName();
    }
 
    public Map<Integer, Student> getStudents() {
        return students;
    }
}
