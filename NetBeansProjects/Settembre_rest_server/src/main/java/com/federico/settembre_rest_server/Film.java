/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.federico.settembre_rest_server;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author biar
 */
@XmlRootElement(name = "Film")
public class Film {
    private String name;
    private String director;
    private String date;

    public Film(){}
    
    public Film(String name, String director, String date) {
        this.name = name;
        this.director = director;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Film{" + "name=" + name + ", director=" + director + ", date=" + date + '}';
    }
    
    
}
