<%@page import="com.sample.dao.EmployeeDao"%>
<%@page import="com.sample.vo.Location"%>
<%@page import="com.sample.vo.Employee"%>
<%@page import="com.sample.vo.Department"%>
<%@page import="com.sample.dao.DepartmentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
	modifyform.jsp에서 수정폼의 값을 제출하면 update.jsp가 실행된다. 
	update.jsp에는 id=부서아이디&name=부서이름&managerId=부서관리자아이디&locationId=부서소재자아이디
					id=부서아이디&name=부서이름&locationId=부서소재자아이디
					
	매니저의 아이디가 null이면 에러가 나기 때문에, null인 경우를 입력해주어야한다.
	숫자에 대한 에러가 발생한다.
	대처방법 1. manager1을 String으로 감싼다 그리고 if문으로 null로 작성한다. 
	-->매니저의 id가 0이 될 수없다.  숫자로 null이 허용된 Integer로 변경을 해준다.
*/
	int id = Integer.parseInt(request.getParameter("id"));
	String name= request.getParameter("name");
	String tempMangerId = request.getParameter("managerId");
	
	int locationId =Integer.parseInt(request.getParameter("locationId")); 
	//테이블의 값을 수정할 때는 항상 테이블에 저장된 현재값을 먼저 조회한다.
	DepartmentDao departmentDao = new DepartmentDao();
	Department department = departmentDao.getDepartmentById(id);
	//입력폼에서 제출한 현재값을 대입한다.
	department.setName(name);						//수정폼에서 입력한 부서명
	department.getLocation().setId(locationId);		//수정폼에서 입력한 부서소재지 아이디
	if(tempMangerId == null) {						
		department.getManager().setId(null);	
	} else {
		department.getManager().setId(Integer.parseInt(tempMangerId));	//수정폼에 선택한 매니저 아이디
	}
	departmentDao.updateDeparmtnet(department);
	
	response.sendRedirect("detail.jsp?deptId=" + id);

%>