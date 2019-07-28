package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Product;
import com.services.Services;

/**
 * Servlet implementation class Controller2
 */
@WebServlet("/Controller2")
public class Controller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller2() {
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("productid");
		String action = request.getParameter("action");
		request.setAttribute("user",request.getSession().getAttribute("user"));
		RequestDispatcher rd;
		Services sc= new Services();
		boolean status;
		if(action.equalsIgnoreCase("delete"))
		{
			status=sc.DeleteProduct(id);
			if(!status){
			
				rd=request.getRequestDispatcher("deleteSuccess.jsp");
				rd.forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("update"))
		{
				Product p=sc.getProduct(id);
				request.setAttribute("p", p);
				rd=request.getRequestDispatcher("update.jsp");
				rd.forward(request, response);
	}
}
}
