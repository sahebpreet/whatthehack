package com.sd.daoimpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sd.dao.ProductSubscriptionDao;
import com.sd.pojo.Product_subscriptions;

public class ProductSubscriptionDaoImpl implements ProductSubscriptionDao{
    DataSource dataSource;
	JdbcTemplate jdbctemplate;
	
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate=new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	public boolean addSubscription(Product_subscriptions prodSub) throws ParseException {
		// TODO Auto-generated method stub
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		c.setTime(sdf.parse(prodSub.getLast_delivery_date()));
		int add = prodSub.getDuration();
		c.add(Calendar.MONTH,add);
		String sdate = sdf.format(c.getTime());
		prodSub.setNext_delivery_date(sdate);
		String sql="insert into product_subscriptions(uid,pid,duration,last_delivery_date,subscription_date,quantity,next_delivery_date) values(?,?,?,?,?,?,?)";
		
		System.out.println("Here2");
		
		System.out.println(" Id : " + prodSub.getId()
				+ "Uid : " + prodSub.getUid() + 
						"Pid : " + prodSub.getPid() + 
						"Dur : " + prodSub.getDuration() + 
						"Last : " + prodSub.getLast_delivery_date() + 
						"Sub_date : " + prodSub.getSubscription_date() + 
						"Quan : " + prodSub.getQuantity() + 
						"Next date : " + prodSub.getNext_delivery_date());
		
		System.out.println("Hey " + sdate);
		jdbctemplate.update(sql,prodSub.getUid(),prodSub.getPid(),prodSub.getDuration(),prodSub.getLast_delivery_date(),prodSub.getSubscription_date(),prodSub.getQuantity(),prodSub.getNext_delivery_date());
		return true;
	}

	public ArrayList<Product_subscriptions> getSubscription(int uid) {
		// TODO Auto-generated method stub
		String sql="select * from Product_subscriptions where uid="+ uid;
		ArrayList<Product_subscriptions> prodList  = (ArrayList<Product_subscriptions>) jdbctemplate.query(sql,
				new BeanPropertyRowMapper<Product_subscriptions>(Product_subscriptions.class));
		return prodList;
	}

	public boolean editSubscription(Product_subscriptions prodSub) {
		// TODO Auto-generated method stub
		int uid=prodSub.getUid();
		int pid=prodSub.getPid();
		//String getProdObject ="select * from product_subscriptions where uid="+uid+" and pid="+pid;
		//Product_subscriptions prodOld = (Product_subscriptions) jdbctemplate.query(getProdObject,new BeanPropertyRowMapper(Product_subscriptions.class));
		String updateProd ="update product_subscriptions duration=" + prodSub.getDuration() + ",last_delivery_date="+ prodSub.getLast_delivery_date() + ",subscription_date=" + prodSub.getSubscription_date() +",quantity=" + prodSub.getQuantity() +",next_delivery_date=" + prodSub.getNext_delivery_date() + "where uid=" + uid + " and pid=" + pid;
		jdbctemplate.update(updateProd);		
		return true;
	}
	
	public Product_subscriptions getSubscirptionProduct(int uid,int pid){
		String sql ="select * from product_subscriptions where uid="+uid+" and pid="+pid;
		ArrayList<Product_subscriptions> prodSub = (ArrayList<Product_subscriptions>) jdbctemplate.query(sql,new BeanPropertyRowMapper<Product_subscriptions>(Product_subscriptions.class));
		return prodSub.get(0);
	}

	public boolean deleteSubscription(int id) {
		// TODO Auto-generated method stub
		String sql="delete from product_subscriptions where id" + id;
		jdbctemplate.update(sql);
		return false;
	}
	
	public void onClickRefill(int uid,int pid) throws ParseException{

		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("UID AND PID"+uid+pid);
		Product_subscriptions prodSub = getSubscirptionProduct(uid, pid);
		Date currentDate = new Date();
		String scurrentDate = sdf.format(currentDate);
		prodSub.setLast_delivery_date(scurrentDate);
		c.setTime(sdf.parse(prodSub.getLast_delivery_date()));
		int add = prodSub.getDuration();
		c.add(Calendar.MONTH,add);
		String sdate = sdf.format(c.getTime());
		prodSub.setNext_delivery_date(sdate);
		String sql="insert into product_subscriptions(uid,pid,duration,last_delivery_date,subscription_date,quantity,next_delivery_date) values(?,?,?,?,?,?,?)";
		
		System.out.println("Here2");
		
		System.out.println(" Id : " + prodSub.getId()
				+ "Uid : " + prodSub.getUid() + 
						"Pid : " + prodSub.getPid() + 
						"Dur : " + prodSub.getDuration() + 
						"Last : " + prodSub.getLast_delivery_date() + 
						"Sub_date : " + prodSub.getSubscription_date() + 
						"Quan : " + prodSub.getQuantity() + 
						"Next date : " + prodSub.getNext_delivery_date());
		
		System.out.println("Hey " + sdate);
		jdbctemplate.update(sql,prodSub.getUid(),prodSub.getPid(),prodSub.getDuration(),prodSub.getLast_delivery_date(),prodSub.getSubscription_date(),prodSub.getQuantity(),prodSub.getNext_delivery_date());
		
	}

}