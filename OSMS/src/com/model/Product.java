package com.model;

public class Product {
	
	
	private String ProductId;
	private String Productname;
	private String Desription;
	private String Category;
	private String Status;
	private double priceperquantity;
	private int totalquantity;

    public String getProductId() {
		return ProductId;
	}


	public void setProductId(String productId) {
		ProductId = productId;
	}


	public String getProductname() {
		return Productname;
	}


	public void setProductname(String productname) {
		Productname = productname;
	}


	public String getDesription() {
		return Desription;
	}


	public void setDesription(String desription) {
		Desription = desription;
	}


	public String getCategory() {
		return Category;
	}


	public void setCategory(String category) {
		Category = category;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	public double getPriceperquantity() {
		return priceperquantity;
	}


	public void setPriceperquantity(double priceperquantity) {
		this.priceperquantity = priceperquantity;
	}


	public int getTotalquantity() {
		return totalquantity;
	}


	public void setTotalquantity(int totalquantity) {
		this.totalquantity = totalquantity;
	}
	}


