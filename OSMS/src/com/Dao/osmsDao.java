package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Util.DataBaseUtil;
import com.model.Product;

public class osmsDao {
	
    Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String query,query2;

public ArrayList<Product> ProductReport()
{
	ArrayList<Product> productlist = new ArrayList<>();
	try {
		con = DataBaseUtil.getConnection();
		query = "select* from projectproducttable_1130437 ";
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next())
		{
			Product p = new  Product();
			p.setProductId(rs.getString(1));
			p.setProductname(rs.getString(2));
			p.setDesription(rs.getString(3));
			p.setCategory(rs.getString(4));
			p.setStatus(rs.getString(5));
			p.setPriceperquantity(rs.getDouble(6));
			p.setTotalquantity(rs.getInt(7));
			productlist.add(p);
			
		}
		
	    } 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	finally
	{
		DataBaseUtil.closeConnection(con);
		
		
	}
	return productlist;
}

public String AddProduct(Product p)

{
	PreparedStatement ps1=null;
	String s=null;
	int i=0;
	try {
		con = DataBaseUtil.getConnection();
		
		ps1=con.prepareStatement("select product_seq.nextval from dual" );
		rs=ps1.executeQuery();
		if(rs.next()){
		 s="PROD_"+rs.getString(1);
		 System.out.println(s);
			
		}
		query = "insert into projectproducttable_1130437 values (?,?,?,?,?,?,?)";
		ps = con.prepareStatement(query);
		ps.setString(1, s);
		ps.setString(2, p.getProductname());
		ps.setString(3, p.getDesription());
		ps.setString(4, p.getCategory());
		ps.setString(5,p.getStatus());
		ps.setDouble(6, p.getPriceperquantity());
	    ps.setInt(7, p.getTotalquantity());
	    i= ps.executeUpdate();
	    
	    
	   } 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	finally
	{
		//DataBaseUtil.closeStatement();
		DataBaseUtil.closeConnection(con);
		
	}if(i!=0)
return s;
	else
		return null;
}

	
 public boolean DeleteProduct(String ProductId)
 {
	 boolean status = false;
	 
	 try {
			con = DataBaseUtil.getConnection();
			query = "delete from  projectproducttable_1130437 where productId = ?";
			ps = con.prepareStatement(query);
			ps.setString(1,ProductId);
			status=ps.execute();
	    }
	 
	 catch (SQLException e) 
		{
			e.printStackTrace();
		}
	 finally
		{
			//DataBaseUtil.closeStatement();
			DataBaseUtil.closeConnection(con);
			
		}
		
	return status;	
}

 public String UpdateProduct(String ProductId,double priceperquantity,int quantity,String status)
 {
 	
 String s=null;
 try {
 	con = DataBaseUtil.getConnection();
 	query = "update  projectproducttable_1130437 set priceperquantity= ?, quantity = ? , Status = ? where productId = ?";
 	ps = con.prepareStatement(query);
 	ps.setDouble(1,priceperquantity );
 	ps.setInt(2,quantity);
 	ps.setString(3, status);
 	ps.setString(4,ProductId);
 	if(!ps.execute())
 	 s= ProductId;
 }
 	 catch (SQLException e) 
 		{
 			e.printStackTrace();
 		}
 	 finally
 		{
 			//DataBaseUtil.closeStatement();
 			DataBaseUtil.closeConnection(con);
 			
 		}
 		
 	return s;	
 }
 	
 public Product getProduct(String Productid)
 {
	 con = DataBaseUtil.getConnection();
	 Product p = null;
		query = "select* from projectproducttable_1130437 where productid = ? ";
		try{
		ps = con.prepareStatement(query);
		ps.setString(1,Productid);
		rs = ps.executeQuery();
		if(rs.next())
		{
			p = new  Product();
			p.setProductId(rs.getString(1));
			p.setProductname(rs.getString(2));
			p.setDesription(rs.getString(3));
			p.setCategory(rs.getString(4));
			p.setStatus(rs.getString(5));
			p.setPriceperquantity(rs.getDouble(6));
			p.setTotalquantity(rs.getInt(7));
			
		}}	
		
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	finally
	{
		DataBaseUtil.closeConnection(con);
		
		
	}
	return p;
 }
 
 
 

	
	
	
	public boolean getUser(String username,String password)
	{
		con = DataBaseUtil.getConnection();
		
		boolean status = false;
		
		try {
			ps = con.prepareStatement("select * from userdetails_1130437 where username = ? and password = ?");
			
			ps.setString(1,username);
			
			ps.setString(2,password);
			
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				status = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DataBaseUtil.closeConnection(con);
		}
		return status;
		
	}


}

