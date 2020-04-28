package com.boot.sql.springsqlexample.model;

public class Product {

	  private String pname;
	  private String quantity;
	  private String price;
	  private String date_;
	  
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getDate_() {
		return date_;
	}
	public void setDate_(String date_) {
		this.date_ = date_;
	}
	@Override
	public String toString() {
		return "Product [pname=" + pname + ", quantity=" + quantity + ", price=" + price + ", date_=" + date_ + "]";
	}
	  
}
