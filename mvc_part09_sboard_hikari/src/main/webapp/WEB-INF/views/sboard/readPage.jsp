<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../include/header.jsp"/>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">
						SEARCH READ PAGE - ${board.bno}
					</h3>
				</div>
				<div class="box-body">
					<div>
						<label>TITLE</label>
						<label>${board.title}</label>
					</div>
					<div>
						<label>CONTENT</label>
						<label>${board.content}</label>
					</div>
					<div>
						<label>WRITER</label>
						<label>${board.writer}</label>
					</div>
					<div>
						<label>REGDATE - </label>
						<f:formatDate value="${board.regdate}" pattern="yyyy-MM-dd HH:mm"/>
					</div>
				</div>
				<div class="box-footer">
					<button class="btn btn-warning">MODIFY</button>
					<button class="btn btn-danger">DELETE</button>
					<button class="btn btn-primary">LIST</button>
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
</section>
<script>
	var formObj = $("#readForm");
	$(".btn-primary").click(function(){
		/* location.href='listPage'; */
		formObj.attr("action","listPage").submit();
	});
	// 수정 버튼 클릭
	$(".btn-warning").click(function(){
		formObj.attr("action","modifyPage");
		formObj.submit();
	});
	
	// 삭제 버튼 클릭
	$(".btn-danger").click(function(){
		formObj.attr("action","removePage");
		formObj.attr("method","POST");
		formObj.submit();
	});
</script>


<jsp:include page="../include/footer.jsp"/>




