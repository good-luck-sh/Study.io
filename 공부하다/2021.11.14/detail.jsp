<%@page import="java.util.List"%>
<%@page import="com.sample.vo.Board"%>
<%@page import="com.sample.dao.BoardReplyDao"%>
<%@page import="com.sample.vo.BoardReply"%>
<%@page import="com.sample.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/style.css">
<title>게시판::상세</title>
</head>
<body>
<div id="wrapper">
	<ul class="nav">
 		<li><a class="active" href="/sample/board/list.jsp?cpno=1">홈</a></li>
 		<li><a href="/sample/board/form.jsp">새 글</a></li>
	</ul>
	<h1>게시글 상세 정보</h1>
	
	<table>
		<colgroup>
			<col width="10%">
			<col width="40%">
			<col width="10%">
			<col width="40%">
		</colgroup>
		<tbody>
			<tr>
<%
	
	int no = Integer.parseInt(request.getParameter("no"));
	System.out.println(no);
	int cpno = Integer.parseInt(request.getParameter("cpno"));
	BoardDao boardDao = new BoardDao();
	BoardReplyDao boardReplyDao = new BoardReplyDao();
	Board board = boardDao.getAllWebBoardByNo(no);

%>
				<th>글번호</th>
				<td><%=board.getBoardNo() %></td>
				<th>등록일</th>
				<td><%=board.getBoardCreatedDate() %></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><%=board.getBoradTitle() %></td>
				<th>작성자</th>
				<td><%=board.getBoardWrite() %></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=board.getBoradView() %></td>
<%
	int view = board.getBoradView() + 1;
	board.setBoradView(view);
	boardDao.updateBoard(board);
%>
				<th>추천수</th>
				<td><%=board.getBoardLike() %><a href="like.jsp?boardno=<%=no%>&cpno=<%=cpno%>" class="btn primary sm">추천</a></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><%=board.getBoardContent()%></td>
			</tr>
		</tbody>
	</table>
	
	<div class="text-right">
		<a href="" class="btn warning">수정</a>
		<a href="" class="btn danger">삭제</a>
		<a href="" class="btn primary">목록</a>
	</div>
	<div>
		<form class="well" method="post" action="reply.jsp">
			<input type="hidden" name="boardNo" value="<%=no%>"/>
			<input type="hidden" name="cpno" value="<%=cpno%>"/>
			<div class="form-group">
				<label>작성자</label>
				<input type="text" name="writer" />
			</div>
			<div class="form-group">
				<textarea rows="3" name="content"></textarea>
			</div>
			<div class="text-right">
				<button type="submit" class="btn default">등록</button>
			</div>
		</form>
		
	</div>
	<div>
		<table>
			<colgroup>
				<col width="*">
				<col width="10%">
				<col width="20%">
				<col width="9%">
			</colgroup>
			<tbody>
<%
	List<BoardReply> replys = boardReplyDao.getAllBoardReply(board.getBoardNo());
	if(replys != null) {
	for(BoardReply reply : replys) {
	
%>
				<tr>
					<td><%=reply.getReplayContent() %></td>
					<td><%=reply.getReplayWriter() %></td>
					<td><%=reply.getReplayCreatedDate() %></td>
					<td class="text-center"><a href="deleteReply.jsp?no=<%=no %>&cpno=<%=cpno %>&replyNo=<%=reply.getReplayNo() %>" class="btn danger sm">삭제</a></td>
<%
	}} else {
%>	
					<td colspan="4">작성된 댓글이 없습니다. </td>
<% 
	}
%>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>