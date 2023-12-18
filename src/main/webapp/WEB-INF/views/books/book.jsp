<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page pageEncoding="utf-8" session="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<title>도서 상세 정보</title>
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
			<h1 class="display-3">도서 정보</h1>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<c:choose>
					<c:when test="${ book.image == null }">
						<img src="<c:url value="${ book.id }.png"/>" />
					</c:when>
					<c:otherwise>
						<img src="<c:url value="${ book.image }"/>" style="height: 310px;" />
					</c:otherwise>
				</c:choose>
			</div>
			<div class="col-md-8">
				<h3>${ book.title }</h3>
				<p>${ book.description }</p>
				<br />
				<p><b>저자</b> : ${book.author}</p>
				<p><b>출판사</b> : ${book.publisher}</p>
				<p><b>출판일</b> : ${book.releaseDate}</p>
				<p><b>분류</b> : ${book.category}</p>
				<h4>${book.price}원</h4>
				<br />
				<a href="<c:url value="/books"/>" class="btn btn-secondary">도서 목록 &raquo;</a>
				<a href="<c:url value="/books/edit/${ book.id }"/>" class="btn btn-secondary">수정 &raquo;</a>
			</div>
		</div>
	</div>
</body>
</html>