<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
        <form:form action="removebook" method="post" commandName="rmbook">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Please Enter Book ID</h2></td>
                </tr>
                <tr>
                    <td>Book ID:</td>
                    <td><form:input path="bookId" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Remove" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>