<%@page import="java.util.List"%>
<%@page import="com.sample.dao.DepartmentDao"%>
<%@page import="com.sample.vo.Department"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 정보 관리 :: 부서목록</title>
<!-- 
	<link> 태그는 스타일시트 파일을 이 페이지와 연결할 때 사용하는 태그다. 
	rel 속성은 <link> 태그로 연결하는 문서가 어떤 문서파일인지를 지정할 떄 사용한다. 
	type 속성은 <link> 태그로 연결하는 문서의 컨텐츠 타입을 지정할 때 사용한다. 
	href 속성은 <link> 태그로 연결한 문서의 경로를 지정할 때 사용한다. 
 -->
</head>
<body>
	<h1>전체 부서 목록</h1>
<%
	//부서정보에 대한 CRUD기능이 구현된 DepartmentDao객체 생성한다.
	DepartmentDao departmentDao = new DepartmentDao();
	//전체 부서정보를 조회한다.
	List<Department> departmentList = departmentDao.getAllDepartments();

%>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>부서명</th>
				<th>부서관리자</th>
				<th>부서 소재지</th>
			</tr>
		</thead>
		<tbody>
<%
	for (Department dept : departmentList) {
%>
		<tr>
				<td><%=dept.getId() %></td>
				<!-- 
					이 링크를 클릭하면 서버에게 detail.jsp의 실행을 요청하는 요청메세지를 보낸다.
					"?deptId=부서아이디"는 detail.jsp에서 부서상세정보를 조회할 때 브라우저에서 어떤 부서를 클릭했는지 
					서버에게 알려주기 위해서 전달하는 정보다.
					항상 ?뒤에 적는다.꺼내는 것은 getParameter이다.
				 -->
				<td><a href="detail.jsp?deptId=<%=dept.getId() %>"><%=dept.getName() %></a></td>
				<td><%=dept.getManager().getFirstName() %> <%=dept.getManager().getLastName() %></td>
				<td><%=dept.getLocation().getCity() %></td>
			</tr>
<%
	}
%>			
			<%--부서를 클릭하면 부서의 상세정보가 나오게 하고싶음, 페이지를 detail.jsp로 만듦 --%>
		</tbody>
	</table>
	<div class="text-right">
		<a href="main.jsp">부서 정보 홈</a>
	</div>
</body>
</html>