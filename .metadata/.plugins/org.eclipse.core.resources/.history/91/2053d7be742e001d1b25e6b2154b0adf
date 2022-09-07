<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- Header Section Begin -->
<header class="header">
	<div class="container-md">
		<nav class="navbar navbar-light navbar-expand-md">
			<!-- 로고 -->
			<div class="col-md-3">
				<div class="row">
					<div class="col-md">
						<a href="${path}/"> <img style="height: 40px"
							src="${path}/resources/img/logo/betty2.png" alt="main">
						</a>

					</div>
				</div>
			</div>
			<!-- 가운데 메뉴바  .nav-link padding 나중에 1rem 으로 교체-->
			<div class="col-md-6">
				<nav class="nav">
					<a class="nav-link" href="${path}/library">
						<s:message code="text.betty.info" />
					</a>
					 
					<a class="nav-link" href="${path}/books">
						<s:message code="nav.book.list" />
					</a> 
					<a class="nav-link" href="${path}/boards/notice">
						<s:message code="text.board" />
					</a>
					<c:choose>
						<c:when test="${user.rights == 0}">
							<a class="nav-link" href="${path}/members/${user.id}/dashboard">
								<s:message code="nav.member" />
							</a>
							<a class="nav-link" href="${path}/offline/${user.id}"><s:message
									code="nav.offline" /></a>
						</c:when>
						<c:when test="${user.rights == 2}">
							<a class="nav-link" href="${path}/staff/books"><s:message
									code="nav.staff" /></a>

						</c:when>
						<c:when test="${user.rights == 3}">
							<a class="nav-link" href="${path}/admin/members"><s:message
									code="text.admin" /></a>
						</c:when>
					</c:choose>

				</nav>
			</div>
			<!-- 우측 회원관련 -->
			<c:choose>
				<c:when test="${user == null}">
					<div class="col-md-3 float-right">
						<nav class="nav float-right">
							<a class="nav-link" href="${path}/sign/in">
							<s:message code="sign.in" /></a> 
							<a class="nav-link" href="${path}/sign/up">
							<s:message code="btn.sign.up" /></a>
						</nav>
					</div>
				</c:when>
				<c:otherwise>
					<div class="col-md-3 float-right">
						<nav class="nav float-right">
							<c:choose>
								<c:when test="${user.rights == 0}">
									<a class="nav-link" href="${path}/members/${user.id}">${user.nickname}</a>
									<a class="nav-link" href="${path}/sign/logout"><s:message
											code="sign.out" /></a>
								</c:when>
								<c:when test="${user.rights == 1}">
									<a class="nav-link" href="#">${user.nickname}</a>
									<a class="nav-link" href="${path}/sign/logout"><s:message
											code="sign.out" /></a>
								</c:when>
								<c:when test="${user.rights == 2}">
									<a class="nav-link" href="${path}/staff/${user.id}">${user.nickname}</a>
									<a class="nav-link" href="${path}/sign/logout"><s:message
											code="sign.out" /></a>
								</c:when>
								<c:when test="${user.rights == 3}">
									<a class="nav-link" href="#">${user.nickname}</a>
									<a class="nav-link" href="${path}/sign/logout"><s:message
											code="sign.out" /></a>
								</c:when>
							</c:choose>

						</nav>
					</div>
				</c:otherwise>
			</c:choose>


			<div class="col-md-2">
				<nav class="nav">
					<a class="nav-link" id="ko" href="#">KOR</a> <a
						class="nav-link disabled" style="padding: 0.5rem 0.2rem">|</a> <a
						class="nav-link" id="en" href="#">ENG</a>
				</nav>
			</div>
		</nav>
	</div>
</header>
<div class="header-lantern-left"></div>
<div class="header-lantern-right"></div>
<c:choose>
	<c:when
		test="${ 
			nav eq 'members' 	
			or nav eq 'staff' 
			or nav eq 'admin'}">
		<jsp:include page="/WEB-INF/views/include/nav/${nav}-side-nav.jsp">
			<jsp:param name="path" value="${path}" />
			<jsp:param name="user" value="${user}" />
		</jsp:include>
	</c:when>
	<c:otherwise>
		<c:set var="uri" value="${pageContext.request.requestURI}" />
		<c:if test="${fn:contains(uri, 'views/board')}">
			<jsp:include page="/WEB-INF/views/include/nav/boards-side-nav.jsp">
				<jsp:param name="path" value="${path}" />
				<jsp:param name="user" value="${user}" />
			</jsp:include>
		</c:if>
	</c:otherwise>
</c:choose>
