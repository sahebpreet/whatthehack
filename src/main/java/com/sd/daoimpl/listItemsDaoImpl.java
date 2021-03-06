package com.sd.daoimpl;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sd.dao.listItemsDao;
import com.sd.pojo.Product;
import com.sd.pojo.Shoppinglist;

public class listItemsDaoImpl  implements listItemsDao {

	
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



	public List<Product> getListItems(Shoppinglist list) {
		String query = "select * from product join listitems on product.id=listitems.pid where list_id=?";
		List<Product> products=jdbcTemplate.query(query, new Object[] {list.getId()}, new BeanPropertyRowMapper<Product>(Product.class));
		return products;
	}

	public void addItem(Shoppinglist list, Product product) {
		String query="insert into listitems(list_id,pid) values(?,?)";
		jdbcTemplate.update(query, list.getId(), product.getId());
	
	}

	public void deleteItem(Shoppinglist list, Product product) {
		String query="delete from listitems where list_id=? and pid=?";
		jdbcTemplate.update(query, list.getId(), product.getId());
	
	}

	
}
	