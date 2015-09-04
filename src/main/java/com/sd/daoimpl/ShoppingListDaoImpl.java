package com.sd.daoimpl;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sd.dao.ShoppingListDao;
import com.sd.pojo.Shoppinglist;

public class ShoppingListDaoImpl implements ShoppingListDao{

	JdbcTemplate jdbcTemplate;
	DataSource dataSource;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}

	public int addList(Shoppinglist list) {
		String query ="insert into shoppinglist(name,createddate,uid) values(?,?,?)";
		int b=jdbcTemplate.update(query,new Object[]{
			list.getName(),
			list.getCreateddate(),
			list.getUid()
		});
		return b;
	}

	public ArrayList<Shoppinglist> getLists() {
		String query="select * from shoppinglist";
		ArrayList<Shoppinglist> sl=(ArrayList<Shoppinglist>) jdbcTemplate.query(query, new BeanPropertyRowMapper<Shoppinglist>(Shoppinglist.class));
		return sl;
	}

	public Shoppinglist getList(int id) {
		
		String query="Select * from shoppinglist where id="+id;
		Shoppinglist sl=(Shoppinglist) jdbcTemplate.query(query, new BeanPropertyRowMapper<Shoppinglist>(Shoppinglist.class));
		return sl;
	}

	public int deleteList(int id) {
		
		String query="delete from shoppinglist where id="+id;  
	    return jdbcTemplate.update(query);  
	}
}
