/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examluglioclient;
import com.mycompany.examluglioserver.*;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        ServiceImplService service = new ServiceImplService();
        Service port = service.getServiceImplPort();
        ArrayList<Movie> list = new ArrayList<Movie>(port.getMovies());
        
        for (Movie m : list) {
            System.out.println("Il film dal titolo: "+ m.getTitle() +", del grande e irreprensibile: "+ m.getDirector().getName() + " nato il giorno:"+ m.getDirector().getYear()+", il film è uscito il: "+ m.getYear());
        }
    }
    
    
}
