package com.sample.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.dto.DepartmentListDto;
import com.sample.vo.Department;

@Mapper
public interface DepartmentDao {

	List<DepartmentListDto> getAllDepartments();
	void insertDepartment(Department department);
	void updateDepartment(Department department);
}
