<%@ page import="com.example.vo.Board"%>
<%@ page import="com.example.dao.BoardDao"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	Board board = new Board();
	board.setTitle(title);
	board.setWriter(writer);
	board.setContent(content);
	
	BoardDao.getInstance().insertBoard(board);
	
	response.sendRedirect("list.jsp");
%>
