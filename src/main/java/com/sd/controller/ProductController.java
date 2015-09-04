package com.sd.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.sd.dao.ProductDao;


@Controller
public class ProductController {
   
    ProductDao productDaoImpl;
   
    public ProductController() {
        System.out.println("In controller");
        ApplicationContext d = new ClassPathXmlApplicationContext("Spring-module.xml");
        productDaoImpl =(ProductDao) d.getBean("productDaoImpl");
    }
      
}
