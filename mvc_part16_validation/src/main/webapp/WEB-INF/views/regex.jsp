<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정규표현식/regex.jsp</title>
</head>
<body>
	<script>
		/*
			정규식은 문자열에 포함된 문자 조합을 찾기 위해 사용되는 패턴
			javascript의 정규 표현식은 java와 상이 할 수 있으나
			기본 맥락은 동일
		*/
		const regex = /\d{3}-\d{4}-\d{4}/;
		var bool = regex.test("010-1111-1111");
		console.log(bool);	// true
		bool = regex.test("01-11-22");
		console.log(bool);	// false
		
		const text = "안녕하세요 제 번호는 010-1111-1111l입니나. 연락 주세요"
		var result = text.match(regex);
		console.log(result);
		const pattern = /\d{5}-\d{4}-\d{4}/;
		result = text.match(pattern);
		console.log(result);
		
		var regexEmail =/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
		const url = "wntls32@naver.com";
		console.log(url.match(regexEmail));
		console.log(regexEmail.test(url));
	</script>
</body>
</html>








