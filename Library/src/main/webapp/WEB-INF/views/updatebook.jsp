<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
        <form:form action="updatebook" method="post" commandName="rmbook">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Please Enter the Details of book to update</h2></td>
                </tr>
                
                <tr>
                    <td>Book ID:</td>
                    <td><form:input path="bookId" /></td>
                </tr>
                
                <tr>
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
                    <td colspan="2" align="center"><input type="submit" value="Update" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>