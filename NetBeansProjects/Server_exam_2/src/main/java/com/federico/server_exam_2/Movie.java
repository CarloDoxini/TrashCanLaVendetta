/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.federico.server_exam_2;

/**
 *
 * @author biar
 */
public class Movie {
    private String title;
    private String year;
    private int id;
    private Director director;
    
    public Movie () {}

    public Movie(int id, String title, String year, Director director) {
        this.title = title;
        this.year = year;
        this.id = id;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
    
    
}
