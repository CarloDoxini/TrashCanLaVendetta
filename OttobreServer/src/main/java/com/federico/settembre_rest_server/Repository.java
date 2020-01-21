/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.federico.settembre_rest_server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author biar
 */
@Path("film")
@Produces("text/xml")
public class Repository {
    Films lista = new Films();
    {
       Film film1 = new Film("via col vento", "gesu", "1990");
       Film film2 = new Film("padre pio", "bruslagoddigarda", "2005");
       Film film3 = new Film("collavinilica", "artattack", "2000");
       lista.add(film1);
       lista.add(film2);
       lista.add(film3);
       
       
    }
    
    @GET
    @Path("films")
    public Films getFilms() {
        return lista;
    }
}
