package com.boot.sql.springsqlexample.contoller;

import com.boot.sql.springsqlexample.dao.ProductDao;
import com.boot.sql.springsqlexample.model.Product;
import com.boot.sql.springsqlexample.model.ProductResponse;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "product")
@Data
@Slf4j
@Logger
public class ProductController {

	@Autowired
	ProductDao productDao;

	@PostMapping(value = "save")
	public ProductResponse saveProduct(@RequestBody Product product) {
		ProductResponse response = new ProductResponse();
		response.setResponse(productDao.saveProduct(product));
		return response;

	}
	@GetMapping(value="products")
	public List<Product> getProducts(){
		log.warn("get products");
		return productDao.getProducts();

	}

}
