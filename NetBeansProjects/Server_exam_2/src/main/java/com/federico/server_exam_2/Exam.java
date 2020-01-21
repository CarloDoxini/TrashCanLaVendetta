/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.federico.server_exam_2;

import java.util.ArrayList;
import javax.jws.WebService;

/**
 *
 * @author biar
 */
@WebService
public interface Exam {
    public ArrayList<String> getMoviesInfo();
}