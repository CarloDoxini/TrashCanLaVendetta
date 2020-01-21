
package com.federico.server_exam_2;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Exam", targetNamespace = "http://server_exam_2.federico.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Exam {


    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMoviesInfo", targetNamespace = "http://server_exam_2.federico.com/", className = "com.federico.server_exam_2.GetMoviesInfo")
    @ResponseWrapper(localName = "getMoviesInfoResponse", targetNamespace = "http://server_exam_2.federico.com/", className = "com.federico.server_exam_2.GetMoviesInfoResponse")
    public List<String> getMoviesInfo();

}
