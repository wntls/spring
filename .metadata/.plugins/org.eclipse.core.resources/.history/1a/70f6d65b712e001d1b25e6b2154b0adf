<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
#profileImgDiv {
	position: relative;
	border-raius: 1rem;
	width: 300px;
	height: 300px;
	margin-right: 2rem;
	background-repeat: no-repeat;
	background-size: cover;
	background-position: top center;
	box-sizing: border-box;
}
</style>

<%@include file="/WEB-INF/views/include/header.jsp"%>


<section class="signup spad">
	<div class="row justify-content-center">
		<div class="col-md-auto">
			<div class="login__form">
				<div class="section-title">
						<div class="row justify-content-between">
							<div class="col-auto">
								<h4><s:message code="text.user.modify"/></h4>
							</div>
							<div class="col-auto">
								<button id="editBtn" class="btn btn-danger" ><s:message code="btn.modify"/></button>
							</div>
					</div>
				</div>

				<div class="img-thumbnail mb-3" id="profileImgDiv"
					style="background-image: url('${path}/resources/img/member/middle/${user.img}');"></div>
				<form id="editForm" action="" method="post"
					enctype="multipart/form-data">

					<div class="input-group mb-3">
						<div class="custom-file">
							<input type="file" class="custom-file-input" name="img"
								id="img" accept="image/*"> <label class="custom-file-label" for="img"><s:message code="text.user.modify.profile"/></label>
						</div>
					</div>
					<input type="text" name="rights" value="0" hidden /> <s:message code="text.id"/>
					<div class="input__item">
						<span><i class="bi bi-person-circle"></i></span> <input
							type="text" name="id" id="id" value="${user.id}" readonly />
					</div>
					<s:message code="text.pw"/>
					<div class="input__item">
						<span class="icon_lock"></span> 
						<input type="password" name="pw" id="pw" placeholder="비밀번호 입력하세요" />
						<div class="result"></div>
					</div>
					<s:message code="sign.repw"/>
					<div class="input__item">
						<span class="icon_lock"></span> 
						<input type="password" name="repw" id="repw" placeholder="비밀번호 재입력하세요" />
						<div class="result"></div>
					</div>
					<s:message code="text.name"/>
					<div class="input__item">
						<span class="icon_profile"></span> <input type="text" name="name"
							id="name" value="${user.name}" />
							<div class="result"></div>
					</div>
					<s:message code="text.nickname"/>
					<div class="input__item">
						<span><i class="bi bi-person-video2"></i></span> <input
							type="text" name="nickname" id="nickname"
							value="${user.nickname}" />
							<div class="result"></div>
					</div>
					<s:message code="text.birth"/>
					<div class="input__item">
						<span><i class="bi bi-calendar3"></i></span> <input type="text"
							name="birth" value="<f:formatDate value="${user.birth}" pattern="yyyy-MM-dd"/>" readonly />
					</div>
					<s:message code="text.gender"/>
					<div class="btn-group btn-group-toggle w-100" data-toggle="buttons">
						<label class="btn btn-outline-secondary text-white radio-gender">
							<input type="radio" name="gender" id="male" value="male" /> 남성
						</label> <label
							class="btn btn-outline-secondary ml-2 text-white radio-gender">
							<input type="radio" name="gender" id="female" value="female" />
							여성
						</label>
					</div>
					<div class=" result mb-3"></div>

					<s:message code="text.address"/>
					<div class="mb-4">
						<div class="row addr-box">
							<div class="col-md-8 mb-4 ">
								<input type="text" class="form-control" name="post" id="post"
									value="${user.post}"  />
							</div>
							<div class="col-md-3" style="padding-right: 0">
								<input type="button" class="form-control btn btn-light" onclick="sample6_execDaumPostcode()" value="<s:message code="text.search.address/>"/>
							</div>
						</div>
						<input type="text" class="form-control mb-4" name="addr" id="addr"
							value="${user.addr}"  /> <input type="text"
							class="form-control" name="addrDetail" id="addrDetail"
							value="${user.addrDetail}"  />
							<div class="result"></div> 
					</div>

					<s:message code="text.phone"/>
					<div class="input__item">
						<span><i class="bi bi-phone"></i></span> <input type="text"
							name="phone" id="phone" value="${user.phone}" readonly />
					</div>

					<s:message code="text.email"/>
					<div class="input__item">
						<span class="icon_mail"></span> <input type="text" name="email"
							id="email" value="${user.email}" readonly />
					</div>

				</form>
			</div>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/include/footer.jsp"%>

<script>


	$('#img').on('change', function(event){
		var reader = new FileReader();
		console.log(reader);
		reader.onload = function(event) {
			$('#profileImgDiv').css({"background" : event.target.result});
		};

		reader.readAsDataURL(event.target.files[0]);
	})

	$(function() {

		$('#editBtn').click(function() {
			$('#editForm').submit();
		})

		if ('${user.gender}' == 'male') {
			$('#male').prop('checked', 'true');
			$('#female').prop('disabled', 'true');
		} else {
			$('#female').prop('checked', 'true');
			$('#male').prop('disabled', 'true');
		}

		if ("${message}" != "") {
			alert("${message}");
		}

		function checkRegex(elP, valP, regexP, messageP, ajaxP) {
			if (regexP.test(valP) === false) {
				showMessage(elP, messageP, false);
				return false;
			} else if (regexP.test(valP) !== false && ajaxP === null) {
				showMessage(elP, "", true);
				return true;
			} else {
				if (ajaxP !== null)
					ajaxP(elP);
			}
		}

		function showMessage(elP, messageP, isCheck) {
			$(elP)
					.html(
							`<sapn style='margin-left:5px;font-size:12px;${isCheck ? 'color:green;' : 'color:red;'}'>${messageP}</span>`);
		}

		$.validator.addMethod("regex", function(value, element, regexpr) {
			return regexpr.test(value);
		});

		$("#editForm").validate({
			onkeyup : function(el) {
				$(el).valid();
			},
			rules : {
				pw : {
					required : true,
					minlength : 6,
					maxlength : 20
				},
				repw : {
					required : true,
					minlength : 6,
					maxlength : 20,
					equalTo : "#pw"
				},

				name : {
					required : true,
					rangelength : [ 2, 6 ]
				},
				nickname : {
					required : true,
					rangelength : [ 2, 10 ]
				},
				gender : {
					required : true
				},
				addr : {
					required : true
				},
			},
			messages : {
				pw : {
					required : "비밀번호를 작성하세요.",
					minlength : "비밀번호는 최소 6자리 이상입니다.",
					maxlength : "비밀번호는 최대 20자리까지 가능합니다."
				},
				repw : {
					required : "비밀번호를 작성하세요.",
					minlength : "비밀번호는 최소 6자리 이상입니다.",
					maxlength : "비밀번호는 최대 20자리까지 가능합니다.",
					equalTo : "비밀번호가 일치하지 않습니다."
				},

				name : {
					required : "이름을 입력 하세요.",
					rangelength : "이름은 2~6글자 이내로 작성하세요."
				},

				nickname : {
					required : "닉네임을 입력하세요.",
					rangelength : "닉네임은 2~10글자 이내로 작성하세요."
				},

				addr : {
					required : "주소를 입력하세요."
				}
			},
			errorClass : "text-danger",
			errorElement : "div",
			errorPlacement : function(error, element) {
				if (element.prop("type") === 'radio') {
					element.removeClass("text-danger");
					error.insertAfter(element.parent().parent());
				} else if ($(element).attr('id') === 'addr') {
					error.insertAfter(element.next());
				} else {
					error.insertAfter(element);
				}
			}
		});

	});
</script>

