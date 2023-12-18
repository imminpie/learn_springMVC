<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page pageEncoding="utf-8" session="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<title>도서 목록</title>
</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">Home</a>
			</div>
			<div>
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link" href="<c:url value="/books"/>">도서목록</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value="/books/new"/>">도서등록</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">도서 목록</h1>
		</div>
	</div>
	<div class="container">
		<div class="row" align="center">
			<c:forEach items="${ books }" var="book">
				<div class="col-md-4">
					<c:choose>
						<c:when test="${ book.image == null }">
							<img src="<c:url value="${ book.id }.png"/>" style="width: 100%;"/>
						</c:when>
						<c:otherwise>
							<img src="<c:url value="${ book.image }"/>" style="width: 100%;"/>
						</c:otherwise>
					</c:choose>
					<h3>${ book.title }</h3>
					<p>${ book.author }</p>
					<p>${book.publisher} | ${book.releaseDate}</p>
					<p align=left>${fn:substring(book.description, 0, 100)}...</p>
					<p><fmt:formatNumber value="${book.price}" pattern="#,###" />원</p>
					<p><a href="<c:url value="/books/book?id=${book.id}"/>" class="btn btn-Secondary" role="button">상세정보 &raquo;</a></p>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>