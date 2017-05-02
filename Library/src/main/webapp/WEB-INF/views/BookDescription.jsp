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
<!-- <h1> -->
<!-- 	Book Details -->
<!-- </h1> -->

<c:url var="addAction" value="/book/add" ></c:url>

<p align=right><a href="<c:url value='/books' />" >Home</a></p>

<br>
<h3>Book Description</h3>
<h4>${book.bookName}</h4>
<h5>By ${book.bookAuthor}</h5>
<p> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
<br>
<c:choose>
<c:when test="${book.bookStatus eq 'Available'}">
	<a href="<c:url value='/borrow/${book.bookId}' />" >Borrow</a>
</c:when>
<c:otherwise>
	<a href="<c:url value='/return/${book.bookId}' />" >Return</a>
</c:otherwise>
</c:choose>

</body>
</html>
