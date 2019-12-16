<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
	   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%
  	String name=(String)session.getAttribute("userName");
  	if(name==null)
  	{
  		response.sendRedirect("login.html");
  	}
  %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor- Purchased Item Report</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/datetimepicker.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"/>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/datetimepicker.js"></script>

</head>
<body>

	
	<%@ include file="include.jsp" %>
	
	<br/>
	Hi, ${userName}

	<h2 style="text-align:center">Vendor- Purchased Item Report</h2>
	<center>
			<form:form method="post" action="loadVendorWiseReport.html" modelAttribute="vendorPurchaseReportBean">
			<table>
			<tr>	
			
<%-- 			<td>
				<form:select path="vendorName">
					<form:options items="${vendorList}" itemValue="vendorName" itemLabel="vendorName"/>
				</form:select>
			</td> --%>	
		<td>
		<form:select path="vendorName" id="vendorName">
		<form:option label="--Select--" value="" />
			<form:options items="${vendorList}"  itemValue="vendorName" itemLabel="vendorName"/>
		</form:select>
		<font color="red"><form:errors
								path="vendorName" style="font-family:sans serif;"/></font></td>	
		
		
			
			
			<td>From Date: </td>
			<td>
			<form:input path="fromDate" id="fromDate" placeholder="dd-MM-yyyy" onclick="javascript:NewCssCal('fromDate')"/>	
			<!-- <img alt="" src="../../resources/js/images2/cal.gif">-->
			</td>
			
			<td>
				<form:errors cssClass="error" path="fromDate"></form:errors>
			</td>
		
		
			<td>To Date: </td>
			<td>
			<%-- <form:input path="toDate" id="datepicker" placeholder="dd-MM-yyyy" onclick="javascript:NewCssCal('purchaseDate')"/>	 --%>
			<td><form:input path="toDate" id="toDate" placeholder="dd-MM-yyyy" onclick="javascript:NewCssCal('toDate')"/>
			<!-- <img alt="" src="../../resources/js/images2/cal.gif">-->
			</td>
			
			<td>
				<form:errors cssClass="error" path="toDate"></form:errors>
			</td>
		</tr>
		</table>
		<br/>
		<input type="submit" value="Search">
		
		 </form:form>	
		</center>
		<br/>
		<c:if test="${vendorPurchaseReportBeans.size()>0}">
		<center>
		 <table border="1">
		 <tr>
			<th>Material Category</th>
			<th>Material Type</th>
			<th>Brand</th>
			<th>Quantity</th>
			<th>Unit</th>
			<th>Price</th>
			<th>Vendor</th>
			<th>PurchaseDate</th>
		</tr>
		 
		<c:forEach items="${vendorPurchaseReportBeans}" var="pbeans">
		<tr>
		<td>${pbeans.getMaterialCategoryName()}</td>
		<td>${pbeans.getMaterialTypeName()}</td>
		<td>${pbeans.getBrandName()}</td>
		<td>${pbeans.getQuantity()}</td>
		<td>${pbeans.getUnitName()}</td>
		<td>${pbeans.getPurchaseAmount()}</td>
		<td>${pbeans.getVendorName()}</td>
		<td>${pbeans.getPurchaseDate()}</td>	
		</tr>
		</c:forEach>
		</table>
		</center>
		<br/>	 
		</c:if>
		<c:if test="${vendorPurchaseReportBeans.size()==0}">
		<center>No results found for the selected values</center>
		<br/>
		</c:if>
		
		
		<%-- <c:if test="${nullDetails==true}">
		<p style="color:red;">No Purchase records found matching with given Vendor name </p>
		</c:if> --%>
		
		<%@ include file="footer.jsp" %>
		
		
	

</body>
</html>