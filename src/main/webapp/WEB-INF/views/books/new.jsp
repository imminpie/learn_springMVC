<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="utf-8" session="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<title>도서 등록</title>
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
			<h1 class="display-3">도서 등록</h1>
		</div>
	</div>
	<div class="container">
		<form action="<c:url value="/books" />" method="post">
			<div class="form-group row">
				<label class="col-sm-2 control-label">도서명</label>
				<div class="col-sm-5">
					<input type="text" name="title" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">가격</label>
				<div class="col-sm-5">
					<input type="text" name="price" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">저자</label>
				<div class="col-sm-5">
					<input type="text" name="author" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">상세정보</label>
				<div class="col-sm-5">
					<textarea name="description" cols="50" rows="2" class="form-control" style="resize:none;"></textarea>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">출판사</label>
				<div class="col-sm-5">
					<input type="text" name="publisher" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">분야</label>
				<div class="col-sm-5">
					<input type="text" name="category" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">출판일</label>
				<div class="col-sm-5">
					<input type="text" name="releaseDate" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">상태</label>
				<div class="col-sm-5">
					<input type="radio" name="conditions" value="New"/> New
					<input type="radio" name="conditions" value="Old"/> Old
					<input type="radio" name="conditions" value="E-Book"/> E-Book
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">이미지</label>
				<div class="col-sm-5">
					<input type="text" name="image" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">등록</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>