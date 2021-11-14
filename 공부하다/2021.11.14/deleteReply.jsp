
<%@page import="com.sample.dao.BoardReplyDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	int replyNo = Integer.parseInt(request.getParameter("replyNo"));
	int cpno = Integer.parseInt(request.getParameter("cpno"));

	BoardReplyDao boardReplyDao = new BoardReplyDao();
	boardReplyDao.deleteReply(replyNo);
	response.sendRedirect("detail.jsp?no="+request.getParameter("no")+"&cpno="+request.getParameter("cpno"));

%>