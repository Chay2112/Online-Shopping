<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="validation.js"></script>
</head>
<body>
<%@include file="header.html"%>
<div>
<table width = "100%">
<tr>
<td align="center" style = "color:red"><a href = "aboutUs.jsp">AboutUS</td>
<td align="center" style = "color:red">ContactUS</td>
<td class = "column" style = "color:red" align="center">AnyQueries</td>
</tr>
<tr>
<td align = "right" colspan = "4">

welcome 
<%=
	request.getSession().getAttribute("user")
%></tr></table></div>
<div>
<table align="left">
<tr>
<td>&nbsp;</td></tr>
<tr><td>&nbsp;</td><tr>
<tr><td>&nbsp;</td><tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;</td></tr>
<tr>
<td align = "left">
<a href = "addProduct.jsp?">Add Product</a><br>
<a href = "<%=request.getContextPath()%>/Controller?action=productdetails">Product Details</a><br>
<a href = "main.jsp">Home</a>
</td>
</tr>
</table></div>
<div><form name="addform" action = "<%=request.getContextPath() %>/Controller" method = "post" onsubmit="return validateadd()">
<table  align = "center">
<tr><td colspan= "2"><h1>PRODUCT DETAILS</h1>
<tr>

<td>ProductName</td>
<td><input type = "text"  name = "productname" id="name">
</td><td><font color="red" id="name_err"></font></td>
</tr>
<tr>
<td>Description</td>
<td><textArea rows = "5" cols = "20" name="description" id="desc"></textArea>
</td><td width="50%"><font color="red" id="desc_err"></font></td>
</tr>
<tr>

<td>Category</td>
<td><select name = "category" >
<option value = "Kids Apparel" selected>Kids Apparel</option>
<option value = "Mens Apparel">Mens Apparel</option>
<option value = "Womens Apparel">Womens Apparel</option>
<option value = "Home Appliances">Home Appliances</option>
</select>
</td>
</tr>
<tr>
<td>Price/Quantity</td>
<td><input type = "text" name = "price" id="price">
</td><td><font color="red" id="price_err"></font></td>
</tr>
<tr>
<td>Total Quantity</td>
<td><input type = "text" name = "totalquantity" id="qty">
</td><td><font color="red" id="qty_err"></font></td>
</tr>
<tr>
<td>status</td>
<td><input type = "radio" name = "status" value = "open">open
<input type = "radio" name = "status" value = "close">close</td>
<td><font color="red" id="status_err"></font></td>
</tr>
<tr>
<td align = "right">
<input type = "submit" name = "action" value = "ADD">
</td>
<td align = "center">
<input type = "reset" name = "submit" value = "RESET" >
</td></table>
</form></div>

<%@include file="footer.html"%>
</body>
</html>