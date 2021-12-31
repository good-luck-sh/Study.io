package com.sample.dao;

import java.util.List;

import com.sample.vo.Employee;

/**
 * 사원정보 관리에 필요한 데이터베이스 엑세스 작업을 정의한 인터페이스
 * @author 김승희
 *
 */
public interface EmployeeDao {
	
	void insert(Employee employee);
	void delete(int EmployeeId);
	void update(Employee employee);
	Employee getEmployeeById(int employeeId);
	List<Employee> getAllEmployees();
	//어떤 SQL을 사용하던지 이것을 꼭 구현해야한다.
}
