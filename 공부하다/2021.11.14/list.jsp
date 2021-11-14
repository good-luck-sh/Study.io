
<%@page import="com.sample.vo.Board"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/style.css">
<title>게시판::리스트</title>
</head>
<body>
<%
	final int boardPage = 10;
	// 게시물을 표현할 상수
	final int pagesPerBlock = 5;
	// 페이지퍼를 표시할 상수
	int currentPageNo = Integer.parseInt(request.getParameter("cpno"));
	//입력받은 홈페이지 번호 를 currentPageNo에 저장한다. 
	int begin = (currentPageNo - 1) * boardPage + 1 ;
	//시작할 페이지의 갯수를 저장할 변수 1, 11, 21씩 1로 시작될 수 있는 계산방법
	int end = currentPageNo * boardPage;
	//끝을 표시할 페이지를 저장할 변수 끝이 0으로 끝나도록 하는 계산방법
	BoardDao boardDao = new BoardDao();

 	

%>
<div id="wrapper">
	<ul class="nav">
 		<li><a class="active" href="/sample/board/list.jsp?cpno=1">홈</a></li>
 		<li><a href="/sample/board/form.jsp">새 글</a></li>
	</ul>
	
	<h1>게시판 리스트</h1>

	<table>
		<colgroup>
			<col width="10%">
			<col width="*">
			<col width="12%">
			<col width="10%">
			<col width="10%">
			<col width="15%">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>추천수</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
<%
	List<Board> getBoards = boardDao.getAllWebBoard(begin, end);
	for (Board board : getBoards) {
%>
	 		<tr>
				<td><%=board.getBoardNo() %></td>
				<td><a href="detail.jsp?no=<%=board.getBoardNo() %>&cpno=<%=currentPageNo%>"><%=board.getBoradTitle() %></a></td>
				<td><%=board.getBoardWrite() %></td>
				<td><%=board.getBoradView() %></td>
				<td><%=board.getBoardLike() %></td>
				<td><%=board.getBoardCreatedDate() %></td>
<%
	}
%>
			</tr>

		</tbody>
	</table>
	
<%
	int totalRecord = boardDao.getAllCountBoard();
	//전체 사원수를 출력하는 메소드를 실행한다. 
	int pageCount = (int)(Math.ceil((double)totalRecord/boardPage));
	//전체사원수 / 상수 표시할페이지의수를 이용하여 표시할 페이지의 천장값을 구한다. 
	int perCount = (int)(Math.ceil((double)totalRecord/pagesPerBlock));
	//전체 사원수 / 상수 표시할페이지퍼의 수를 이용하여 표시할 페이지퍼의 천장값을 구한다. 
	int currentCount = (int)(Math.ceil((double)currentPageNo/pagesPerBlock));
	//현재 있는 페이지의 페이지퍼를 나타내는 수이다.입력받은 현재페이지의번호/ 페이지퍼의 수 
	int beginPer = (currentCount - 1) * pagesPerBlock + 1;
	//시작 페이지의 퍼 계산방법
	int endPer = currentCount*pagesPerBlock;
	//끝 페이지의 퍼 계산방법
	int prePer = (currentCount - 1) * pagesPerBlock;
	//이전페이지로 가는 퍼 계산방법 
	int nextPer = currentCount*pagesPerBlock + 1;
	//다음 페이지로 가는 퍼 계산방법
	if(currentCount == perCount) {
		//만약 현재페이지와 페이지의 퍼가 동일하다면 
		endPer = pageCount;
		//끝페이지의 퍼가 페이지의 천장값으로 대입된다. 
	}

%>
	<div class="text-center pagination">
		<a href="list.jsp?cpno=<%=prePer %>" class="<%=currentCount == 1 ? "disable" : "" %>">이전</a>
<!-- 이전의 버튼을 클릭하면 전의 목록으로 간다. 그리고 3항연산자를 이용하여 현재 페이지가 1이면 disable이 발동한다. -->
<%
	for (int pno = beginPer; pno<=endPer ;pno++) {
%>
		<a href="list.jsp?cpno=<%=pno %>" class="<%=pno%>"><%=pno%></a>
		
<%
	}
%>
		<a href="list.jsp?cpno=<%=nextPer %>" class="<%=currentCount == perCount ? "disable" : ""%>">다음</a>
<!-- 다음의 버튼을 클릭하면 이후의 목록으로 간다. 3항연산자를 이용하여 현재 페이지가 페이지의천장값이면 disable이 발동한다. -->
	</div>

	<div class="text-right">
		<a href="form.jsp" class="btn primary">새 글쓰기</a>
	</div>
</div>
</body>
</html>