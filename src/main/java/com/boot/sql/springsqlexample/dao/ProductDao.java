package com.boot.sql.springsqlexample.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.boot.sql.springsqlexample.model.Product;

@Repository
public class ProductDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public String saveProduct(Product product) {
		Object args[] = new Object[] { product.getPname(), product.getQuantity(), product.getPrice(), product.getDate_()};
		int argTypes[] = new int[] { Types.VARCHAR,Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
		String sql = "insert into product(pname,quantity,price,date_)values(?,?,?,?)";
		return jdbcTemplate.update(sql,args,argTypes)>0?"inserted":"Errror";
	}
	
	public List<Product> getProducts(){
		String sql = "Select * from product";
		//return jdbcTemplate.queryForList("Select * from product", Product.class);
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Product.class));
	}
}
