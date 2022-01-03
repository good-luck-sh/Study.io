package com.sample.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sample.dto.DepartmentListDto;
import com.sample.form.DepartmentInsertForm;
import com.sample.form.DepartmentModifyForm;
import com.sample.service.DepartmentService;
import com.sample.service.EmployeeService;
import com.sample.vo.Department;
import com.sample.vo.Employee;
import com.sample.vo.Location;

@Controller
@RequestMapping("/dept")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/list.do")
	public String list(Model model) {
		List<DepartmentListDto> departmentList = departmentService.getAllDepartments();
		model.addAttribute("departmentList",departmentList);
		return "dept/list.jsp";
	}
	
	@GetMapping("/insert.do")
	public String form(Model model) {
		List<Location> location = departmentService.getAllLocation();
		model.addAttribute("location",location);
		return "dept/form.jsp";
	}
	
	@PostMapping("/insert.do")
	public String insert(DepartmentInsertForm departmentInsertForm) {
		Department department = new Department();
		BeanUtils.copyProperties(departmentInsertForm, department);
		departmentService.inserDepartment(department);
		return "redirect:list.do";
	}
	
	@GetMapping("/modify.do")
	public String formForm(RedirectAttributes redirectAttributes) {
		List<Employee> employees = employeeService.getAllManagers();
		List<Location> locations = departmentService.getAllLocation();
		redirectAttributes.addAttribute("employee",employees);
		redirectAttributes.addAttribute("location",locations);
		return "dept/modifyform.jsp";
	}
	
	@PostMapping("/modify.do")
	public String modify(DepartmentModifyForm departementForm) {
		Department department = new Department();
		BeanUtils.copyProperties(departementForm, department);
		departmentService.updateDepartment(department);
		return "redirect:list.do";
	}
	
}
