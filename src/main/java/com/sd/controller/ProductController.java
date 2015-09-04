package com.sd.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.sd.daoimpl.ProductDaoImpl;


@Controller
public class ProductController {
   
    ProductDaoImpl productDaoImpl;
   
    public ProductController() {
        System.out.println("In controller");
        ApplicationContext d = new ClassPathXmlApplicationContext("Spring-module.xml");
        productDaoImpl =(ProductDaoImpl) d.getBean("productDaoImpl");
    }
      
}
