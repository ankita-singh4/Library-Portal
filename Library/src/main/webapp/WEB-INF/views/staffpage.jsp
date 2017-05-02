<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Staff Dashboard</title>
</head>
<body>

<h2>Hello!</h2>

<table>
	<tr>
		<td><a href="addbook">ADD BOOK</a></td>
	</tr>
	
	
	<tr>
		<td><a href="removebook">REMOVE BOOK</a></td>
	</tr>
	
	<tr>
		<td><a href="updatebook">UPDATE BOOK</a></td>
	</tr>
	
	<tr>
		<td><a href="addCustomer">ADD CUSTOMER ACCOUNT</a></td>
	</tr>
	
</table>

<c:url var="addAction" value="/questions" ></c:url>

<form:form action="${addAction}" commandName="question">
<table>
	<tr>
		<td colspan="2">
				<input type="submit"
					value="<spring:message text="User Questions"/>" />
		</td>
	</tr>
</table>
</form:form>

</body>
</html>