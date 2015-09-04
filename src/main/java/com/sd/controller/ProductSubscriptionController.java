package com.sd.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;


import com.sd.dao.ProductSubscriptionDao;


@Controller
public class ProductSubscriptionController {
   
	ProductSubscriptionDao productionSubscriptionImpl;
   
    public ProductSubscriptionController() {
        System.out.println("In controller");
        ApplicationContext d = new ClassPathXmlApplicationContext("Spring-module.xml");
        productionSubscriptionImpl =(ProductSubscriptionDao) d.getBean("productionSubscriptionImpl");
    }
      
}
