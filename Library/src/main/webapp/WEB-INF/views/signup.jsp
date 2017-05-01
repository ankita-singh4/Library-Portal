<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Signup Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Hello! Signup by providing following details. 
</h1>

<c:url var="addAction" value="/signup/add" ></c:url>

<form:form action="${addAction}" commandName="user">
<table>
	<c:if test="${!empty user.userName}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="profile.firstName">
				<spring:message text="First Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="profile.firstName" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="profile.lastName">
				<spring:message text="last Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="profile.lastName" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="profile.address">
				<spring:message text="Address"/>
			</form:label>
		</td>
		<td>
			<form:input path="profile.address" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="profile.dateOfBirth">
				<spring:message text="Date of Birth"/>
			</form:label>
		</td>
		<td>
			<form:input path="profile.dateOfBirth" />
		</td>
	</tr>
	<tr>
		<tr>
		<td>
			<form:label path="profile.phoneNumber">
				<spring:message text="Phone Number"/>
			</form:label>
		</td>
		<td>
			<form:input path="profile.phoneNumber" />
		</td>
	</tr>
	
		<tr>
		<td>
			<form:label path="profile.emailId">
				<spring:message text="Email ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="profile.emailId" />
		</td>
	</tr>
		<tr>
		<td>
			<form:label path="userName">
				<spring:message text="User Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="userName" />
		</td>
	</tr>
		<tr>
		<td>
			<form:label path="userPassword">
				<spring:message text="Password"/>
			</form:label>
		</td>
		<td>
			<form:input path="userPassword" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="userType">
				<spring:message text="User Type"/>
			</form:label>
		</td>
		<td>
			<form:input path="userType" />
		</td>
	</tr>
	<tr>
	<tr>
	<tr>
	<tr>
		<td colspan="2">
			<c:if test="${empty user.userName}">
				<input type="submit"
					value="<spring:message text="Sign Up!"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
