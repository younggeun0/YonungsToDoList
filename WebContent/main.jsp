<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Young's to do list</title>
</head>
<body>

	<h3>Young's to do list</h3>
	<form action="add.do"  method="post">
		<input type="text" name="todo">
		<input type="submit" value="add">
	</form>
	
	<table>
		<c:forEach items="${ list }" var="dto">
		<tr>
			<td>
				<a href="complete.do?tId=${ dto.tId }">*</a>
			</td>
			<td>${ dto.tContent }</td>
			<td>
				<a href="delete.do?tId=${ dto.tId }">-</a>
			</td>
		</tr>
		</c:forEach>	
	</table>
	
	<hr/>
	
	<h3>Completed</h3>
	<table>
		<c:forEach items="${ completedList }" var="dto">
		<tr>
			<td>
				<a href="complete.do?tId=${ dto.tId }">*</a>
			</td>
			<td>${ dto.tContent }</td>
			<td>
				<a href="delete.do?tId=${ dto.tId }">-</a>
			</td>
		</tr>
		</c:forEach>	
	</table>


</body>
</html>