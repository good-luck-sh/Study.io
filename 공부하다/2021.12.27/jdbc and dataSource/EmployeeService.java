package com.sample.service;

import java.util.List;

import com.sample.vo.Employee;

public interface EmployeeService {
	
	/**
	 * 새 직원정보 등록서비스를 제공한다.
	 * @param employee 새 직원 정보를 포함하고 있는 Employee객체
	 */
	void addNewEmployee(Employee employee);
	
	/**
	 * 모든 직원 정보를 반환하는 서비스를 제공한다. 
	 * @return 모든 직원정보
	 */
	List<Employee> getAllEmployees();
}
