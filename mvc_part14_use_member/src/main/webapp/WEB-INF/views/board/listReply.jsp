<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/listReply.jsp</title>
</head>
<body>
	<h1><a href="${path}">HOME</a></h1>
	<div>
		<select>
			<option value="n">--------------</option>
			<option value="t">TITLE</option>
			<option value="c">CONTENT</option>
			<option value="w">WRITER</option>
			<option value="tc">TITLE &amp; CONTENT</option>
			<option value="tw">TITLE &amp; WRITER</option>
			<option value="tcw">TITLE &amp; WRITER &amp; CONTENT</option>
		</select>
		<input type="text" id="keyword"/>
		<input type="button" value="검색" id="searchBtn"/>
		<c:if test="${!empty sessionScope.userInfo}">
			<input type="button" id="newBtn" value="글작성"/>
		</c:if>
	</div>
	<br/>
	<!-- 게시글 목록 -->
	<table border="1">
		<tr>
			<th>BNO</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<th>REGDATE</th>
			<th>VIEWCNT</th>
		</tr>
		<!-- 게시글 리스트 목록 출력 : list -->
		<c:choose>
			<c:when test="${!empty list}">
				<c:forEach var="board" items="${list}">
					<c:choose>
						<c:when test="${board.showboard eq 'y'}">
							<tr>
								<td>${board.bno}</td>
								<td>
									<a href="readPage?bno=${board.bno}">
									<c:forEach var="i" begin="1" end="${board.depth}">
										&nbsp;&nbsp;&nbsp;&nbsp;
									</c:forEach>
									<c:if test="${board.depth != 0}">
										<!-- ㅂ 한자 + 6 -->
										└
									</c:if>
									${board.title}
									</a>
								</td>
								<td>${board.writer}</td>
								<td>
									<f:formatDate value="${board.regdate}" pattern="yyyy-MM-dd (E) hh:mm"/>
								</td>
								<td>${board.viewcnt}</td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td></td>
								<td>삭제된 게시물 입니다.</td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</c:otherwise>
					</c:choose>
					
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td></td>
					<td>등록된 게시물이 없습니다.</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</c:otherwise>
		</c:choose>
		<!-- 페이징 블럭 출력 -->
		<tr>
			<th colspan="5">
				<c:forEach var="i" begin="${pm.startPage}" end="${pm.endPage}">
					<a href="listReply?page=${i}">[${i}]</a>
				</c:forEach>
			</th>
		</tr>
	</table>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	// 새글 작성 버튼 클릭
	$("#newBtn").click(function() {
		location.href='${path}/board/register';
	});
	
	// 검색
	$("#searchBtn").click(function() {
		var searchType = $("select option:selected").val();
		var keyword = $("#keyword").val();
		console.log("selectType : "+searchType);
		console.log("keyword : "+keyword);
		location.href="listReply?searchType="+searchType+"&keyword="+keyword;
	});
</script>
</body>
</html>





















