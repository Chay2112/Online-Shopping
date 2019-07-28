package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Exception.invalidUsernameOrPasswordException;
import com.model.Product;
import com.services.Services;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void service(HttpServletRequest request,HttpServletResponse response)
    {
    	try {
			doPost(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		System.out.println(action);
		Services sc = new Services();
		RequestDispatcher rd;
		if(action.equalsIgnoreCase("Login")){
			String username=request.getParameter("username");
			request.getSession().setAttribute("user",username);
			String password=request.getParameter("password");
			try {
				boolean status=sc.getUser(username, password);
				if(!status){
				request.setAttribute("ErrorMessage","User does not exist");
				rd=request.getRequestDispatcher("home.jsp");
				rd.include(request, response);
				}
				else{
					request.setAttribute("user",username);
					rd=request.getRequestDispatcher("main.jsp");
					rd.forward(request, response);
				}
			} catch (invalidUsernameOrPasswordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(action.equalsIgnoreCase("add"))
		{
			String name=request.getParameter("productname");
			String description=request.getParameter("description");
			String category=request.getParameter("category");
			double price=Double.parseDouble(request.getParameter("price"));
			int quantity=Integer.parseInt(request.getParameter("totalquantity"));
			String status=request.getParameter("status");
			Product p= new Product();
			p.setProductname(name);
			p.setCategory(category);
			p.setDesription(description);
			p.setPriceperquantity(price);
			p.setTotalquantity(quantity);
			p.setStatus(status);
			String s=sc.AddProduct(p);
			if(s!=null){
			request.setAttribute("id",s);
			
			rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
			}else{
				rd=request.getRequestDispatcher("failed.jsp");
				PrintWriter out=response.getWriter();
				out.println("<font color=red>Failed</font>");
				rd.forward(request, response);
				
			}
			
		}
		else if(action.equalsIgnoreCase("productdetails"))
		{
			ArrayList<Product> plist= new ArrayList<Product>();
			plist=sc.ProductReport();
			request.setAttribute("plist", plist);
			rd=request.getRequestDispatcher("ViewProduct.jsp");
			rd.forward(request, response);
			
		}
		else if(action.equalsIgnoreCase("delete"))
		{
			String id = request.getParameter("productid");
			sc.DeleteProduct(id);
			
		}
		else if(action.equalsIgnoreCase("update"))
		{
			String id=request.getParameter("productid");
			double price=Double.parseDouble(request.getParameter("price"));
			int quantity=Integer.parseInt(request.getParameter("totalquantity"));
			String status=request.getParameter("status");
			String productId=sc.UpdateProduct(id,price,quantity,status);
			request.setAttribute("prodid", productId);
			rd=request.getRequestDispatcher("updatesuccess.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

}
