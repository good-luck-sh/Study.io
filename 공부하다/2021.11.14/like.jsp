<%@page import="com.sample.vo.Board"%>
<%@page import="com.sample.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	int boardNo = Integer.parseInt(request.getParameter("boardno"));
	int cpno = Integer.parseInt(request.getParameter("cpno"));
	
	
	BoardDao boardDao = new BoardDao();
	Board board = boardDao.getAllWebBoardByNo(boardNo);
	int likeNumber = board.getBoardLike() + 1;
	board.setBoardLike(likeNumber);
	boardDao.updateBoard(board);
	
	response.sendRedirect("detail.jsp?no="+request.getParameter("boardno")+"&cpno="+request.getParameter("cpno"));
	
%>