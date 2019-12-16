<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"/>
<title>Welcome</title>
</head>
<body>

  <%
  	String name=(String)session.getAttribute("userName");
  	if(name==null)
  	{
  		response.sendRedirect("login.html");
  	}
  %>

<%@ include file="include.jsp" %> 
<br/>
Welcome ${userName}

<p>
ABC, a company needs an application to manage their inventory details. This application focuses on purchasing various materials needed from vendors and maintains their payment due history as they may pay the total amount of the materials purchased as partial. 

This application helps to generate reports on:
<ul>
<li>Showing relevant details on date wise materials purchased for all vendors.</li>
<li>Showing relevant details of the materials purchased based on the selected vendor, additionally the user may filter the report by specifying From and To dates.</li>
<li>Showing relevant details of the payment history of a particular vendor between From and To Dates on the basis of :</li>
balance pending, fully paid or overpaid status on the materials purchased,Specific purchase id
</ul>
</p>
<hr/>
<br/>

<%@ include file="footer.jsp" %>

</body>
</html>