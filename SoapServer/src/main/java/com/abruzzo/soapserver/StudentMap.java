/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abruzzo.soapserver;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author biar
 */
@XmlType(name="StudentMap")

public class StudentMap {
    private List<StudentEntry> entries = new ArrayList<StudentEntry>();
    
    @XmlElement(nillable = false, name = "entry")
    public List<StudentEntry> getEntries(){
        return entries;
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < entries.size(); i++){
            StudentEntry e = entries.get(i);
            s+= "Id: "+e.getId()+" Student: "+e.getStudent().getName();
        }
        return s;
    }
    
    
    @XmlType(name="StudentEntry")
    public static class StudentEntry{
        private Integer id;
        private Student student;

        public Integer getId() {
            return id;
        }

        public Student getStudent() {
            return student;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setStudent(Student student) {
            this.student = student;
        }
        
        @Override
        public String toString() {
            return "ID: " + this.getId() + " Student: " + this.getStudent();
        }
    }

    
        
}
