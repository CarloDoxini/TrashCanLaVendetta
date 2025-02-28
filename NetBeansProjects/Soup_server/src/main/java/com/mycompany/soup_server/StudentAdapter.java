/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soup_server;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author biar
 */
public class StudentAdapter extends XmlAdapter<StudentImpl, Student> {
    public StudentImpl marshal(Student student) throws Exception {
        if (student instanceof StudentImpl) {
            return (StudentImpl) student;
        }
        return new StudentImpl(student.getName());
    }
 
    public Student unmarshal(StudentImpl student) throws Exception {
        return student;
    }
}
