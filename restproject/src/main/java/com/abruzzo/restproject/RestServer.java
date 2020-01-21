/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abruzzo.restproject;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class RestServer {
    public static void main(String[] args) {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(Repository.class);
        factoryBean.setResourceProvider(
        new SingletonResourceProvider(new Repository()));
        factoryBean.setAddress("http://localhost:8000/");
        Server server = factoryBean.create(); 
    }
    
}

