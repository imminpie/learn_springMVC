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
	<form:form modelAttribute="user" method="post" >
		<div class="form-group row">
			<label class="col-sm-3 control-label">이메일</label>
			<div class="col-sm-5">
				<form:input path="email" cssClass="form-control" id="email" />
				<form:errors path="email" element="div" cssClass="alert text-danger" />
				<span class="err_name"></span>
			</div>
			<div class="col-sm-4">
				<button type="button" id="checkBtn" class="btn btn-success" >중복확인</button>
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