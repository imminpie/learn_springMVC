<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="utf-8"%>

<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">회원가입</h1>
	</div>
</div>
<div class="container">
	<form:form modelAttribute="user" method="post" onsubmit="return fn_checkForm();">
		<div class="form-group row">
			<label class="col-sm-3 control-label">이메일</label>
			<div class="col-sm-5">
				<form:input path="email" cssClass="form-control" id="email" />
				<form:errors path="email" element="div" cssClass="alert text-danger" />
				<span class="err_name"></span>
			</div>
			<div class="col-sm-4">
				<button type="button" id="checkBtn" class="btn btn-success" onclick="fn_checkDuplication();">중복확인</button>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-3 control-label">비밀번호</label>
			<div class="col-sm-5">
				<form:password path="password" cssClass="form-control" id="password" />
				<form:errors path="password" element="div" cssClass="alert text-danger" />
				<span class="err_password"></span>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-3 control-label">비밀번호 확인</label>
			<div class="col-sm-5">
				<form:password path="repassword" cssClass="form-control" id="repassword" />
				<form:errors path="repassword" element="div" cssClass="alert text-danger" />
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-3 control-label">생년월일</label>
			<div class="col-sm-5">
				<form:input path="birth" cssClass="form-control" id="birth" placeholder="YYYY/MM/DD" maxlength="8"/>
				<form:errors path="birth" element="div" cssClass="alert text-danger" />
			</div>
		</div>
		<div class="form-group"></div>
		<div class="form-action">
			<input type="submit" class="btn btn-primary btn-lg btn-block" value="회원 가입">
		</div>
	</form:form>
</div>
<script>
	let checkYn = "N";
	
	function fn_checkDuplication() {
		
		let email = document.getElementById('email').value;
		
		if(email.length == 0) {
			checkYn = "N";
			document.querySelector('.err_name').textContent = "* 이메일을 입력하세요.";
		} else {
			
			$.ajax({
				type : "GET",
				url : "/signup/checkDuplication",
				data : {email : email},
				success : function(data) {
					if(data == 0) {
						document.querySelector('.err_name').textContent = "* 사용 가능합니다.";
				        checkYn = "Y";
					} else {
						document.querySelector('.err_name').textContent = "* 이메일이 중복되었습니다.";
				        checkYn = "N";
					}
				},
				error: function (xhr, status, error) {
					console.log(error);
				},
			})
			
		}
		
	}
	
	function fn_checkForm() {
		
		let email = document.getElementById("email");
		let password = document.getElementById("password");
		let repassword = document.getElementById("repassword");
		let birth = document.getElementById("birth");

		if(checkYn == "N") {
			document.querySelector('.err_name').textContent = "* 중복확인 버튼을 클릭하세요.";
			return false;
		}
		
		if(email.value == "") {
			document.querySelector('.err_name').textContent = "* 이메일을 입력하세요.";
			return false;
		}
		
		if(password.value == "") {
			document.querySelector(".err_password").textContent = "* 비밀번호를 입력하세요.";
			return false;
		}
		
		if(repassword.value == "") {
			document.querySelector(".err_repassword").textContent = "* 비밀번호를 입력하세요.";
			return false;
		}
		
		if(repassword.value !== "" && password.value !== repassword.value) {
			document.querySelector(".err_password").textContent = "* 비밀번호를 확인해 주세요.";
			return false;
		}
		
		if(birth.value == "") {
			document.querySelector(".err_birth").textContent = "* 생년월일을 입력해 주세요.";
			return false;
		}

		
		if(checkBtn == "Y") {
			let goForm = document.getElementById("signupForm");
			goForm.action = "/signup";
			goForm.method = "POST";
			goForm.submit();
		}
		
	}
</script>