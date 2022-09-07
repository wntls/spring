<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>resData.jsp</title>
</head>
<body>
	<a href="testJSON">testJSON</a>
	<h3>getSample</h3>
	<!-- 
		multipart/form-data : 모든 문자를 인코딩 하지 않음을 명시
		form 요소가 파일이나 이미지를 서버에 전송할때 사용
		text/plain	공백 문자만(+) 기호로 변환 나머지는 인코딩 하지 않음
		application/x-www-form-urlencoded
		모든 값을 서버로 전달하기 전에 인코딩 됨을 명시
	 -->
	<form action="getSample" method="get" enctype="application/x-www-form-urlencoded">
		<input type="text" name="name"/><br/>
		<input type="number" name="age"/><br/>
		<input type="submit" value="GET"/>
	</form>
	<hr/>
	<a href="getSampleList">getSampleList</a><br/>
</body>
</html>