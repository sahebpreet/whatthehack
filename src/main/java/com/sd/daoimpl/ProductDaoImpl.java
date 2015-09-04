package com.sd.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sd.pojo.Product;

public class ProductDaoImpl {
	
	
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



	public Product getProduct(int id) {

		String sql = "select * from Product where id = ?";
		Product product = (Product) jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Product>(Product.class));

		return product;
	}

	public boolean insertProduct(Product product) {
		String sql = "insert into Product(name,cost) values(?,?)";
		jdbcTemplate.update(sql, product.getName(), product.getCost());
		System.out.println("Record Added Successfully");
		return true;
	}

}
