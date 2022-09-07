<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/custom.css" rel="stylesheet">
<script>
	if('${msg}' != '')alert('${msg}');
</script>
<title>애플리케이션 테스트 수행</title>
</head>
<body>
	<header>
		<div class="container">
			<nav class="navbar">
				<ul class="nav full-right">
					<li class="nav-item"><a class="nav-link" href="#">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="#">회원가입</a></li>
				</ul>
			</nav>
			<nav class="navbar">
				<ul class="nav nav-fill">
					<li class="nav-item"><a class="nav-link" href="<c:url value='/'/>">HOME</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value='/notice/notice_list'/>">공지사항</a></li>
					<li class="nav-item"><a class="nav-link" href="#">질문과답변</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value='/KaKaoMap'/>">오시는 길</a></li>
				</ul>
			</nav>
		</div>
	</header>