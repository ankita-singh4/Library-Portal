<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation</title>
</head>
<body>

<table class="tg">
		 <tr>
                    <td colspan="2" align="center"><h2>Are you sure you want to remove following book ?</h2></td>
          </tr>
		<tr>
		<td> <p>Name: ${bookName}</p> </td>
		<td> <p>Author: ${bookAuthor}</p> </td>
		<td> <p>Genre: ${bookGenre}</p> </td>
		<td> <p>	ISBN: ${bookISBN}</p> </td> 
		</tr>
		
		<tr>
			
			<td><a href="yesremove" >Yes</a></td>
			<td><a href="noremove" >NO</a></td>
		</tr>
	
	</table>
</body>
</html>