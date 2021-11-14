<%@page import="com.sample.dao.BoardDao"%>
<%@page import="com.sample.vo.Board"%>
<%@page import="com.sample.dao.BoardReplyDao"%>
<%@page import="com.sample.vo.BoardReply"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int boardNo = Integer.parseInt(request.getParameter("boardNo"));
	int cpno = Integer.parseInt(request.getParameter("cpno"));
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	BoardReplyDao boardReplyDao = new BoardReplyDao();
	BoardReply boardReply = new BoardReply();
	BoardDao boardDao = new BoardDao();
	
	boardReply.setReplayWriter(writer);
	boardReply.setReplayContent(content);
	Board board = new Board();
	board.setBoardNo(boardNo);
	boardReply.setBoard(board);
	
	boardReplyDao.insertBoardReply(boardReply);
	
	response.sendRedirect("detail.jsp?no="+request.getParameter("boardNo")+"&cpno="+request.getParameter("cpno"));
	
%>