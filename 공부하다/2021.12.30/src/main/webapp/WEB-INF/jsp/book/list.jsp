<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
   <title></title>
     <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
  	<div class="row mb-3">
  		<div class="col">
  			<h1>도서 목록</h1>
  		</div>
  	</div>
  	<div class="row mb-3">
  		<div class="col">
  			<p>최신 도서 목록을 표시합니다.</p>
  			<table class="table">
  				<thead>
  					<tr>
  						<th style="width: 10%;">순번</th>
  						<th style="width: 45%;">제목</th>
  						<th style="width: 15%;">저자</th>
  						<th style="width: 15%;" class="text-end pe-3">가격</th>
  						<th style="width: 15%;" class="text-end pe-3">할인가격</th>
  					</tr>
  				</thead>
  				<tbody>
  					<c:choose>
  						<c:when test="${empty books }">
  							<tr>
  								<td class="text-center" colspan="5">등록된 도서 정보가 없습니다.</td>
  							</tr>	
  						</c:when>
  						<c:otherwise>
  							<c:forEach var="book" items="${books }" varStatus="loop">
  								<tr>
  									<td>${loop.count }</td>
  									<td>${book.title }</td>
  									<td>${book.author }</td>
  									<td class="text-end pe-3"><fmt:formatNumber value="${book.price }" pattern="##,###"/>원</td>
  									<td class="text-end pe-3"><strong class="text-danger"><fmt:formatNumber value="${book.discountPrice }" pattern="##,###"/></strong>원</td>
  								</tr>
  							</c:forEach>
  						</c:otherwise>
  					</c:choose>
  				</tbody>
  			</table>
  		</div>
  	</div>
</div>
</body>
</html>