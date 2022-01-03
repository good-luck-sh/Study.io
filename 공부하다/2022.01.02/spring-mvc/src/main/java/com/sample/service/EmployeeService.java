package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.EmployeeDao;
import com.sample.dto.EmployeeDetailDto;
import com.sample.dto.EmployeeListDto;
import com.sample.vo.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	public List<EmployeeListDto> getAllEmployees(){
		List<EmployeeListDto> employeeDtoList = employeeDao.getAllEmployees();
		return employeeDtoList;
	}
	public List<Employee> getAllManagers(){
		List<Employee> employeeManagerList = employeeDao.getAllManagers();
		return employeeManagerList;
	}
	public void inserEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}
	public EmployeeDetailDto getEmployeeById(int id) {
		EmployeeDetailDto employeeDetailDto = employeeDao.getEmployeeById(id);
		return employeeDetailDto;
	}
}
