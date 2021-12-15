<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title>일정 등록폼</title>
</head>
<body>
<%@ include file="../common/navbar.jsp" %>
<div class="container">    
	<div class="row mb-3">
		<div class="col">
			<h1 class="fs-5 border p-3 shadow-sm">새 일정 등록</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<div class="card">
				<div class="card-header">새 일정 등록폼</div>
				<div class="card-body">
					<p class="card-text text-muted">일정정보를 입력하고 로그인버튼을 클릭하세요</p>
					<form method="post" action="insert.hta"  novalidate>
						<div class="mb-3">
							<label class="form-label" for="category-field">카테고리</label> 
							<select class="form-select" id="category-field" name="categoryNo">
							<option value=""> 카테고리를 선택하세요</option>
							<%-- 
								1. 요청객체에 "categoryList"이름으로 저장된 속성을 조회하는 List<Category>객체를 조회한다. 
								2. <c:forEach />태그를 사용해서 조회된 카테고리정보(List<Category>)로
								<option >태그를 생성한다.
								 
								<c:forEach var="변수명" items="${요청객체에 저장된 속성을 조회하는 표현식}">
									반복해서 출력할 html 컨텐츠
								</c:forEach>
							--%> 
								<c:forEach var="category" items="${categoryList }">
									<option value="${category.no }">${category.name }</option>
								</c:forEach>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label" for="title-field">제목</label> 
							<input type="text" class="form-control" id="title-field" name="title" />
						</div>
						<div class="mb-3">
							<label class="form-label" for="dueDate-field">처리예정일</label> 
							<input type="date" class="form-control" id="dueDate-field" name="dueDate" />
						</div>
						<div class="mb-3">
							<label class="form-label" for="dueDate-field">내용</label> 
							<textarea class="form-control" rows="7" id="content-field" name="content"></textarea>
						</div>
						<div class="text-end">
							<a href="home.hta" class="btn btn-secondary">취소</a>
							<button type="submit" class="btn btn-primary">등록</button>
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