<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">로그인</h1>
	</div>
</div>
<div class="container col-md-4">
	<div class="text-center">
		<c:if test="${not empty error}">
			<div class="alert alert-danger">
				이메일과 비밀번호가 올바르지 않습니다.<br />
			</div>
		</c:if>
		<form class="form-signin" action="<c:url value="/user/login"/>" method="post">
			<div class="form-group row">
				<input type="text" name="email" class="form-control" placeholder="이메일" required autofocus>
			</div>
			<div class="form-group row">
				<input type="password" name="password" class="form-control" placeholder="비밀번호" required>
			</div>
			<div class="form-group row">
				<button class="btn btn-lg btn-success btn-block" type="submit">로그인</button>
				<a href="<c:url value="/signup"/>" class="btn btn-lg btn-primary btn-block">회원가입</a>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
			</div>
		</form>
	</div>
</div>