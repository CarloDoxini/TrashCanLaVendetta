/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest_web_application;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.endpoint.Server;
/**
 *
 * @author biar
 */

public class RestfulServer {
    public static void main(String args[]) throws Exception {
        // code snippets shown above
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(BankAccountRepository.class);
        
        factoryBean.setResourceProvider(
        new SingletonResourceProvider(new BankAccountRepository()));
        
        factoryBean.setAddress("http://localhost:8080/");
        
        Server server = factoryBean.create();
    }
}
