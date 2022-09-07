<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
	#comments li{
		height: 100px;
		list-style: none;
		padding: 10px;
		border: 1px solid #ccc;
		margin: 5px 0;
	}
	
	#modDiv{
		border: 1px solid black;
		padding: 10px;
		display: none;
	}
	
	#pagination li{
		list-style: none;
		float: left;
		padding: 3px;
		border: 1px solid skyblue;
		margin: 3px;
	}
	#pagination li a{
		text-decoration: none;
		color: black;
	}
	
	#pagination li a.active{
		color: red;
	}
</style>
</head>
<body>
	<div id="modDiv">
		<div id="modCno"></div>
		<div>
			<input type="text" id="modText"/>
		</div>
		<div>
			<input type="text" id="modAuth"/>
		</div>
		<div>
			<button id="modBtn">MODIFY</button>
			<button id="delBtn">DELETE</button>
			<button id="closeBtn">CLOSE</button>
		</div>
	</div>
	<h2>AJAX - REST TEST</h2>
	<div>
		<div>
			comment auth : <input type="text" id="cAuth"/>
		</div>
		<div>
			comment text : <input type="text" id="cText"/>
		</div>
		<button id="addBtn">ADD COMMENT</button>
	</div>
<div>
	<!-- 댓글 리스트 -->
	<ul id="comments">
		
	</ul>
	<!-- 페이징 블럭 정보 -->
	<ul id="pagination">
	
	</ul>
	<br/><br/><br/><br/><br/>
</div>
<script>
	var bno = 6000;
	
	var page = 1;
	
	//getCommentList();
	
	listPage(page);
	
	function listPage(page) {
		$("#modDiv").css("display","none");
		$("body").prepend($("#modDiv"));
		var url = "comments/"+bno+"/"+page;
		$.getJSON(url,function(data){
			console.log(data);
			console.log(data.list);
			console.log(data.pm);
			printList(data.list);
			printPage(data.pm);
		});
		
	}
	
	function printPage(pm){
		var str = "";
		if(pm.prev){
			str += "<li><a href='"+(pm.startPage - 1)+"'> << </a></li>";
		}
		for(var i = pm.startPage; i<=pm.endPage; i++){
			if(pm.cri.page == i){
				str += "<li><a href='"+i+"' class='active'>"+i+"</a></li>";
			}else{
				str += "<li><a href='"+i+"'>"+i+"</a></li>";
			}
		}
		if(pm.next){
			str += "<li><a href='"+(pm.endPage + 1)+"'> >> </a></li>";
		}
		$("#pagination").html(str);
	}
	
	$("#pagination").on("click","li a",function(e){
		e.preventDefault(); // 기본 이벤트 무시
		var commentPage = $(this).attr("href");
		page = commentPage;
		listPage(page);
	});
	
	function getCommentList() {
		$("body").prepend($("#modDiv"));
		var url = "comments/all/"+bno;
		$.getJSON(url,function(data){
			console.log(data);
			printList(data);
		});
	}
	
	// 댓글 목록 출력
	function printList(list) {
		// list = [commentDTO,commentDTO ...]
		var str = "";
		$(list).each(function() {
			// commentDTO == this
			let cno = this.cno;
			let cText = this.commentText;
			let cAuth = this.commentAuth;
			console.log(cno+":"+cAuth+":"+cText);
			str += "<li>";
			str += cno+"-"+cAuth+"<br/><hr/>"+cText;
			str += "<br/><br/>";
			str += "<button data-cno='"+cno+"' data-text='"+cText+"' data-auth='"+cAuth+"'>MODIFY</button>";
			str += "</li>";
		});
		$("#comments").html(str);
	}
	
	$("#comments").on("click","li button",function(){
		console.log("click");
		var cno = $(this).attr("data-cno"); 
		var text = $(this).attr("data-text");
		var auth = $(this).attr("data-auth");
		console.log(cno+":"+auth+":"+text);
		
		$("#modCno").text(cno);
		$("#modText").val(text);
		$("#modAuth").val(auth);
		
		$(this).parent().after($("#modDiv"));
		
		$("#modDiv").toggle("slow");
		
	});
	
	$("#closeBtn").click(function() {
		$("#modDiv").slideUp("slow");
	});
	
	// 수정 화면 MODIFY button click
	$("#modBtn").click(function() {
		var cno = $("#modCno").text();
		var text = $("#modText").val();
		var auth = $("#modAuth").val();
		
		$.ajax({
			type : "PATCH",
			url : "comments/"+cno,
			headers : {
				"Content-Type" : "application/json"
			},
			data : JSON.stringify({
				commentText : text,
				commentAuth : auth
			}),
			dataType : "text",
			success : function(data) {
				alert(data);
				$("#modDiv").slideUp("slow");
				//getCommentList();
				listPage(page);
			}
		});
	});
	
	$("#addBtn").click(function() {
		var auth = $("#cAuth").val();
		var text = $("#cText").val();
		
		$.ajax({
			type : "POST",
			url : "comments",
			dataType : "text",
			data : {
				bno : bno,
				commentAuth : auth,
				commentText : text
			},
			success : function(result) {
				alert(result);
				//getCommentList();
				page = 1;
				listPage(page);
			}
		});
	});
	// 댓글 삭제 버튼
	$("#delBtn").click(function() {
		var cno = $("#modCno").text();
		$.ajax({
			type : "DELETE",
			url : "comments/"+cno,
			dataType : "text",
			success : function(data) {
				alert(data);
				$("#modDiv").slideUp("slow");
				//getCommentList();
				listPage(page);
			}
		});
	});
</script>
</body>
</html>






















