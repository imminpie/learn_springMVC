<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="utf-8" session="false"%>

<nav class="navbar navbar-expand navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="/">Home</a>
		</div>
		<div>
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="<c:url value="/books"/>">도서목록</a></li>
				<sec:authorize access="hasRole('ADMIN')">				
					<li class="nav-item">
						<a class="nav-link" href="<c:url value="/books/new"/>">도서등록</a>
					</li>
				</sec:authorize>
				<li class="nav-item">
				    <sec:authorize access="isAnonymous()">
				        <a class="nav-link" href="<c:url value="/login"/>">로그인</a>
				    </sec:authorize>
				</li>
				<li class="nav-item">
				    <sec:authorize access="isAuthenticated()">
				        <form:form action="${pageContext.request.contextPath}/logout" method="POST" style="margin-bottom: 0;">
				        	<input type="submit" class="btn btn-success" value="로그아웃"/>
				        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				        </form:form>
				    </sec:authorize>
				</li>
			</ul>
		</div>
	</div>
</nav>