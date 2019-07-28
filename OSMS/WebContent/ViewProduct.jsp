<%@page import="java.util.ArrayList"%>

<%@page import="com.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@include file="header.html"%>
	<div>
		<table width="100%">
			<tr>
		<td align="center" style = "color:red"><a href = "aboutUs.jsp">AboutUS</td>
<td align="center" style = "color:red">ContactUS</td>
				<td class="column" style="color: red" align="center">AnyQueries</td>
			</tr>
			<tr>
				<td align="right" colspan="4">welcome <%=
						request.getSession().getAttribute("user")
%>
			</tr>
		</table>
	</div>
	<div>
		<table align="left">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			<tr>
			<tr>
				<td>&nbsp;</td>
			<tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td align="left"><a
					href="<%=request.getContextPath()%>/addProduct.jsp">Add Product</a><br>
					<br> <a href="<%=request.getContextPath()%>/main.jsp">Home</a>
				</td>
			</tr>
		</table>
	</div>
	
	<%
		 
		ArrayList<Product> plist=(ArrayList<Product>)request.getAttribute("plist");
		
	%>
	<div style="padding-top:5%">
		<table border="1" style="border-color: olive;" cellspacing="0" cellpadding="0" align="center" >
			<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Description</th>
			<th>Category</th>
			<th>Price per Product</th>
			<th>Total Quantity</th>
			<th>Status</th>
			</tr>
			<% 
				for(Product p:plist){
					
			%>
			<tr>
			<td><%=p.getProductId() %></td>
			<td><%=p.getProductname() %></td>
			<td><%=p.getDesription() %></td>
			<td><%=p.getCategory() %></td>
			<td><%=p.getPriceperquantity() %></td>
			<td><%=p.getTotalquantity()%></td>
			<td><%=p.getStatus() %></td>
			<%if(p.getStatus().equalsIgnoreCase("close")){%>
			<td><a href="<%=request.getContextPath() %>/Controller2?productid=<%=p.getProductId()%>&action=delete">Delete</a>
			<%}else {%>
			<td><a href="<%=request.getContextPath() %>/Controller2?productid=<%=p.getProductId()%>&action=update">Update</a>
			<%} %>
			</tr>
			<%}%>
			
		</table>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<div>
	</div>
</body>
</html>