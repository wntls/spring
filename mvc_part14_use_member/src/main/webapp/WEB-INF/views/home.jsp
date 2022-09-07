<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- home.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAIN HOME</title>
</head>
<body>
	<h3>MAIN PAGE</h3>
	<c:choose>
		<c:when test="${!empty sessionScope.userInfo}">
			<label>${userInfo.uname}</label> &nbsp;&nbsp;
			<a href="user/signOut">Sign Out</a>
		</c:when>
		<c:otherwise>
			<a href="user/signUp">SignUp</a>
			<a href="user/signIn">SignIn</a>		
		</c:otherwise>
	</c:choose>
	<a href="board/listReply">질문과답변 게시판</a>
	<script>
		var invalidate = '${invalidate}';
		if(invalidate != ''){
			alert(invalidate);
			location.href='${pageContext.request.contextPath}/user/signOut';
		}
	</script>
</body>
</html>