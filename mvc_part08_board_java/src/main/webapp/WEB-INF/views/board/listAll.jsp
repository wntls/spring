<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIST ALL</title>
</head>
<body>
	<h3>BOARD LIST ALL</h3>
	<a href="register">NEW BOARD</a>
	<h3>LIST - ${result}</h3>
	<table border="1">
		<tr>
			<th>BNO</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<th>REGDATE</th>
			<th>VIEWCNT</th>
		</tr>
		<c:choose>
			<c:when test="${!empty list}">
				<c:forEach var="board" items="${list}">
					<tr>
						<td>${board.bno}</td>
						<td><a href="read?bno=${board.bno}">${board.title}</a></td>
						<td>${board.writer}</td>
						<td>${board.regdate}</td>
						<td>${board.viewcnt}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr><th colspan="5">등록 된 게시물이 없습니다.</th></tr>
			</c:otherwise>
		</c:choose>
	</table>
	<script>
		var result = '${result}';
		if(result != null && result != ''){
			alert(result);
		}
	</script>
</body>
</html>













