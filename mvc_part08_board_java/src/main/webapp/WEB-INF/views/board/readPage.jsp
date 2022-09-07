<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>READ PAGE BAORD</h3>
	<!-- model boardVO -->
	<div>
			<label>TITLE</label>
			<input type="text" name="title" value="${boardVO.title}" readonly/>
		</div>
		<div>
			<label>CONTENT</label>
			<textarea name="content" readonly rows="3" >${boardVO.content}</textarea>
		</div>
		<div>
			<label>WRITER</label>
			<input type="text" name="writer" value="${boardVO.writer}" readonly/>
		</div>
		<div>
			<button id="modify">Modify</button>
			<button id="remove">Remove</button>
			<button id="list">List Page</button>
		</div>
		criteria : ${criteria} <br/>
		cri : ${cri} <br/>
		<form id="pageForm" method="POST">
			<input type="hidden" name="bno" value="${boardVO.bno}"/>
			<input type="hidden" name="page" value="${cri.page}"/>
			<input type="hidden" name="perPageNum" value="${cri.perPageNum}"/>
		</form>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	// 문서가 모두 로드 되었을때 실행 될 함수
	$(function() {
		var formObj = $("#pageForm");
		// 리스트 버튼 클릭
		$("#list").click(function(){
			$("input[name='bno']").attr("disabled","disabled");
			formObj.attr("action","listPage");
			formObj.attr("method","get");
			formObj.submit();
		});
		
		$("#modify").click(function(){
			formObj.attr("action","modifyPage");
			formObj.attr("method","get");
			formObj.submit();
		});
		
		$("#remove").click(function(){
			formObj.attr("action","removePage");
			formObj.submit();
		});
	});
</script>
</body>
</html>









