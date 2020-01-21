/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examluglioserver;

public class Movie {
    private String title;
    private Director director;
    private String year;
    private int id;

    public Movie() {}

    public Movie(String title, Director director, String year, int id) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
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

    @Override
    public String toString() {
        return "Movie{" + "title=" + title + ", director=" + director + ", year=" + year + ", id=" + id + '}';
    }
}
