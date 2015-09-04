package com.sd.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.sd.dao.listItemsDao;

@Controller
public class ListItemsController {
   
    listItemsDao listItemDaoImpl;
   
    public ListItemsController() {
        System.out.println("In controller");
        ApplicationContext d = new ClassPathXmlApplicationContext("Spring-module.xml");
        listItemDaoImpl =(listItemsDao) d.getBean("listItemsDaoImpl");
    }
      
}
