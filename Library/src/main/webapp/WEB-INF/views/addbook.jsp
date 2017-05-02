<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Add Book Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Book
</h1>

<c:url var="addAction" value="/addbook/add" ></c:url>

<form:form action="${addAction}" commandName="book">
<table>
	<c:if test="${!empty book.bookName}">
	<tr>
		<td>
			<form:label path="bookId">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="bookId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="bookId" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="bookName">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="bookName" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="bookAuthor">
				<spring:message text="Author"/>
			</form:label>
		</td>
		<td>
			<form:input path="bookAuthor" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="bookGenre">
				<spring:message text="Genre"/>
			</form:label>
		</td>
		<td>
			<form:input path="bookGenre" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="bookISBN">
				<spring:message text="ISBN"/>
			</form:label>
		</td>
		<td>
			<form:input path="bookISBN" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
				<input type="submit"
					value="<spring:message text="Add Book"/>" />
		</td>
	</tr>
</table>	
</form:form>
