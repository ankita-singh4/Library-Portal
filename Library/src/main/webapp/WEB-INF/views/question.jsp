<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>User Questions</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	User Questions
</h1>

<c:url var="addAction" value="/question/add" ></c:url>

<form:form action="${addAction}" commandName="question">
<table>
	<c:if test="${question.id ne 0}">
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
			<form:label path="question">
				<spring:message text="Question"/>
			</form:label>
		</td>
		<td>
			<form:input path="question" />
		</td> 
	</tr>
		<tr>
		<td colspan="2">
			<c:if test="${question.id ne 0}">
				<input type="submit"
					value="<spring:message text="Answer Question"/>" />
			</c:if>
			<c:if test="${question.id eq 0}">
				<input type="submit"
					value="<spring:message text="Add Question"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Questions List</h3>
<c:if test="${!empty listQuestions}">
	<table class="tg">
	<tr>
		<th width="80">Question Id</th>
		<th width="160">Question</th>
		<th width="60">Answer</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listQuestions}" var="question">
		<tr>
			<td>${question.id}</td>
			<td>${question.question}</td>
			<td><a href="<c:url value='/edit/${question.id}' />" >Answer</a></td>
			<td><a href="<c:url value='/remove/${question.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
