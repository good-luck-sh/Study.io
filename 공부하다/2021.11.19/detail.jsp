<%@page import="com.sample.board.vo.Board"%>
<%@page import="com.sample.board.dto.BoardDetailDto"%>
<%@page import="com.sample.board.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title>커뮤니티 게시판::상세</title>
</head>
<body>
<%
	pageContext.setAttribute("menu", "board");
%>
<%@ include file="../common/navbar.jsp" %>
<div class="container">    
	<div class="row mb-3">
		<div class="col">
			<h1 class="fs-3">게시글 상세</h1>
		</div>
	</div>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	String pageNo = request.getParameter("pageNo");
	
	BoardDao boardDao = BoardDao.getInstance();
	BoardDetailDto dto = boardDao.getBoardDetail(no);
	dto.setViewCount(dto.getViewCount() + 1);
	
	Board board = new Board();
	board.setTitle(dto.getTitle());
	board.setContent(dto.getContent());
	board.setLikeCount(dto.getLikeCount());
	board.setViewCount(dto.getViewCount());
	board.setDeleted(dto.getDeleted());
	board.setDeletedDate(dto.getDeletedDate());
	board.setNo(dto.getNo());
	
	boardDao.updateBoard(board);
%>
	<div class="row mb-3">
		<div class="col">
			<table class="table">
				<tbody>
					<tr class="d-flex">
						<th class="col-2">번호</th>
						<td class="col-4"><%=dto.getNo() %></td>
						<th class="col-2">등록일</th>
						<td class="col-4"><%=dto.getCreatedDate() %></td>
					</tr>
					<tr class="d-flex">
						<th class="col-2">제목</th>
						<td class="col-4"><%=dto.getTitle() %></td>
						<th class="col-2">작성자</th>
						<td class="col-4"><%=dto.getWriterName() %></td>
					</tr>
					<tr class="d-flex">
						<th class="col-2">조회수</th>
						<td class="col-4"><%=dto.getViewCount() %></td>
						<th class="col-2">추천수</th>
						<td class="col-4"><%=dto.getLikeCount() %><buttom class="btn btn-outline-info btn-sm">보기</buttom></td>
					</tr>
					<tr class="d-flex">
						<th class="col-2">내용</th>
						<td class="col-10"><%=dto.getContent() %></td>
					</tr>
				</tbody>				
			</table>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<div class="d-flex justify-content-between">
				<div>
<%
	if(loginUserInfo != null && loginUserInfo.getNo() == dto.getWriterNo()) {
		//로그인이 null이 아니고, 로그인 유저의 번호와 작성자가 동일해야한다.
%>
					<a href="" class="btn btn-warning">수정</a>
					<a href="" class="btn btn-danger">삭제</a>
<%
	}
	if(loginUserInfo != null && loginUserInfo.getNo() != dto.getWriterNo()) {
		//로그인이 null이아니고, 로그인 유저의 번호오아 작성자의 번호가 동일하지 않아야 나온다.
%>
					<a href="" class="btn btn-success">추천</a>
<%
	}
%>
				</div>
				<a href="" class="btn btn-primary">목록</a>
			</div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>