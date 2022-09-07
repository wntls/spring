<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<section>
	<div class="container-md spad">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="board-detail board-title text-secondary mb-5">
					<span>자유게시판 글 작성</span>
				</div>
				<form method="post">
					<input type="hidden" name="nickname" value="${user.nickname}"/>
					<div class="w-100"></div>
					<input class="board-detail board-title" name="title" type="text" placeholder="제목을 입력하세요.">
					<hr />
					<div class="row">
						<div class="col-md-6">
							<div class="blog__details">
								<div class="thumb-list-profile">
									<img src="${path}/resources/img/member/thumbnail/${user.img}" />
									<span class="text-white">${user.nickname}</span>
									<input type="hidden" name="memberId" value="${user.id}"/>
								</div>
							</div>
						</div>
					<!-- <div class="col-md-6 text-white"
							style="line-height: 50px; text-align: right">2022-08-22</div> -->
					</div>
					<div class="btn-group float-right">
						<select class="form-control" name="tag">
							<option value="일상" selected>일상</option>
							<option value="질문">질문</option>
							<option value="후기">후기</option>
						</select>
					</div>
					<div class="spad">
					<textarea id="editor" name="content" class="col-md-6 form-control"
							style="resize: none;"></textarea>
					</div>
					
					<div class="w-100"></div>
	
					<div class="blog__details__btns">
						<div class="row justify-content-between">
							<div class="col-md float-left">
								<button type="button" class="btn btn-danger">목록</button>
	
							</div>
							<div class="col-md">
								<div class="btn-group float-right" role="group">
									<button onclick="check()" class="btn btn-danger ml-3">작성</button>
									<button class="btn btn-secondary ml-3">취소</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/include/footer.jsp"%>
</html>



<script>
	var ckeditor_config = {
			resize_enabled : false,
			enterMode : CKEDITOR.ENTER_BR,
			shiftEnterMode : CKEDITOR.ENTER_P,
			height : 600,
			autoGrow_minHeight: 600,
			autoGrow_maxHeight: 5000,
			removePlugins : 'resize'
	};

	CKEDITOR.replace('editor', ckeditor_config);
	
	function check(){
		// ckeditor 내부의 텍스트를 가져오는 방법
		let innerContent = CKEDITOR.instances.editor.getData();
		console.log(innerContent);
	}
</script>












