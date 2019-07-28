package com.services;

import java.util.ArrayList;

import com.Dao.osmsDao;
import com.Exception.invalidUsernameOrPasswordException;
import com.model.Product;

public class Services {
	
	osmsDao os = new osmsDao();
	
	public boolean getUser(String username,String password) throws invalidUsernameOrPasswordException
	{
		if(username!=null||password!=null)
		{
			return os.getUser(username,password);
		}
		else
		{
			throw new invalidUsernameOrPasswordException();
		}
	}
	public String AddProduct(Product p)

	{
		String s=os.AddProduct(p);
		return s;
	}
	public ArrayList<Product> ProductReport()
	{
		ArrayList<Product> productlist = new ArrayList<>();
		productlist=os.ProductReport();
		return productlist;
	}
	 public String UpdateProduct(String ProductId,double priceperquantity,int quantity,String status)
	 {
	 	
	 String	s;
	 s=os.UpdateProduct(ProductId, priceperquantity, quantity, status);
	 return s; 
	 }
	 public boolean DeleteProduct(String ProductId)
	 {
		 boolean status;
		 status=os.DeleteProduct(ProductId);
		 return status;
	 }
	 public Product getProduct(String Productid)
	 {
		 Product p;
		 p=os.getProduct(Productid);
		 return p;
	 }

}
