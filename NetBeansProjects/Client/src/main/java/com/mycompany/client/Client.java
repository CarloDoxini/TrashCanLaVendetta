/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.client;

/**
 *
 * @author biar
 */
public class Client {
    public static void main(String[] args) {
        try { // Call Web Service Operation
            com.mycompany.wsexample2.WSImplService service = new com.mycompany.wsexample2.WSImplService();
            com.mycompany.wsexample2.WS port = service.getWSImplPort();
            // TODO initialize WS operation arguments here
            com.mycompany.wsexample2.Student arg0 = new com.mycompany.wsexample2.Student();
            // TODO process result here
            arg0.setName("Massimo");
            java.lang.String result = port.helloStudent(arg0);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        
        try { // Call Web Service Operation
            com.mycompany.wsexample2.WSImplService service = new com.mycompany.wsexample2.WSImplService();
            com.mycompany.wsexample2.WS port = service.getWSImplPort();
            // TODO initialize WS operation arguments here
            com.mycompany.wsexample2.Student arg0 = new com.mycompany.wsexample2.Student();
            // TODO process result here
            arg0.setName("Massimuccio");
            java.lang.String result = port.helloStudent(arg0);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        try { // Call Web Service Operation
            com.mycompany.wsexample2.WSImplService service = new com.mycompany.wsexample2.WSImplService();
            com.mycompany.wsexample2.WS port = service.getWSImplPort();
            // TODO process result here
            com.mycompany.wsexample2.StudentMap result = port.getStudents();
            
            System.out.println("Result = "+result.getEntry().toString());
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

    }
}
