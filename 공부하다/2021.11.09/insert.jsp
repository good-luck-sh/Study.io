<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	/**
		form.jsp의 입력폼에서 입력한 값은 등록버튼을 클릭하면 HTTP 요청메세지로 Tomcat에 전달된다. 
		Tomcat은 요청메세지정보를 저장하는 요청객체 (HttpServletRequert)를 생성한다. 
		Tomcat은 요청 메세지를 분석해서 요청헤더정보와 요청 파라미터 정보 (폼입력값, 요청처리에 필요한 값)을 요청객체에 저장한다. 
		Tomcat은 insert.jsp의 _jspService(request,response)메소드의 request매개변수에 요청객체를 전달한다. 
		
		_jspService(request,response)메소드의 수행문으로 포함되는 
		insert.jsp의 스크립틀릿에서는 request가 참조하는 요청객체에서 요청파라미터값(폼입력값, 요청처리에 필요한 값)을 조회할 수 있다. 
		
	**/
	String name = request.getParameter("name");
	String maker = request.getParameter("maker");
	int price = Integer.parseInt(request.getParameter("price"));
	int discountPrice = Integer.parseInt(request.getParameter("discountPrice"));
	int stock = Integer.parseInt(request.getParameter("stock"));
	
	System.out.println("###form.jsp가 insert.jst로 제출한 값");
	System.out.println("상품명 : " + name);
	System.out.println("제조사 : " + price);
	System.out.println("가격 : " + discountPrice);
	System.out.println("할인가격 : " + stock);
	System.out.println("입고량 : " + name);
	
	/**
		//조회된 요청파라미터 정보를 Product객체를 생성해서 저장한다. 
		Product product = new Product();
		product.setName(name);
		product.setMaker(maker);
		product.setPrice(price);
		product.setDiscountPrice(discountPrice);
		product.setStock(stock);
		
		//Product객체에 저장된 새 상품정보를 데이터베이스에 저장시킨다. 
		ProductService service = new ProductService();
		service.addNewProduct(product);
		
		//저장이 완료되면 complete.jsp를 재요청하게하는 응답을 브라우저에게 보낸다.
	**/
		response.sendRedirect("complete.jsp");
	
%>
