<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<!-- Blog Details Section Begin -->
<h2>${pm.cri.page}</h2>
<section>
	<div class="container-md spad">
		<div class="row justify-content-center">


			<div class="col-md-8">
				<div class="board-detail board-title text-secondary">
					<span>자유 게시판</span>
				</div>
				<div class="w-100"></div>

				<input class="board-detail board-title" type="text"
					value="${board.title}" readonly>
				<hr />
				<div class="row">
					<div class="col-md-6">
						<div class="blog__details">
							<div class="thumb-list-profile">
								<!-- 게시글 데이터 수정 필요 -->
								<img src="${path}/resources/img/member/thumbnail/${img}" /> <span
									class="text-white">${board.nickname}</span>
							</div>
						</div>
					</div>
					<div class="col-md-6 text-white"
						style="line-height: 50px; text-align: right">
						<f:formatDate value="${board.regdate}"
							pattern="yyyy-MM-dd (E) hh:mm" />
					</div>
				</div>

				<div class="spad-sm">
					<c:out value="${board.content}" escapeXml="false"></c:out>
				</div>


				<div class="w-100"></div>

				<div class="blog__details__btns">
					<div class="row justify-content-between">
						<div class="col-md float-left">
							<button id="list" type="button" class="btn btn-danger">목록</button>
						</div>
						<c:if test="${board.memberId eq sessionScope.user.id}">
						<div class="col-md">
							<div class="btn-group float-right" role="group">
								<button id="modify" class="btn btn-danger">수정</button>
								<button id="removeBtn" class="btn btn-secondary ml-3">삭제</button>
							</div>
						</div>
						</c:if>
					</div>
				</div>

				<div class="w-100"></div>

				<%-- <h4>총 2개의 댓글</h4> --%>
				<div class="blog__details__comment">
					<div id="commentBox">
					
					</div>
						<!-- 페이징  -->
						<div class="form-row">
							<ul class="pagination" id="pa">
							
							</ul>
						</div>
						
					<!-- <div id="modDiv" class="blog__details__form">
						<h4>댓글 작성란</h4>
						<form action="#">
							<div class="row" style="display: block">
								<div class="col-md-12">
									<textarea id="commentArea" placeholder="Message"></textarea>
									<button id="addBtn" type="button" class="site-btn">작성</button>
								</div>
							</div>
						</form>
					</div> -->
					
					<div class="blog__details__form">
						<h4>댓글 작성란</h4>
						<form action="#">
							<div class="row" style="display: block">
								<div class="col-md-12">
									<textarea id="commentArea" placeholder="Message"></textarea>
									<button id="addBtn" type="button" class="site-btn">작성</button>
								</div>
							</div>
						</form>
					</div>
				<form id="readForm" method="get">
					<input type="hidden" name="bno" value="${board.bno}"/>
					<input type="hidden" name="page" value="${cri.page}"/>
					<input type="hidden" name="perPageNum" value="${cri.perPageNum}"/>
					<input type="hidden" name="searchType" value="${cri.searchType}"/>
					<input type="hidden" name="keyword" value="${cri.keyword}"/>
				</form>
				</div>
			</div>
		</div>
	</div>
</section>


<%@include file="/WEB-INF/views/include/footer.jsp"%>

<script>
	
	var page = ${pm.cri.page};
	
	var bno = ${board.bno};
	
	listPage(page);
	
	function listPage(page) {
		var url = "${path}/boards/free/"+bno+"/"+page+"comments";
		$.getJSON(url,function(data){
			console.log(data);
			console.log(data.list);
			console.log(data.pm);
			printList(data.list);
			printPage(data.pm);
			console.log("listPage end");
		});
	};
	

	function printPage(pm){
		console.log("printPage str");
		console.log(pm);
		var str = "";
		if(pm.prev){
			str += "<li><a href='"+(pm.startPage - 1)+"'> Previous </a></li>";
		}
		for(var i = pm.startPage; i<=pm.endPage; i++){
			if(pm.cri.page == i){
				str += "<li><a href='"+i+"' class='active'>"+i+"</a></li>";
			}else{
				str += "<li><a href='"+i+"'>"+i+"</a></li>";
			}
		}
		if(pm.next){
			str += "<li><a href='"+(pm.endPage + 1)+"'> Next </a></li>";
		}
		$("#pa").html(str);
		console.log("printPage end");
	}
	
	$("#pa").on("click","li a",function(e){
		console.log(e);
		console.log("pagenation start");
		e.preventDefault();
		var commentPage = $(this).attr("href");
		page = commentPage;
		console.log(page);
		console.log(commentPage);
		listPage(page);
		console.log("pagenation end");
	});
	
	
	let sessionUser = '${user.id}';
	
	
	function printList(list) {
		console.log("printList start");
		console.log(list);
		var str = "";
		let comment = "";
		$(list).each(function(i) {
			/* let text = this.commetn;
			let nickname = this.nickname;
			let regdate = this.regdate;
			str += "<div class="+blog__details__comment__item+">";
			str += "<div class="+anime__review__item__pic+">";
			str += "<img src="+${path}/resources/img/member/thumbnail/profile_male.jpg+">";
			str += "</div>";
			str += "<div class="+blog__details__comment__item__text+">";
			str += "<span>"+regdate+"</span>";
			str += "<h5>"+nickname+"</h5>";
			str += "<p>"+text+"</p>";
			str += "<a href="+#+">답글</a>";
			str += "</div>";
			str += "</div>"; */
			/* <a href="#">답글</a> */
				comment += 
				`<div class="blog__details__comment__item 
					\${list[i].origin == list[i].origin ? '' : 'blog__details__comment__item--reply'}">
						<div class="anime__review__item__pic">
						<img src="${path}/resources/img/member/thumbnail/profile_male.jpg" alt="">
					</div>
					<div class="blog__details__comment__item__text">
						<span>\${list[i].regdate}</span>
						<h5>\${list[i].nickname}</h5>
						<p>\${list[i].comment}</p>
						<button id="delBtn" class="btn btn-secondary">답글</button>
						
					\${ ((list[i].origin != 0) && (list[i].memberId == sessionUser)) ? 
							'<button id="delBtn" onclick="delBtnClick(this)" data-cno="'+this.cno+'" class="btn btn-secondary">삭제</button>'/* '<a href="#">삭제</a>' */ 
							: 
							''}
					</div>
				</div>`;
		});
		$('#commentBox').html(comment);
		console.log("printList end");
	}
	
	
	$("#list").click(function(){
		location.href='${path}/boards/free?${pm.makeQuery(pm.cri.page)}';
		console.log('${pm.cri.page}');
	});
	
	/* $(function(){
		$.ajax({
			type: "get",
			url: "${path}/boards/free/${board.bno}/comments",
			dataType: 'json',
			success: function(data){
				console.log(data);
				console.log(data.length);
				let comment = "";
				let sessionUser = '${user.id}';
				for(let i = 0; i < data.length; i++){
					console.log(i);
					console.log(data[i].nickname);
					comment = 
						`<div class="blog__details__comment__item 
							\${data[i].origin != 0 ? '' : 'blog__details__comment__item--reply'}">
								<div class="anime__review__item__pic">
								<img src="${path}/resources/img/member/thumbnail/profile_male.jpg" alt="">
							</div>
							<div class="blog__details__comment__item__text">
								<span>\${data[i].regdate}</span>
								<h5>${user.nickname}</h5>
								<p>\${data[i].comment}</p>
								<a href="#">답글</a>
							\${ ((data[i].origin != 0) && (data[i].memberId == sessionUser)) ? 
									'<a href="#">삭제</a>' 
									: 
									''}
							</div>
						</div>`;
						
					$('#commentBox').append(comment);
				}
			},
			error: function(){
				alert("호출 실패");
			}
		});
	}); */
	

	$("#addBtn").click(function() {
		var commentArea = $("#commentArea").val();
		
		$.ajax({
			type : "POST",
			url : "${path}/boards/free/${board.bno}/comments",
			dataType : "text",
			data : {							
					freeBno : ${board.bno},
					memberId : "${sessionScope.user.id}",
					comment : commentArea,
					nickname : "${sessionScope.user.nickname}"							
			},
			success : function(result) {
				console.log(result);
				listPage(page);
				$("#commentArea").val("");
			},
			error : function() {
				alert("실패");
			}
		});
	});
	
	var formObj = $("#readForm");
	
	$("#modify").click(function(){
		formObj.attr("action","modifyPage");
		formObj.attr("method","GET");
		formObj.submit();
	});
	
	
	$("#removeBtn").click(function() {
		var isDelete = confirm("게시글을 삭제 하시겠습니까?");
		if(isDelete){
			formObj.attr("action","remove");
			formObj.attr("method","POST");
			formObj.submit();
		}else{
			alert('삭제 실패');
		}
	});
	
	
	$("#commentBox").on("click","#delBtn",function(ev) {
		let coo = ev.target.dataset.cno;
		console.log(coo);
		$.ajax({
			type : "delete",
			url : '${path}/boards/free/comments/'+coo,
			dataType : "text",
			success : function(result) {
				console.log(result);
				alert(result);
				listPage(page);
			}
		});
	});
	
	function delBtnClick(ev){
		let cno = ev;
		console.log(cno);
		
	}
	/* $("#delBtn").click(function() {
		var cno = this.cno;
		$.ajax({
			type : "POST",
			url : "${path}/boards/free/"+cno+"/del",
			dataType : "text",
			success : function(data) {
				alert(data);
				listPage(page);
			}
		});
	}) */
	
</script>

















