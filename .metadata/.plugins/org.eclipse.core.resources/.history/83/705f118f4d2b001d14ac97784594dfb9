<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<section>
	<div class="container-md spad">
		<div class="row justify-content-center">
			<div class="col-md-8">
			<!-- <form method="POST" action="modifyPage"> -->
				<div class="board-detail board-title text-secondary mb-5">
					<span>자유게시판 글 수정</span>
				</div>
				<div class="w-100"></div>
				<input class="board-detail board-title" type="text" value="${board.title}">
				<hr />
				<div class="row">
					<div class="col-md-6">
						<div class="blog__details">
							<div class="thumb-list-profile">
								<img src="${path}/resources/img/member/thumbnail/${user.img}" />
								<span class="text-white">${user.nickname}</span>
							</div>
						</div>
					</div>
				<div class="col-md-6 text-white"
						style="line-height: 50px; text-align: right">${board.regdate}</div>
				</div>
				<div class="spad">
				<textarea id="editor" class="col-md-6 form-control"
						style="resize: none;" placeholder="데이터 입력되어야함.">${board.content}
				</textarea>
				</div>
				
				<div class="w-100"></div>

				<div class="blog__details__btns">
					<div class="row justify-content-between">
						<div class="col-md float-left">
							<button type="button" class="btn btn-danger">목록</button>

						</div>
						<div class="col-md">
							<div class="btn-group float-right" role="group">
								<!-- <input type="submit" class="btn btn-danger ml-3" value="수정"/> -->
								<button id="modify" class="btn btn-danger ml-3">수정</button>
								<button class="btn btn-secondary ml-3">취소</button>
							</div>
						</div>
					</div>
				</div>
				<!-- </form> -->
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
		let innerContent = "이 텍스트를 에디터에 넣을 수 있음";
		console.log(innerContent);
		// ckeditor 내부에 텍스트를 넣는 방법
		CKEDITOR.instances.editor.setData(innerContent);
	}
	
	
</script>












