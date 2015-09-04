package com.sd.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sd.daoimpl.ShoppingListDaoImpl;
import com.sd.pojo.Shoppinglist;

@Controller
public class ShoppingListControllers {
   
    ShoppingListDaoImpl sldi;
   
    public ShoppingListControllers() {
        System.out.println("In controller");
        ApplicationContext d = new ClassPathXmlApplicationContext("Spring-module.xml");
        sldi =(ShoppingListDaoImpl) d.getBean("shoppingDaoImpl");
    }
   
    @RequestMapping(value="/getList",method=RequestMethod.GET)
    public Shoppinglist getListForId(HttpServletRequest req, ModelMap m) {
        int id  =Integer.parseInt( req.getParameter("id"));
        System.out.println("Id in get list of controller is  "+id);
        Shoppinglist sl=sldi.getList(id);
        return sl;
       
    }
   
    @RequestMapping(value="/getLists")
    public ArrayList<Shoppinglist> getList(HttpServletRequest req, ModelMap m) {   
        ArrayList<Shoppinglist> arr=sldi.getLists();
        return arr;
    }
    @RequestMapping(value="/addList",method=RequestMethod.GET)
    public void addList(HttpServletRequest req, ModelMap m) {
        Shoppinglist sl=new Shoppinglist();
        sl.setUid(Integer.parseInt( req.getParameter("uid")));
        sl.setName(req.getParameter("name"));
        sl.setCreateddate(new Date());
        
        sldi.addList(sl);
    }
   
}
