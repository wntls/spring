<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Header Section Begin -->
	<header class="header">
		<div class="container-md">
			<nav class="navbar navbar-light navbar-expand-md">
				<!-- 로고 -->
					<div class="col-md-3">
						<div class="row">
							<div class="col-md">
								<a href="${path}/"> 
								<img style="height: 40px" src="${path}/resources/img/logo/betty2.png" alt="main">
								</a>
	
							</div>
							<div class="col-md">
								<%@include file="home-mega-menu.jsp" %>
							</div>
						</div>
					</div>
						<!-- 가운데 메뉴바  .nav-link padding 나중에 1rem 으로 교체-->
						<div class="col-md-4">
							<nav class="nav">
								<a class="nav-link" href="${path}/library">도서관 소개</a> 
								<a class="nav-link" href="${path}/books">도서 목록</a> 
								<a class="nav-link" href="${path}/boards/notice">게시판</a>
								<c:choose>
									<c:when test="${user.rights == 0}">
										<a class="nav-link" href="${path}/members/num/dashboard">회원 공간</a>
												
									</c:when>
									<c:when test="${user.rights == 2}">
										<a class="nav-link" href="${path}/staff/books">직원</a>
									
									</c:when>
									<c:when test="${user.rights == 3}">
										<a class="nav-link" href="${path}/admin/members">관리자</a>
										
									</c:when>
								</c:choose>
							</nav>
						</div>
						<!-- 우측 회원관련 -->
						
						<c:choose>
							<c:when test="${user == null}">
								<div class="col-md-3 float-right">
									<nav class="nav float-right">
										<a class="nav-link" href="${path}/sign/in">로그인</a> <a
											class="nav-link" href="${path}/sign/up/member">회원가입</a>
									</nav>
								</div>
							</c:when>
							<c:otherwise>
								<div class="col-md-3 float-right">
									<nav class="nav float-right">
										<a class="nav-link" href="${path}/members/${user.id}">${user.nickname}님</a> 
										<a class="nav-link" href="${path}/sign/logout">로그아웃</a>
									</nav>
								</div>
							</c:otherwise>
						</c:choose>
						
						
						<div class="col-md-2">
							<nav class="nav">
								<a class="nav-link active" href="#">KOR</a> <a
									class="nav-link disabled" style="padding: 0.5rem 0.2rem">|</a>
								<a class="nav-link wait" href="#">ENG</a>
							</nav>
					</div>
			</nav>
		</div>
	</header>
<div class="header-lantern-left"></div>
<div class="header-lantern-right"></div>

<c:if test="${ 
			nav eq 'members' 	
			or nav eq 'boards' 
			or nav eq 'staff' 
			or nav eq 'admin'}">
	<jsp:include page="/WEB-INF/views/include/nav/${nav}-side-nav.jsp">
		<jsp:param name="path" value="${path}"/>
	</jsp:include>
</c:if>
