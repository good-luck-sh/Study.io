<%@page import="com.sample.vo.Product"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.sample.util.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 업로드된 파일이 저장되는 경로
	String saveDirectory = "D:\\Develop\\projects\\web-workspace\\web-projects\\fie-upload\\src\\main\\webapp\\resources\\images";
	
	// 멀티파트요청을 처리하는 MultipartRequest객체 생성하기
	MultipartRequest mr = new MultipartRequest(request, saveDirectory);
	
	// 요청파라미터값 조회하기
	String name = mr.getParameter("name");
	String maker = mr.getParameter("maker");
	int price = Integer.parseInt(mr.getParameter("price"));
	// 업로드된 파일이름 조회하기
	String filename1 = mr.getFilename("imagefile1");
	String filename2 = mr.getFilename("imagefile2");
	String filename3 = mr.getFilename("imagefile3");
	
	/* 
	System.out.println("상품이름: " + name);
	System.out.println("제조회사: " + maker);
	System.out.println("상품가격: " + price);
	System.out.println("파일이름1: " + filename1);
	System.out.println("파일이름2: " + filename2);
	System.out.println("파일이름3: " + filename3); 
	*/
	
	// 상품객체 생성해서 상품정보와 업로드된 파일의 파일명을 저장한다.
	Product product = new Product();
	product.setName(name);
	product.setMaker(maker);
	product.setPrice(price);
	product.setFilename(filename1);
	product.setFilename(filename2);
	product.setFilename(filename3);
	
	/*
	ProductDao productDao = new ProductDao();
	productDao.insertProduct(product);
	
	response.sendRedirect("list.jsp");
	*/	
	
%>