package com.sd.controller;


import java.text.ParseException;import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sd.dao.ProductSubscriptionDao;
import com.sd.daoimpl.ProductSubscriptionDaoImpl;
import com.sd.pojo.Product_subscriptions;


@Controller
public class ProductSubscriptionController {
   
	ProductSubscriptionDao productionSubscriptionImpl;
   
    public ProductSubscriptionController() {
        System.out.println("In controller");
        ApplicationContext d = new ClassPathXmlApplicationContext("Spring-module.xml");
        productionSubscriptionImpl =(ProductSubscriptionDao) d.getBean("productionSubscriptionImpl");
    }
      
	@RequestMapping(value = "/suscribe", method = RequestMethod.GET)
	public ModelAndView addSubscription(HttpServletRequest request,
			HttpServletResponse response,ModelMap map) throws Exception {
		Product_subscriptions subscription = new Product_subscriptions();
		subscription.setDuration(Integer.parseInt(request.getParameter("duration")));
		subscription.setLast_delivery_date(request.getParameter("date"));
		subscription.setPid(Integer.parseInt(request.getParameter("pid")));
		subscription.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		subscription.setSubscription_date(new Date().toString());
		subscription.setUid(Integer.parseInt(request.getParameter("uid")));
		
		productionSubscriptionImpl.addSubscription(subscription);
		ModelAndView mv= new ModelAndView();
		mv.setViewName("subscribe");
		return mv;
	}
	
	
	
	@RequestMapping(value = "/getSubscriptions", method = RequestMethod.GET)
	public ModelAndView getSubscriptions(HttpServletRequest request,
			HttpServletResponse response,ModelMap map) throws Exception {
		
		int uid=Integer.parseInt(request.getParameter("uid"));
		ArrayList<Product_subscriptions> subscriptions = productionSubscriptionImpl.getSubscription(uid);
		ModelAndView mv= new ModelAndView();
		mv.addObject(subscriptions);
		mv.setViewName("subscribe");
		return mv;
	}
	
	@RequestMapping("/editSubscription")
	public ModelAndView editSubscription(HttpServletRequest request,
			HttpServletResponse response,ModelMap map) {
		ModelAndView mv=new ModelAndView();
		
		Product_subscriptions subscription = new Product_subscriptions();
		subscription.setDuration(Integer.parseInt(request.getParameter("duration")));
		subscription.setLast_delivery_date(request.getParameter("date"));
		subscription.setPid(Integer.parseInt(request.getParameter("pid")));
		subscription.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		subscription.setSubscription_date(new Date().toString());
		subscription.setUid(Integer.parseInt(request.getParameter("uid")));
		
		productionSubscriptionImpl.editSubscription(subscription);
		
		mv.setViewName("editSubscription");
		return mv;
	}
	
	
	@RequestMapping("/deleteSubscription")
	public ModelAndView deleteSubscription(HttpServletRequest request,
			HttpServletResponse response,ModelMap map) {
		ModelAndView mv=new ModelAndView();
		int id=Integer.parseInt(request.getParameter("id"));
		productionSubscriptionImpl.deleteSubscription(id);
		mv.setViewName("deleteSubscription");
		return mv;
	}
	
	
	@RequestMapping("/instantRefill")
	public ModelAndView onRefill(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws ParseException{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("payments");
		HttpSession session = request.getSession(false);
		int uid = (Integer) session.getAttribute("uid");
		int pid = (Integer) session.getAttribute("pid");
		
		ApplicationContext d = new ClassPathXmlApplicationContext("Spring-module.xml");
		ProductSubscriptionDaoImpl productionSubscriptionImpl;
		productionSubscriptionImpl =(ProductSubscriptionDaoImpl) d.getBean("productionSubscriptionImpl");
		productionSubscriptionImpl.onClickRefill(uid, pid);
		return mv;
	}
	
	
    
    
}
