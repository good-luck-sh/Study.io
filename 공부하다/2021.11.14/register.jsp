<%@page import="com.sample.dao.BoardDao"%>
<%@page import="com.sample.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String conetent = request.getParameter("content");
	
	BoardDao boardDao = new BoardDao();
	Board board = new Board();
	board.setBoradTitle(title);
	board.setBoardContent(conetent);
	board.setBoardWrite(writer);
	
	boardDao.insertBoard(board);
	
	response.sendRedirect("/sample/board/list.jsp?cpno=1");
%>