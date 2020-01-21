/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wsexample2;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author biar
 */
public class StudentAdapter extends XmlAdapter<StudentImpl, Student> {

    
    public Student unmarshal(StudentImpl s) throws Exception {
        return s;
    }

    
    public StudentImpl marshal(Student s) throws Exception {
        if (s instanceof StudentImpl){
            return (StudentImpl) s;
        }
        else {
            return new StudentImpl(s.getName());
        }
    }
    
}
