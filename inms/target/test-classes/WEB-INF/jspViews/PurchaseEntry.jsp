
<%-- 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String name = (String) session.getAttribute("userName");
	if (name == null) {
		response.sendRedirect("login.html");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.error {
	color: red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase Entry</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript"
	src="../../resources/js/datetimepicker.js"></script>
<script type="text/javascript"
	src="C:\\DivyaA\\inms\\src\\main\\webapp\\resources\\js\\datetimepicker.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : 'dd-mm-yy'
		});
	});
</script>
<script>
	$(function() {
		$("#datepicker1").NewCssCal();
	});

	function myFunction() {
		var x = document.getElementById("mySelect").value;
		document.getElementById("demo").innerHTML = "You selected: " + x;
	}
</script>
</head>
<body>

	<%@ include file="header.jsp"%>

	Hi, ${userName}

	<script type="text/javascript">
		function getUnitAndTypeList() {
			document.forms["form1"].action = "fetchMaterialTypesAndMaterialUnitsList.html";
			document.forms["form1"].method = "post";
			document.forms["form1"].submit();
		}
	</script>

	<h3 style="text-align: center">Material Purchase Entry</h3>
	<form:form name="form1" method="post" action="addPurchaseEntry.html"
		modelAttribute="purchaseBean">

		<table>

			<tr>
				<td>Vendor Name:</td>
				<td><form:select path="vendorName" id="mySelect"
						onchange="myFunction">
						<form:option label="---select---" value=" "></form:option>
						<form:options items="${vendorList}" itemValue="vendorName"
							itemLabel="vendorName" />
					</form:select>
					<form:errors cssClass="error" path="vendorName"></form:errors></td>

				<td></td>
			</tr>

			<p id="demo"></p>
			<tr>
				<td>Material Category:</td>
				<td><form:select path="materialCategoryId"
						onchange="getUnitAndTypeList()">
						<form:option label="---select---" value=""></form:option>
						<form:options items="${materialCategoryList}"
							itemValue="categoryId" itemLabel="categoryName" />
					</form:select></td>

				<td><form:errors cssClass="error" path="materialCategoryId"></form:errors>
				</td>

			</tr>


			<tr>
				<td>Material Type:</td>
				<td><form:select path="materialTypeId">
						<form:option label="---select---" value=""></form:option>
						<form:options items="${mTypeList}" itemValue="typeId"
							itemLabel="typeName" />
					</form:select></td>

				<td><form:errors cssClass="error" path="materialTypeId"></form:errors>
				</td>
			</tr>


			<tr>
				<td>Unit:</td>
				<td><form:select path="unitId">
						<form:option label="---select---" value=""></form:option>
						<form:options items="${uNameList}" itemValue="unitId"
							itemLabel="unitName" />
					</form:select></td>

				<td><form:errors cssClass="error" path="unitId"></form:errors>
				</td>

			</tr>

			<tr>
				<td>Brand Name:</td>
				<td><form:input path="brandName" /></td>

				<td><form:errors cssClass="error" path="brandName"></form:errors>
				</td>

			</tr>


			<tr>
				<td>Quantity:</td>
				<td><form:input path="quantity" /></td>


				<td><form:errors cssClass="error" path="quantity"></form:errors>
				</td>

			</tr>

			<tr>
				<td>Purchase Amount:</td>
				<td><form:input path="purchaseAmount" /></td>

				<td><form:errors cssClass="error" path="purchaseAmount"></form:errors>
				</td>

			</tr>

			<tr>
				<td>Purchase Date:</td>
				<td><form:input path="purchaseDate" id="datepicker"
						placeholder="dd-MMM-yyyy" /> <!-- <img alt="" src="../../resources/js/images2/cal.gif">-->
				</td>

				<td><form:errors cssClass="error" path="purchaseDate"></form:errors>
				</td>

			</tr>

			<!-- 
		
		<div class="search">
  			<span <i class="fa fa-search"></span>
  			<input placeholder="searcsdh">
		</div>
		
		-->

		</table>
		<input type="submit" value="Add Purchase Entry">
	</form:form>
	<br />


	<c:if test="${id!=null}">
		<p style="color: red;">Purchase Entry Added with purchase id as</p>${id}
		</c:if>

	${notAdded}



	<%@ include file="footer.jsp"%>



</body>
</html>

 --%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"/>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/datetimepicker.js"></script>
	
<title>Material Purchase Entry</title>
<script type="text/javascript">
/* function quantityValidate(){
	var qty=document.getElementById("quantity").value;
	if(isNaN(qty)){
		alert("Please enter only numbers for Quantity.");
		return;
	}
}
function purchaseAmountValidate(){
	
	var qty=document.getElementById("purchaseAmount").value;
	 var regex = /^\d+(?:\.\d{1,2})?$/;
	 if (!regex.test(qty)) {
		 alert('Please enter only numbers with two decimal places for Purchase Amount.');
			return;
    } 	
} */
function getUnitAndTypeList(id){    
	document.forms["form1"].action="fetchMaterialTypesAndMaterialUnitsList.html";
    document.forms["form1"].method="post";
	document.forms["form1"].submit();
}
function addPurchaseEntry() {
	
/* var qty=document.getElementById("quantity").value;
if(! (qty===undefined) && (qty != "")){
	if(isNaN(qty)){
		alert("Please enter only numbers for Quantity.");
		return;
	}
}	
	var amt=document.getElementById("purchaseAmount").value;
	 var regex = /^\d+(?:\.\d{1,2})?$/;
	 if(! (amt===undefined) && (amt != "")){
	 if (!regex.test(amt)) {
		 alert('Please enter only numbers with two decimal places for Purchase Amount.');
			return;
   		} 	
	 } */
	var e = document.getElementById("category");
	var categoryName = e.options[e.selectedIndex].text;	
	document.getElementById("mcName").value= categoryName;
	
	var e1 = document.getElementById("type");
	var materialTypeName = e1.options[e1.selectedIndex].text;	
	document.getElementById("typeName").value= materialTypeName;
	
	var e2 = document.getElementById("unit");
	var unitName = e2.options[e2.selectedIndex].text;	
	document.getElementById("unitName").value= unitName;
	
	document.forms["form2"].action="addPurchaseEntry.html";
	document.forms["form1"].method="post";
	document.forms["form1"].submit();
	document.forms["form2"].method="post";
	document.forms["form2"].submit();
}
function displayPageElements(){
	if(document.getElementById("category").value == ""){
		
	document.getElementById("belowTables").style.display = "none";
	}else{
		
		document.getElementById("belowTables").style.display = "block";
	}
}
</script>
</head>
<body onload="displayPageElements();" >
<div class="container">
<jsp:include page="include.jsp" />
<br/>
Hi, ${userName}
<h2 align="center">Material Purchase Entry</h2>

<f:form name="form1" action="addPurchaseEntry.html" modelAttribute="purchaseBean" method="POST"> 
<table class="bodycontainer" >
	<tr>
		<td><label>Vendor Name:</label></td>
		<td><f:select path="vendorName" id="vendorName">
		<f:option label="--Select--" value="" />
			<f:options items="${vendorList}"  itemValue="vendorName" itemLabel="vendorName"/>
		</f:select>
		<font color="red"><f:errors
								path="vendorName" style="font-family:sans serif;"/></font></td>
	</tr>

	<tr>
		<td><label>Material Category:</label></td>
		<td><f:select path="materialCategoryId" id="category" 
		onchange="getUnitAndTypeList(category.value)">
		<f:option label="--Select--" value=""/>
			<f:options items="${materialCategoryList}" itemValue="categoryId" itemLabel="categoryName"/>
		</f:select>
		<font color="red"><f:errors
								path="materialCategoryId" style="font-family:sans serif;" /></font></td>
	</tr>
	
	</table>
	</f:form>
	
	<f:form name="form2" modelAttribute="purchaseBean" action="addPurchaseEntry.html" method="POST">
	<table class="bodycontainer" id="belowTables">
	<tr>
		<td><label>Material Type</label></td>
		<td><f:select path="materialTypeId" id="type">
		<f:option label="--Select--" value=""/>
			<f:options items="${mTypeList}" itemValue="typeId" itemLabel="typeName"/>
		</f:select>
		<font color="red"><f:errors
								path="materialTypeId" style="font-family:sans serif;" /></font></td>		
	</tr>
	<tr>
		<td><label>Unit</label></td>
		<td><f:select path="unitId" id="unit">
		<f:option label="--Select--" value=""/>
			<f:options items="${uNameList}" itemValue="unitId" itemLabel="unitName"/>
		</f:select>
		<font color="red"><f:errors
								path="unitId" style="font-family:sans serif;" /></font></td>
	</tr>
	<tr>
<%-- 	<f:hidden path="materialCategoryName" id="mcName"/>
	<f:hidden path="materialTypeName" id="typeName"/>
	<f:hidden path="materialUnitName" id="unitName"/> --%>
		<td><label>Brand name</label></td>
		<td><f:input path="brandName"/>
		<font color="red"><f:errors
								path="brandName" style="font-family:sans serif;" /></font></td>
	</tr>
	<tr>
		<td><label>Quantity</label></td>
		<td><f:input path="quantity" />
		<font color="red"><f:errors
								path="quantity" style="font-family:sans serif;" /></font></td>
	</tr>
	<tr>
		<td><label>Purchase Amount (&#8377;)</label></td>
		<td><f:input path="purchaseAmount" />
		<font color="red"><f:errors
								path="purchaseAmount" style="font-family:sans serif;" /></font></td>
	</tr>
	<tr>
		<td><label>Purchase Date</label></td>
		<td><f:input path="purchaseDate" id="purchaseDate"  readonly="true" onclick="javascript:NewCssCal('purchaseDate')"/>
		<!-- <img src="cal.gif" onclick="javascript:NewCssCal('purchaseDate')" style="cursor:pointer"/> -->
		<font color="red"><f:errors
								path="purchaseDate" style="font-family:sans serif;" /></font></td>		
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="Submit"/></td>
    </tr>	
    <tr>
    <td>${message}</td>
    </tr>
</table>
</f:form>
</div>
<div class="terms2">
  <p align="center" style="font-family: calibri;color: #6666CC;">Copyright © 2018 Accenture All Rights Reserved.</p>
</div>
</body>
</html>
