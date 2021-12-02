<%@ page import="org.apache.commons.lang3.math.NumberUtils"%>
<%@ page import="com.example.vo.Board"%>
<%@ page import="com.example.dao.BoardDao"%>
<%@ page import="org.apache.commons.lang3.StringUtils"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<title>샘플 게시판</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<div class="container mb-5">
		<div class="row mb-3">
			<div class="col-12">
				<h1 class="fs-3">게시글 정보</h1>
			</div>
		</div>
<%
	// 게시글아이디, 페이지번호, 검색옵션, 검색키워드를 요청파라미터에서 조회한다.
	long id = NumberUtils.toLong(request.getParameter("id"));
	int pageNo = NumberUtils.toInt(request.getParameter("page"), 1);
	String option = StringUtils.defaultString(request.getParameter("option"), "");
	String keyword = StringUtils.defaultString(request.getParameter("keyword"), "");
	
	// 게시글아이디에 해당하는 게시글 정보를 조회한다.
	Board board = BoardDao.getInstance().getBoardById(id);
	if (board == null) {
		response.sendRedirect("list.jsp?&page=" + pageNo + "&option=" + option + "&keyword=" +keyword);
		return;
	}
	// 조회수를 1증가 시킨다.
	board.setViewCount(board.getViewCount() + 1);
	board.setUpdatedDate(new java.sql.Date(new java.util.Date().getTime()));
	BoardDao.getInstance().updateBoard(board);
%>
		<div class="row mb-3">
			<div class="col">
				<table class="table table-bordered">
					<tbody>
						<tr class="d-flex">
							<td class="col-2">아이디</td>
							<td class="col-4"><%=board.getId()%></td>
							<td class="col-2">조회수</td>
							<td class="col-4"><%=board.getViewCount()%></td>
						</tr>
						<tr class="d-flex">
							<td class="col-2">제목</td>
							<td class="col-10" colspan="3"><%=board.getTitle()%></td>
						</tr>
						<tr class="d-flex">
							<td class="col-2">등록일</td>
							<td class="col-4"><%=board.getCreatedDate()%></td>
							<td class="col-2">최종 수정일</td>
							<td class="col-4"><%=board.getUpdatedDate() != null ? board.getUpdatedDate() : ""%></td>
						</tr>
						<tr class="d-flex">
							<td class="col-2">제목</td>
							<td class="col-10" colspan="3"><%=board.getContent()%></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col">
				<div class="text-end">
					<!--  
						list.jsp를 요청할 때 요청파라미터로 전달받은 페이지번호, 검색옵션, 검색키워드를 전달한다.
					-->
					<a href="list.jsp?page=<%=pageNo%>&option=<%=option%>&keyword=<%=keyword%>" class="btn btn-primary">목록</a>
				</div>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>
</html>