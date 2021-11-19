<%@page import="com.sample.board.dto.BoardListDto"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.board.vo.Pagination"%>
<%@page import="com.sample.board.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title>커뮤니티 게시판::리스트</title>
</head>
<body>
<%
	pageContext.setAttribute("menu", "board");
%>
<%@ include file="../common/navbar.jsp" %>
<div class="container">    
	<div class="row mb-3">
		<div class="col">
			<h1 class="fs-3">게시글 목록</h1>
		</div>
	</div>
<%
	//글목록 표시하는 부분
	String pageNo = request.getParameter("pageNo");
	//게시판을 누를때 pageNo가 전달되도록 작성함
	BoardDao boardDao = BoardDao.getInstance();
	int totalRecord = boardDao.getTotalRecords();
	Pagination pagination = new Pagination(pageNo, totalRecord);
	
	List<BoardListDto> boards = boardDao.getBoardList(pagination.getBegin(), pagination.getEnd());
	//pagination에서 계산해서 가져온 값을 사용한다.

%>
	<div class="row mb-3">
		<div class="col">
			<table class="table">
				<thead>
					<tr class="d-flex">
						<th class="col-1">번호</th>
						<th class="col-5">제목</th>
						<th class="col-2">작성자</th>
						<th class="col-1">추천수</th>
						<th class="col-1">조회수</th>
						<th class="col-2">등록일</th>
					</tr>
				</thead>
				<tbody>
<%
	if(boards.isEmpty()) {
%>
					<tr>
						<td class="text-center" colspan="6">게시글이 존재하지 않습니다.</td>
					</tr>
<%
	} else {
		for(BoardListDto dto : boards) {
%>
					<tr class="d-flex">
						<td class="col-1"><%=dto.getNo() %></td>
						<td class="col-5"><a href = "detail.jsp?no=<%=dto.getNo() %>&pageNo=<%=pagination.getCurrentPageNo() %>"><%=dto.getTitle() %></a></td>
						<td class="col-2"><%=dto.getWriter() %></td>
						<td class="col-1"><%=dto.getViewCount() %></td>
						<td class="col-1"><%=dto.getLikeCount() %></td>
						<td class="col-2"><%=dto.getCreatedDate() %></td>
					</tr>
<% 
		}
	}
%>
				</tbody>				
			</table>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-6 offset-3">
			<nav>
				<ul class="pagination justify-content-center">
					<li class="page-item disabled"><a class="page-link">이전</a></li>
					<li class="page-item active"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">다음</a></li>
				</ul>
			</nav>
		</div>
		<div class="col-3 text-end">
<%
	if(loginUserInfo != null) { 
%>
			<a href="form.jsp" class="btn btn-outline-primary">새 글</a>
<%
	}
%>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>