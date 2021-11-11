<%@page import="java.sql.JDBCType"%>
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
	String managerId = request.getParameter("managerId");
	String departmentId = request.getParameter("departmentId");
	
	EmployeeDao employeeDao = new EmployeeDao();
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
	
	
	int changeManagerId = 0;
	if(managerId == null) {
		managerId = null;
	} else {
		changeManagerId = Integer.parseInt(managerId);
	}
	
	manager.setId(changeManagerId);
	employee.setManager(manager);
	
	int changeDepartmentId = 0;
	if(departmentId == null) {
		departmentId = null;
	} else {
		changeDepartmentId = Integer.parseInt(departmentId);
	}
	department.setId(changeDepartmentId);
	employee.setDepartment(department);
	
	employeeDao.insertEmployee(employee);
	
	response.sendRedirect("list.jsp");
%>