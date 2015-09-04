package com.sd.daoimpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sd.dao.UserDao;
import com.sd.pojo.User;

public class UserDaoImpl implements UserDao {
	
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




	public User getUser(int id) {
		String sql="select * from where id="+id;
		User user = (User) jdbcTemplate.query(sql,new BeanPropertyRowMapper(User.class));
		return user;
	}

	public boolean insertUser(User user) {
		String sql="insert into user(name,gender,date_of_birth,address) value(?,?,?,?)";
		jdbcTemplate.update(sql,user.getName(),user.getGender(),user.getDate_of_birth(),user.getAddress());
		return true;
	}
	
	
	
}