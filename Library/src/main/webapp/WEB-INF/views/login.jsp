<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
    <div align="center">
        <form:form action="login" method="post" commandName="user">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Welcome to Awesome Library, Please Login</h2></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><form:input path="userName" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="userPassword" /></td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Login" /></td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center"><a href="addCustomer">Don't have an account? Sign Up here</a></td>
                    <td></td>
                </tr>
                
            </table>
        </form:form>
    </div>
</body>
</html>