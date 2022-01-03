package com.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.DepartmentDao;
import com.sample.dao.LocationDao;
import com.sample.dto.DepartmentListDto;
import com.sample.vo.Department;
import com.sample.vo.Location;

@Service
public class DepartmentService {

	@Autowired
	DepartmentDao departmentDao;
	@Autowired
	LocationDao locationDao;
	
	public List<DepartmentListDto> getAllDepartments() {
		List<DepartmentListDto> departmentList = departmentDao.getAllDepartments();
		return departmentList;
	}
	
	public void inserDepartment(Department department) {
		if(department.getName()==null) {
			System.out.println("부서명을 입력하세요 ");
			return; 
		}
		departmentDao.insertDepartment(department);
	}
	
	public void updateDepartment(Department department) {
		departmentDao.updateDepartment(department);
	}
	
	public List<Location> getAllLocation(){
		List<Location> locationList = locationDao.getAllLocations();
		return locationList;
	}
}
