<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 			<h1>도서 상세정보 확인하기</h1>
 		</div>
 	</div>
 	<div class="row mb-3">
 		<div class="col">
 			<table class="table" style="border: 1px solid black">
 				<tbody>
 				<tr>
						<th style="width: 10%;">최종 수정일</th>
						<td style="width: 40%;"><fmt:formatDate value="${book.updatedDate }" pattern="yyyy년 MM월 dd일 a h시 m분 s초"/></td>
						<th style="width: 10%;">등록일</th>
						<td style="width: 40%;"><fmt:formatDate value="${book.createdDate }" pattern="yyyy년 MM월 dd일 a h시 m분 s초"/></td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3">${book.title }</td>
					</tr>
					<tr>
						<th>저자</th>
						<td>${book.author }</td>
						<th>출판사</th>
						<td>${book.publisher }</td>
					</tr>
					<tr>
						<th>가격</th>
						<td><fmt:formatNumber value="${book.price }" pattern="##,###"/>원</td>
						<th>할인가격</th>
						<td><strong class="text-danger"><fmt:formatNumber value="${book.discountPrice }"  pattern="##,###"/>원</strong></td>
					</tr>
					<tr>
						<th>출판일자</th>
						<td><fmt:formatDate value="${book.pubDate }" pattern="yyyy년 MM월 dd일"/></td>
						<th>도서 재고</th>
						<td>${book.stock }</td>
					</tr>
 				</tbody>
 			</table>
 			<div class="row mb-5">
 				<div class="col d-flex justify-content-between">
	 				<div>
						<a href="modify.do?no=${book.no }" class="btn btn-warning btn-sm">수정</a>
						<a href="delete.do?no=${book.no }" class="btn btn-danger btn-sm">삭제</a>
					</div>
						<a href="list.do" class="btn btn-primary">목록</a>
 				</div>
			</div>
 		</div>
 	</div>
</div>
</body>
</html>