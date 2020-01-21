/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.federico.client_exam_2;
import com.federico.server_exam_2.Exam;
import com.federico.server_exam_2.ExamImplService;
import java.util.Iterator;
//import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author biar
 */
public class Client {
    public static void main(String[] args) {
        ExamImplService service = new ExamImplService();
        Exam port = service.getExamImplPort();
        List<String> list = (port.getMoviesInfo());
        for (String item : list) {
            System.out.println(item);
        }
        System.out.println("SHAVE LIKE A BOMBER PORCODIO");
        
    }
}
