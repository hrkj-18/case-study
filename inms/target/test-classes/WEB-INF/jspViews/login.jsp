<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
  
  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${contextRoot}/resources/css/style.css"
	rel="stylesheet" />


<style type="text/css">
.error
{
	color:red;
}

</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<center>
	<h2>Inventory Management System</h2>
	<hr/>
	<h3>Login</h3>
	<hr/>
	
	<form:form action="validatelogin.html" method="post" modelAttribute="loginBean">	
	<table>
	<tr>
		<td>User Name: </td>
		<td><form:input path="username" /></td>
		<td><form:errors path="username"  cssClass="error"></form:errors> </td>
	</tr>
	<tr>
		<td>Password: </td>
		<td><form:password path="password"/></td>
		<td>
			<form:errors path="password" cssClass="error"></form:errors>
		</td>
	</tr>
	</table><br><br>
	<input type="submit" value="Login">
	</form:form>	

	<br/>
	
	<c:if test="${falseDetails==true}">
		<p style="color:red;">"Either UserName or Password is incorrect.Please enter credentials again."</p>
	</c:if>
</center>
</body>
</html>