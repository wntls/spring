<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
</head>
<body>
	<h3>${result}</h3>
	<a href="test1">test1</a> <br/>
	<a href="test2">test2</a> <br/>
	<a href="test3">test3</a> <br/>
	
	<%
		request.setAttribute("result1", "HOME JSP VALUES");
	%>
</body>
</html>