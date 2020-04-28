package com.boot.sql.springsqlexample.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.boot.sql.springsqlexample.exception.CustomerNotFoundException;
import com.boot.sql.springsqlexample.model.User;

@Repository
public class UserDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	public User validateUser(User user) {
		String userName = user.getUsername();
		String validateUser = "SELECT * FROM USER WHERE USERNAME=?";
		try {
			return (User) jdbcTemplate.queryForObject(validateUser, new Object[] {userName},new BeanPropertyRowMapper(User.class));

		}catch(CustomerNotFoundException ces) {
			throw new CustomerNotFoundException("No CusotmerFound With " + user.getUsername()+"user name");
		}catch(EmptyResultDataAccessException ee){
			throw new CustomerNotFoundException("No CusotmerFound With Empty result size " + user.getEmail()+"email");
		}

	}
	public String registerUser(User user) {
		String registerUser = "insert into user(firstname,lastname,username,password,phone,email,gender,id) values(?,?,?,?,?,?,?,?)";
		Object obj[]= new Object[] {user.getFirstname(), user.getLastname(),user.getUsername(), user.getPassword(),user.getPhone(),user.getEmail(), user.getGender(),user.getId()};
		int argTypes[] = new int[] {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR, Types.VARCHAR,Types.VARCHAR};
		int inserted = jdbcTemplate.update(registerUser,obj,argTypes);
		System.out.println("inserted***************" + inserted);
		return inserted > 0 ? "Value inseterd": "Error";

	}


	public String editUser(User user, String email) {
		int updated = jdbcTemplate.update("UPDATE user SET firstname = ? , lastname = ? , phone = ?, username = ? WHERE email = ? ",
				user.getFirstname(), user.getLastname(),  user.getPhone(), user.getUsername(), email);
		return updated > 0 ? "Value updated": "Error";
	}
	public List<User> findAll() {
		String sql = "Select * from user";
		List<User> users = jdbcTemplate.query(
				sql,
				new BeanPropertyRowMapper(User.class));

		return users;
	}
	
	public String delete(String userName) {
		
		String sql = "Delete from user where username=?";
		Object args[] = new Object[] {userName};
		int argTypes[] = new int[] {Types.VARCHAR};
		
		int deleted = jdbcTemplate.update(sql, args, argTypes);
		return deleted > 0 ? "Deleted":"Error";
	}
}
