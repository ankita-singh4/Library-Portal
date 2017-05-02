<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Library</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h2>
	Welcome, ${user.userName}.
</h2>

<c:url var="addAction" value="/book/search" ></c:url>

<form:form action="${addAction}" commandName="book">
<table>
	<tr>
		<td colspan="2">
				<input type="submit"
					value="<spring:message text="Search"/>" />
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Books List</h3>
<c:if test="${!empty listBooks}">
	<table class="tg">
	<tr>
		<th width="80">Book ID</th>
		<th width="120">Book Title</th>
		<th width="120">Book Author</th>
		<th width="120">Book Status</th>
		<th width="120">Genre</th>
		<th width="120">Borrow</th>
		<th width="120">View</th>
	</tr>
	<c:forEach items="${listBooks}" var="book">
		<tr>
			<td>${book.id}</td>
			<td>${book.bookName}</td>
			<td>${book.bookAuthor}</td>
			<td>${book.bookStatus}</td>
			<td>${book.bookGenre}</td>
			<c:choose>
				<c:when test="${book.bookStatus eq 'Available'}">
					<td><a href="<c:url value='/borrow/${book.id}' />" >Borrow</a></td>
				</c:when>
				<c:otherwise>
					<td>Checked Out</td>
				</c:otherwise>
			</c:choose>
			<td><a href="<c:url value='/view/${book.id}' />" >View</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>


<c:url var="addAction" value="/book/search" ></c:url>

<form:form action="${addAction}" commandName="Answer Question">
<table>
	<tr>
		<td colspan="2">
				<input type="submit"
					value="<spring:message text="Question"/>" />
		</td>
	</tr>
</table>
</body>
</html>
