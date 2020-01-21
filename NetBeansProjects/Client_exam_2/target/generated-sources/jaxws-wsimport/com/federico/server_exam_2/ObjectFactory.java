
package com.federico.server_exam_2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.federico.server_exam_2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetMoviesInfoResponse_QNAME = new QName("http://server_exam_2.federico.com/", "getMoviesInfoResponse");
    private final static QName _GetMoviesInfo_QNAME = new QName("http://server_exam_2.federico.com/", "getMoviesInfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.federico.server_exam_2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMoviesInfo }
     * 
     */
    public GetMoviesInfo createGetMoviesInfo() {
        return new GetMoviesInfo();
    }

    /**
     * Create an instance of {@link GetMoviesInfoResponse }
     * 
     */
    public GetMoviesInfoResponse createGetMoviesInfoResponse() {
        return new GetMoviesInfoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMoviesInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server_exam_2.federico.com/", name = "getMoviesInfoResponse")
    public JAXBElement<GetMoviesInfoResponse> createGetMoviesInfoResponse(GetMoviesInfoResponse value) {
        return new JAXBElement<GetMoviesInfoResponse>(_GetMoviesInfoResponse_QNAME, GetMoviesInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMoviesInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server_exam_2.federico.com/", name = "getMoviesInfo")
    public JAXBElement<GetMoviesInfo> createGetMoviesInfo(GetMoviesInfo value) {
        return new JAXBElement<GetMoviesInfo>(_GetMoviesInfo_QNAME, GetMoviesInfo.class, null, value);
    }

}
