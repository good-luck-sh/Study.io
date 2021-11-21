<%@page import="com.sample.board.vo.Board"%>
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
	// include 시킨 navbar의 nav-item 중에서 페이지에 해당하는 nav-item를 active 시키기위해서 "menu"라는 이름으로 페이지이름을 속성으로 저장한다.
	// pageContext에 menu라는 이름으로 설정한 속성값은 navbar.jsp의 6번째 라인에서 조회해서 navbar의 메뉴들 중 하나를 active 시키기 위해서 읽어간다.
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
	// 요청파라미터에서 pageNo값을 조회한다.
	// 요청파라미터에 pageNo값이 존재하지 않으면 Pagination객체에서 1페이지로 설정한다.
	String pageNo = request.getParameter("pageNo");

	// 게시글 정보 관련 기능을 제공하는 BoardDao객체를 획득한다.
	BoardDao boardDao = BoardDao.getInstance();
	
	// 총 데이터 갯수를 조회한다.
	int totalRecords = boardDao.getTotalRecords();
	
	// 페이징 처리 필요한 값을 계산하는 Paginatition객체를 생성한다.
	Pagination pagination = new Pagination(pageNo, totalRecords);
	
	// 현재 페이지번호에 해당하는 게시글 목록을 조회한다.
	List<Board> boardList = boardDao.getBoardList(pagination.getBegin(), pagination.getEnd());
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
	if (boardList.isEmpty()) {
%>
					<tr>
						<td class="text-center" colspan="6">게시글이 존재하지 않습니다.</td>
					</tr>
<%
	} else {
		for (Board board : boardList) {
%>
					<tr class="d-flex">
						<td class="col-1"><%=board.getNo() %></td>
						<td class="col-5">
<%
			if ("Y".equals(board.getDeleted())) {
%>
							<span><del>삭제된 글입니다.</del></span>
<%
			} else {
%>
							<a href="detail.jsp?no=<%=board.getNo()%>&pageNo=<%=pagination.getPageNo()%>"><%=board.getTitle() %></a>
<%
			}
%>
						</td>
						<td class="col-2"><%=board.getWriter().getName() %></td>
						<td class="col-1"><%=board.getLikeCount() %></td>
						<td class="col-1"><%=board.getViewCount() %></td>
						<td class="col-2"><%=board.getCreatedDate() %></td>
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
					<!-- 
						Pagination객체가 제공하는 isExistPrev()는 이전 블록이 존재하는 경우 true를 반환한다.
						Pagination객체가 제공하는 getPrevPage()는 이전 블록의 마지막 페이지값을 반환한다.
					 -->
					<li class="page-item <%=!pagination.isExistPrev() ? "disabled" : "" %>"><a class="page-link" href="list.jsp?pageNo=<%=pagination.getPrevPage()%>" >이전</a></li>
<%
	// Pagination 객체로부터 해당 페이지 블록의 시작 페이지번호와 끝 페이지번호만큼 페이지내비게이션 정보를 표시한다.
	for (int num = pagination.getBeginPage(); num <= pagination.getEndPage(); num++) {
%>					
					<li class="page-item <%=pagination.getPageNo() == num ? "active" : "" %>"><a class="page-link" href="list.jsp?pageNo=<%=num%>"><%=num %></a></li>
<%
	}
%>					
					<!-- 
						Pagination객체가 제공하는 isExistNext()는 다음 블록이 존재하는 경우 true를 반환한다.
						Pagination객체가 제공하는 getNexPage()는 다음 블록의 첫 페이지값을 반환한다.
					 -->
					<li class="page-item <%=!pagination.isExistNext() ? "disabled" :"" %>"><a class="page-link" href="list.jsp?pageNo=<%=pagination.getNextPage()%>" >다음</a></li>
				</ul>
			</nav>
		</div>
		<div class="col-3 text-end">
<%
	// 로그인되지 않은 경우 새 글 버튼이 출력되지않는다.
	if (loginUserInfo != null) { 
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