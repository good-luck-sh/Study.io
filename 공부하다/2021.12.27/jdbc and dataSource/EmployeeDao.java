package com.sample.dao;

import java.util.List;

import com.sample.vo.Employee;

public interface EmployeeDao {
	
	void insert(Employee employee);
	void delete(int EmployeeId);
	void update(Employee employee);
	Employee getEmployeeById(int employeeId);
	List<Employee> getAllEmployees();
	//어떤 SQL을 사용하던지 이것을 꼭 구현해야한다.
}
