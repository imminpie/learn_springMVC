<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s"%>
<%@ page pageEncoding="utf-8"%>
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">관리자 페이지</h1>
	</div>
</div>
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>사용자</th>
				<th>권한</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${ users }">
				<tr>
					<td>${ user.email }</td>
					<td>
        			<c:forEach var="authority" items="${ user.authorities }">${ authority.authority } </c:forEach>
    			</td>
    			<td>
    				<c:url var="changeRoleUrl" value="/admin/role/${ user.id }" />
    				<a href="${ changeRoleUrl }/admin" class="btn <c:if test="${ user.hasRole('ADMIN') }">btn-primary</c:if> ">관리자</a>
      			<a href="${ changeRoleUrl }/manager" class="btn <c:if test="${ user.hasRole('MANAGER') }">btn-primary</c:if>">매니저</a>
      			<a href="${ changeRoleUrl }/user" class="btn <c:if test="${ user.hasRole('USER') }">btn-primary</c:if>">사용자</a>
    			</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>