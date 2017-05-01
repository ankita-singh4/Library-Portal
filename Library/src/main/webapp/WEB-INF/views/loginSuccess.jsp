<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Success</title>
</head>
<body>
    <div align="center">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Login Succeeded!</h2></td>
            </tr>
            <tr>
                <td align="center">
                    <h3>Welcome! </h3>
                </td>
                
                <td><h3>${loginForm.userName}</h3></td>
            </tr>
            
        </table>
    </div>
</body>
</html>