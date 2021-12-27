package com.sample.service;

import java.util.List;

import com.sample.dao.EmployeeDao;
import com.sample.vo.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	//EmployeeServiceImpl은 EmployeeDao인터페이스를 구현한 객체가 조립되어야한다.
	private EmployeeDao employeeDao;
	
	//EmployeeDao를 구현한 객체를 전달받기 위한 setter메소드 구현
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	@Override
	public void addNewEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
