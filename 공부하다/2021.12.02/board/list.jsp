<%@ page import="org.apache.commons.lang3.math.NumberUtils"%>
<%@ page import="com.example.vo.Criteria"%>
<%@ page import="java.util.List"%>
<%@ page import="com.example.vo.Board"%>
<%@ page import="com.example.dao.BoardDao"%>
<%@ page import="org.apache.commons.lang3.StringUtils"%>
<%@ page import="com.example.vo.Pagination"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
		<div class="row">
			<div class="col-12">
				<h1 class="fs-3">게시글 목록</h1>
			</div>
		</div>
<%
	// 페이지번호, 검색옵션, 검색키워드를 요청파라미터에서 조회한다.
    int pageNo = NumberUtils.toInt(request.getParameter("page"), 1);
    String option = StringUtils.defaultString(request.getParameter("option"), "");
    String keyword = StringUtils.defaultString(request.getParameter("keyword"), "");

    // 검색조건을 저장하는 Criteria 객체를 생성한다.
    Criteria criteria = new Criteria();
    // 검색옵션과 검색키워드가 모두 있는 경우에만 Criteria객체에 검색옵션과 검색 키워드를 저장한다.
    if (!StringUtils.isEmpty(option) && !StringUtils.isEmpty(keyword)) {
      	criteria.setOption(option);
      	criteria.setKeyword(keyword);
    }
    // 검색조건에 맞는 게시글의 총 갯수를 조회한다.
    int totalRows = BoardDao.getInstance().getTotalRows(criteria);
    // 페이징처리에 필요한 정보를 제공하는 Pagination객체를 생성한다.
    Pagination pagination = new Pagination(pageNo, totalRows);
    
    // 게시글 리스틀 조회할 때 필요한 조회범위를 Criteria객체에 저장한다.
    criteria.setBeginIndex(pagination.getBeginIndex());
    criteria.setEndIndex(pagination.getEndIndex());
	
    // 검색조건에 맞는 게시글 목록을 조회한다.
    List<Board> boardList = BoardDao.getInstance().getBoardList(criteria);
%>
		<div class="row">
			<div class="col">
				<table class="table">
					<thead>
						<tr class="d-flex">
							<th class="col-1">아이디</th>
							<th class="col-6">제목</th>
							<th class="col-2">작성자</th>
							<th class="col-1">조회수</th>
							<th class="col-2">등록일</th>
						</tr>
					</thead>
					<tbody>
<%
	if (boardList.isEmpty()) {
%>
						<tr>
							<td colspan="5" class="text-center">게시글이 존재하지 않습니다.</td>
						</tr>
						<%
	} else {
		for (Board board : boardList) {
%>
						<tr class="d-flex">
							<td class="col-1"><%=board.getId()%></td>
							<td class="col-6"><a href="detail.jsp?id=<%=board.getId()%>&page=<%=pageNo%>&option=<%=option%>&keyword=<%=keyword%>"><%=board.getTitle()%></a></td>
							<td class="col-2"><%=board.getWriter()%></td>
							<td class="col-1"><%=board.getViewCount()%></td>
							<td class="col-2"><%=board.getCreatedDate()%></td>
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
			<div class="col">
				<ul class="pagination justify-content-center">
					<li class="page-item <%=pagination.isExistPrev() ? "" : "disabled"%>">
						<a href="" class="page-link" onclick="moveToPage(event, <%=pagination.getPrev()%>)" >이전</a>
					</li>
<%
	// Pagination객체는 시작페이지번호와 끝 페이지번호를 제공한다.
	// 해당 범위의 페이지를 화면에 표시하다.
	for (int num = pagination.getBegin(); num <= pagination.getEnd(); num++) {
%>
					<li class="page-item <%=num == pagination.getPage() ? "active" : ""%>">
						<a href="" class="page-link" onclick="moveToPage(event, <%=num%>)"><%=num%></a>
					</li>
<%
	}
%>
					<li class="page-item <%=pagination.isExistNext() ? "" : "disabled"%>">
						<a href="" class="page-link" onclick="moveToPage(event, <%=pagination.getNext()%>)">다음</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col">
				<!--  
					페이징처리와 검색에 필요한 값을 서버로 제출할 때 사용하는 폼이다.
					페이지번호를 클릭하거나 검색버튼을 클릭하면 폼의 입력요소에 적절한 값을 설정하고, 폼 입력값을 제출한다.
					
					검색옵션과 검색어가 존재하면 해당 해당 옵션이 선택되고, 검색어가 입력필드에 표시된다.
				-->
				<form id="form-search" class="row row-cols-lg-auto g-3" method="get" action="list.jsp">
					<input type="hidden" id="page-field" name="page" value="<%=pageNo%>">
					<div class="col-2 offset-3">
						<div class="input-group">
							<select class="form-select" id="search-option" name="option">
								<option value="title" <%="title".equals(option) ? "selected" : ""%>>제목</option>
								<option value="writer" <%="writer".equals(option) ? "selected" : ""%>>작성자</option>
								<option value="content" <%="content".equals(option) ? "selected" : ""%>>내용</option>
							</select>
						</div>
					</div>
					<div class="col-3">
						<div class="input-group">
							<input type="text" class="form-control" id="search-keyword" name="keyword" value="<%=StringUtils.isBlank(keyword) ? "" : keyword%>"	placeholder="검색어를 입력하세요">
						</div>
					</div>
					<div class="col-2">
						<div class="input-group">
							<button class="btn btn-primary" type="button" id="btn-search" onclick="searchBoards(1)">검색</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		//페이지번호를 클릭했을 때 실행되는 함수
		function moveToPage(event, page) {
			event.preventDefault();	// a태그에서 onclick이벤트가 발생하면 href에 정의된 주소로 이동하는 기본동작이 일어나지 않게 함.
			searchBoards(page);
		}
		
		//검색버튼을 클릭했을 때 실행되는 함수
		function searchBoards(page) {
			document.getElementById("page-field").value = page;
			var form = document.getElementById("form-search");
			form.submit();
		}  
	</script>
</body>
</html>