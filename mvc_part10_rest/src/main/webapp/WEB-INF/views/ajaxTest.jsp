<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxTest.jsp</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div style="background-color:gray;height:500px;">dummy</div>
	<div>
		<input type="text" id="name"/> <br/>
		<input type="number" id="age"/> <br/>
		<input type="button" id="get" value="GET"/> <br/>
		<input type="button" id="post" value="POST"/> <br/>
		<input type="button" id="PUT" value="PUT"/> <br/>
	</div>
	<div id="result" style="border: 1px solid black;"></div>
<script>
	$(function() {
		console.log("문서 준비 완료");
		$("#get").click(function() {
			let name = $("#name").val();
			let age = $("#age").val();
			console.log('name : '+name+' , age : '+age);
			
			$.ajax({
				async : true,
				type : "GET", // 전송방식
				url : "getSample",
				data : {	  // 전달 파라미터
					name : name,
					age : age
				},
				dataType : "json",	// 결과 데이터 타입
				success : function(data) {
					// 요청 처리 결과  - 성공 시
					console.log(data);
				},
				error : function(res) {
					console.log(res);
				}
			});	// ajax end
			console.log("ajax 호출 완료");
		});	// click event end
		
		$("#post").click(function() {
			let input_name = $("#name").val();
			let input_age = $("#age").val();
			
			$.ajax({
				type : "POST",
				url : "getSample",
				data : {	  // 전달 파라미터
					name : input_name,
					age : input_age
				},
				dataType : "json",
				success : function(data) {
					// data == List<SampleVO>
					var html = "<table border=1>";
					html +="<tr>";
					html +="<th>이름</th>";
					html +="<th>나이</th>";
					html +="</tr>";
					for(var i=0; i<data.length; i++){
						html +="<tr>";
						html +="<td>"+data[i].name+"</td>";
						html +="<td>"+data[i].age+"</td>";
						html +="</tr>";
					}
					html +="</table>";
					// innerHTML
					$("#result").html(html);
				}
			});	// ajax end
		});	// post click end
		
		$("#PUT").click(function() {
			$.ajax({
				type : "PUT",
				url : "testPUT",
				headers : {
					'Content-Type' : 'application/json'
				},
				data : JSON.stringify({
					name : $("#name").val(),
					age : $("#age").val()				
				}),
				dataType : "json",
				success : function(result) {
					console.log(result);
				}
			});
		});
	});
</script>
</body>
</html>

















