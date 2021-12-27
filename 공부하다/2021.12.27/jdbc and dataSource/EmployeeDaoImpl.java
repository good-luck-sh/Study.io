package com.sample.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sample.vo.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public void insert(Employee employee) {

		
	}

	@Override
	public void delete(int EmployeeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
