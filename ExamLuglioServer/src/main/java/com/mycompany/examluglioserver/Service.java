/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examluglioserver;
import java.util.ArrayList;
import javax.jws.WebService;

@WebService
public interface Service {
    public ArrayList<Movie> getMovies();
}
