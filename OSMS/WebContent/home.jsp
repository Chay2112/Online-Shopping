<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>osmsLogin</title>
<%@include file="header.html"%>
<script type="text/javascript" src="validation.js"></script>
</head>

<body>
<div style="background-color:skyblue ">
<br><br><br><br>

<form action = "Controller" method = "post" onsubmit="return login()">
<center><table cellpadding="25%">

<tr>
<td>Username:</td>
<td><input type = "text" name = "username" id="id" maxlength="30"/></td><td><font color="red" id="id_err"></font></td>
</tr>
<tr>
<td >Password:</td>
<td><input type = "password" name = "password" id="name" maxlength="50"/></td><td><font color="red" id="name_err"></font></td>
</tr>
<tr>
<td colspan = "2" align = "center" ><input type = "submit" name="action" value = "Login"></td>
</tr>

</table>
</center>
</form>
<%
	if(request.getAttribute("ErrorMessage")!=null)
	{
%>
<p align="center" style="color: red"><%= request.getAttribute("ErrorMessage")%></p>
<% 	
}
%>
<br><br><br><br></div>
<%@include file = "footer.html"%>
</body>
</html>