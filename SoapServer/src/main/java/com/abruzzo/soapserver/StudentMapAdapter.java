/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abruzzo.soapserver;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author biar
 */
public class StudentMapAdapter extends XmlAdapter<StudentMap, Map<Integer, Student>>{

    @Override
    public Map<Integer, Student> unmarshal(StudentMap v) throws Exception {
        Map<Integer,Student> ret = new LinkedHashMap<Integer,Student>();
        for(StudentMap.StudentEntry entry: v.getEntries()){
            ret.put(entry.getId(), entry.getStudent());
        }
        return ret;
    }

    @Override
    public StudentMap marshal(Map<Integer, Student> v) throws Exception {
        StudentMap map = new StudentMap();
        for(Map.Entry<Integer,Student> entry: v.entrySet()){
            StudentMap.StudentEntry value_entry = new StudentMap.StudentEntry();
            value_entry.setStudent(entry.getValue());
            value_entry.setId(entry.getKey());
            map.getEntries().add(value_entry);
        }
        return map;
    }
    
}
