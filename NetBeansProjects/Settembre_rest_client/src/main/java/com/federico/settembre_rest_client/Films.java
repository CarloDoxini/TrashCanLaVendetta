/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.federico.settembre_rest_client;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author biar
 */
@XmlRootElement(name = "Films")
public class Films {
    //@XmlElement(name = "Film")
    public ArrayList<Film> listafilm;
    
    
    
    public Films(){
        listafilm = new ArrayList<>();
        
    }
    public void add(Film f){
        this.listafilm.add(f);
    }
    @Override
    public String toString() {
        String s = "I film sono : ";
        for (int i = 0; i<listafilm.size(); i++) {
            s += listafilm.get(i).toString();
            if (i != (listafilm.size() - 1)) {
                s += ", ";
            }
        }
        s += ".";
        return  s;
    }
    
    
}
