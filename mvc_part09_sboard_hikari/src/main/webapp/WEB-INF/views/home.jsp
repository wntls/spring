<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="./include/header.jsp"/>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">
						HOME PAGE
					</h3>
				</div>
				<div class="box-body">
					<!-- de -->
					<a class="btn btn-primary" href="sboard/register">검색 게시판 글쓰기</a>
					<a class="btn btn-danger" href="sboard/listPage">검색 게시판 목록</a>
				</div>
				<div class="box-footer">
				
				</div>
			</div>
		</div>
	</div>
</section>
<jsp:include page="./include/footer.jsp"/>