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
import static com.federico.server_exam_2.Server.naturalJoin;
//import static com.federico.server_exam_2.Server.url;
import java.sql.Connection;
import java.util.ArrayList;
import javax.jws.WebService;

/**
 *
 * @author biar
 */
@WebService(endpointInterface = "com.federico.server_exam_2.Exam")
public class ExamImpl implements Exam {
    static String db = "database.db";
    static String url = "jdbc:sqlite:" + db;

    
    @Override
    public ArrayList<String> getMoviesInfo() {
        Connection conn = SQLiteJDBCDriverConnection.connect(url);
        return naturalJoin(conn);
    }
}