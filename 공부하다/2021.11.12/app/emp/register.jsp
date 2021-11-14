
<%@page import="com.sample.vo.Department"%>
<%@page import="com.sample.vo.Job"%>
<%@page import="com.sample.vo.Employee"%>
<%@page import="com.sample.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String email = request.getParameter("email");
	String phoneNumber = request.getParameter("phoneNumber");
	String jobId = request.getParameter("jobId");
	Double salary = Double.parseDouble(request.getParameter("salary"));
	Double commission = Double.parseDouble(request.getParameter("commission"));
	int managerId = Integer.parseInt(request.getParameter("managerId"));
	int deptId = Integer.parseInt(request.getParameter("departmentId"));
	
	Employee employee = new Employee();
	Job job = new Job();
	Department department = new Department();
	Employee manager = new Employee();
	
	employee.setFirstName(firstName);
	employee.setLastName(lastName);
	employee.setEmail(email);
	employee.setPhoneNumber(phoneNumber);
	
	job.setId(jobId);
	employee.setJob(job);
	
	employee.setSalary(salary);
	employee.setCommissionPct(commission);
	
	manager.setId(managerId);
	employee.setManager(manager);
	
	department.setId(deptId);
	employee.setDepartment(department);
	
	EmployeeDao employeeDao = new EmployeeDao();
	employeeDao.insertEmployee(employee);
	
	//전체사원 목록 제공하는 list.jsp를 재용청하게 하는 응답을 보낸다. 설정했기 때문에 1로 갈 수 있게 다시 재설정한다.
	response.sendRedirect("list.jsp?cpno=1");
%>