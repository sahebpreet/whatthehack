package com.sd.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sd.dao.ShoppingListDao;
import com.sd.pojo.Shoppinglist;


@Controller
public class ShoppingListControllers {
   
    ShoppingListDao shoppingDaoImpl;
   
    public ShoppingListControllers() {
        System.out.println("In controller");
        ApplicationContext d = new ClassPathXmlApplicationContext("Spring-module.xml");
        shoppingDaoImpl =(ShoppingListDao) d.getBean("shoppingDaoImpl");
    }
 
    @RequestMapping(value="/getList")
	public String getListForId(HttpServletRequest req, ModelMap m) {
		int id  =Integer.parseInt( req.getParameter("id"));
		System.out.println("Id in get list of controller is  "+id);
		Shoppinglist sl=shoppingDaoImpl.getList(id);
		HttpSession session = req.getSession();
		session.setAttribute("ShoppingList", sl);
	
		
		return null;
		
    }
	
	@RequestMapping(value="/getLists")
	public String getList(HttpServletRequest req, ModelMap m) {	
		
		
		ArrayList<Shoppinglist> arr=shoppingDaoImpl.getLists();
		HttpSession session = req.getSession();
		session.setAttribute("ShoppingLists", arr);
		
		
		
		return null;
	}
	@RequestMapping(value="/addList")
	public void addList(HttpServletRequest req, ModelMap m) {
		Shoppinglist sl=new Shoppinglist();
		sl.setUid(Integer.parseInt( req.getParameter("uid")));
		sl.setName(req.getParameter("name"));
		
		Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sdate = sdf.format(c.getTime());
        System.out.println("date is "+sdate);
        
        sl.setCreateddate(sdate);
		
		
		shoppingDaoImpl.addList(sl);
	}
    
}
