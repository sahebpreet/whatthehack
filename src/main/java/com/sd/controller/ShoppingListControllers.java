package com.sd.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.sd.dao.ShoppingListDao;


@Controller
public class ShoppingListControllers {
   
    ShoppingListDao shoppingDaoImpl;
   
    public ShoppingListControllers() {
        System.out.println("In controller");
        ApplicationContext d = new ClassPathXmlApplicationContext("Spring-module.xml");
        shoppingDaoImpl =(ShoppingListDao) d.getBean("shoppingDaoImpl");
    }
      
}
