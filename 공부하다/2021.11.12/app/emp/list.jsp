
   
<%@page import="com.sample.vo.Department"%>
<%@page import="com.sample.dao.DepartmentDao"%>
<%@page import="com.sample.vo.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" type="text/css" href="../../resources/css/style.css">
<title>전체 사원 리스트 화면</title>
</head>
<body>
<% 
//	화면에 표시할 행의 갯수 
	final int ROWSPERPAGE = 10;
	//한 화면(블록)에 표시할 페이지번호 갯수 
	//페이지 퍼 블록
	final int pagesPerBlock = 5;
	//페이지 번호 조회하기 
	int currentPageNo = Integer.parseInt(request.getParameter("cpno"));
	//조회할 데이터 범위를 계산하기 
	int begin = (currentPageNo - 1)*ROWSPERPAGE + 1; 
	//currentPageNo가 1이면  row까지가 0그리고 1이 표현됨
	//currentPage가 2이면 row까지가 10이고 그리고 1이 더해져서 11이됨
	int end = currentPageNo*ROWSPERPAGE;
	DepartmentDao departmentDao = new DepartmentDao();
	EmployeeDao employeeDao = new EmployeeDao();
//	List<Employee> employees = employeeDao.getAllEmployee();
	List<Employee> employeeList = employeeDao.getCountPageEmployee(begin, end);

%>
<h2>전체 사원 리스트 화면</h2>
	<div>
		<table>
			<thead>
				<tr>
					<th>사원아이디</th>
					<th>사원 이름</th>
					<th>사원 연락처</th>
					<th>사원 이메일</th>
					<th>사원 직종명</th>
					<th>소속부서명</th>
				</tr>
			</thead>
			<tbody>
			
<%
 for(Employee employee : employeeList) {
	 Integer departmentId = employeeDao.getDepartmentIdByEmployee(employee.getId());
	 Department department = departmentDao.getDepartmentById(departmentId);
			
%>			
					<tr>
					<td><%=employee.getId() %></td>
					<td><a href="detail.jsp?empId=<%=employee.getId()%>"><%=employee.getFirstName() %><%=employee.getLastName() %></a></td>
					<td><%=employee.getPhoneNumber() %></td>
					<td><%=employee.getEmail() %></td>
					<td><%=employee.getJob().getId() %></td>
<%
			if (departmentId != 0) {
%>
					<td><a href="../dept/detail.jsp?deptId=<%=department.getId()%>"><%=department.getName() %></a></td>

<% 	
			} else {
%>
					<td>존재하지 않습니다.</td>					
<%
}
%>					
					</tr>
<%
}
%>
				
			</tbody>
		</table>
	</div>
<%
	//전체사원수 계산하기
	int totalRecord = employeeDao.getEmployeesCount();					//전체 레코드 갯수 : 107
	//전체 페이지 갯수 계산하기
	int pageCount = (int)(Math.ceil((double)totalRecord/ROWSPERPAGE));	//총 페이지 갯수 : ceil(107/rowsPerPage) =2
	//천장값 (전체의 수/10 )--네비게이션에만 사용하는 값이기 때문에 헷깔릴까봐 이렇게 작성한다. 
	//전체 블록갯수 계산하기 
	int totalBlocks = (int)(Math.ceil((double)pageCount/pagesPerBlock));	//총 블록 갯수 :ceil(22/pagesPerBlock) = 5
	
	//현재 블록 계산하기 
	int currentBlock = (int)(Math.ceil((double)currentPageNo/pagesPerBlock));	//현재 블록번호 ceil(1/pagesPerBlock) = 1
	//현재 블록의 시작페이지번호와 끝페이지 번호 계산하기
	int beginPageNo = (currentBlock - 1)*pagesPerBlock + 1;						//현재 블록의 시작페이지번호 : 1
	int endPageNo = currentBlock * pagesPerBlock;		//현재 블록의 끝 페이지 번호 : 5
	if(currentBlock == totalBlocks) {
		endPageNo = pageCount;
	}
%>	
	<div class="text-center pagination">

	<a href="list.jsp?cpno=<%=(currentBlock - 1)*pagesPerBlock %>" class="<%=currentBlock == 1 ? "disabled" :"" %>">이전</a>
	<!-- 이전의 -로 가는 방법은 나중에 자바스크립트로 처리할 예정이다. -->

<%
	for(int pno=beginPageNo; pno<=endPageNo; pno ++ ){
%>	
	<a href="list.jsp?cpno=<%=pno %>" class=<%=pno == currentPageNo ? "active" : "" %> ><%=pno %></a>
<%
	//3항 연산자를 추가해서 해당하는 페이지에 class를 입력할 수 있다. 
	}
%>	
	<a href="list.jsp?cpno=<%=currentBlock*pagesPerBlock + 1 %>" class="<%=currentBlock == totalBlocks ? "disabled" :""%>">다음</a>
	</div>
</body>
</html>