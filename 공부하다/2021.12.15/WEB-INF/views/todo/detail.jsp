<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title>일정 상세정보</title>
</head>
<body>
<%@ include file="../common/navbar.jsp" %>
<div class="container">    
	<div class="row mb-3">
		<div class="col">
			<h1 class="fs-5 border p-3 shadow-sm">일정 상세정보</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<div class="card">
				<div class="card-header">일정 정보</div>
				<div class="card-body">
					<form method="post" action="update.hta"  novalidate>
						<input type="hidden" name="no" value="${no}">
						<input type="hidden" name="page" value="${page }">					
						<div class="mb-3">
							<label class="form-label" for="category-field">카테고리</label> 
							<select class="form-select" id="category-field" name="categoryNo">
							<c:forEach var="category" items="${category }">
								<option value="${category.no }" ${todoDto.categoryNo eq category.no  ? 'selected' : '' }>${category.name }</option>
							</c:forEach>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label" for="title-field">제목</label> 
							<input type="text" class="form-control" id="title-field" name="title" value="${todoDto.title }"/>
						</div>
						<div class="mb-3">
							<label class="form-label" for="dueDate-field">처리예정일</label> 
							<input type="date" class="form-control" id="dueDate-field" name="dueDate" value="${todoDto.dueDate }"/>
						</div><div class="mb-3">
							<label class="form-label" for="status-field">처리 상태</label> 
							<select class="form-select" id="status-field" name="statusNo">
								<c:forEach var="status" items="${status }">
								<option value="${status.no }" ${status.no eq todoDto.statusNo ? 'selected' : '' }>${status.title }</option>
								</c:forEach>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label" for="dueDate-field">내용</label> 
							<textarea class="form-control" rows="7" id="content-field" name="content" placeholder="${todoDto.content }"></textarea>
						</div>
						<div class="text-end ">
							<button type="submit" class="btn btn-warning">수정</button>
							<a href="list.hta?page=${page }" class="btn btn-primary">목록</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../common/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>