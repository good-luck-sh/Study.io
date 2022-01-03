package com.sample.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.dto.EmployeeDetailDto;
import com.sample.dto.EmployeeListDto;
import com.sample.vo.Employee;

@Mapper
public interface EmployeeDao {

	List<EmployeeListDto> getAllEmployees();
	List<Employee> getAllManagers();
	void insertEmployee(Employee employee);
	void updateEmployee(Employee employee);
	EmployeeDetailDto getEmployeeById(int id);
}
