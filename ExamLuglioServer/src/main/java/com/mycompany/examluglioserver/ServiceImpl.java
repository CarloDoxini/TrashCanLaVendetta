/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examluglioserver;

import static com.mycompany.examluglioserver.Server.db;
import java.sql.Connection;
import java.util.ArrayList;
import javax.jws.WebService;

@WebService(endpointInterface = "com.mycompany.examluglioserver.Service")
public class ServiceImpl implements Service {
    
    static String url = "jdbc:sqlite:" + db;
    Connection conn = SQLiteConnection.connect(url);
    
    @Override
    public ArrayList<Movie> getMovies() {
        return Server.getList(conn);
    }
}
