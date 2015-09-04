package com.sd.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sd.dao.listItemsDao;
import com.sd.pojo.Product;
import com.sd.pojo.Shoppinglist;

@Controller
public class ListItemsController {
   
    listItemsDao listItemDaoImpl;
   
    public ListItemsController() {
        System.out.println("In controller");
        ApplicationContext d = new ClassPathXmlApplicationContext("Spring-module.xml");
        listItemDaoImpl =(listItemsDao) d.getBean("listItemsDaoImpl");
    }
    

	@RequestMapping(value="/listItems")
	public String getItemList(HttpServletRequest req, ModelMap m){
	
		int id =Integer.parseInt(req.getParameter("lid"));
		Shoppinglist list =new Shoppinglist();
		list.setId(id);
		List<Product> products=listItemDaoImpl.getListItems(list);
		HttpSession s=req.getSession();
		s.setAttribute("productList", products);
		for(Product p:products){
			System.out.println(p);
		}
		return "test";
		
	}
	
	@RequestMapping(value="/addItem")
	public String addItem(HttpServletRequest req, ModelMap m){
		
		int lid =Integer.parseInt(req.getParameter("lid"));
		Shoppinglist list =new Shoppinglist();
		list.setId(lid);
		
		
		int pid=Integer.parseInt(req.getParameter("pid"));
		Product p=new Product();
		p.setId(pid);
		listItemDaoImpl.addItem(list, p);
		
		return null;
	}

	@RequestMapping(value="/deleteItems")
	public String deleteItem(HttpServletRequest req, ModelMap m){
		
		int lid =Integer.parseInt(req.getParameter("lid"));
		Shoppinglist list =new Shoppinglist();
		list.setId(lid);
		
		
		int pid=Integer.parseInt(req.getParameter("pid"));
		Product p=new Product();
		p.setId(pid);
		listItemDaoImpl.deleteItem(list, p);
		
		return null;
	}
	

      
}
