package com.sample.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sample.dto.DepartmentListDto;
import com.sample.dto.EmployeeDetailDto;
import com.sample.dto.EmployeeListDto;
import com.sample.form.EmployeeInsertForm;
import com.sample.form.EmployeeModifyForm;
import com.sample.service.DepartmentService;
import com.sample.service.EmployeeService;
import com.sample.service.JobService;
import com.sample.vo.Department;
import com.sample.vo.Employee;
import com.sample.vo.Job;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	JobService jobService;
	@Autowired
	DepartmentService departmentService;

	@GetMapping("/list.do")
	public String list(Model model) {
		List<EmployeeListDto> employees= employeeService.getAllEmployees();
		model.addAttribute("employees",employees);
		return "emp/list.jsp";
	}
	
	@GetMapping("/insert.do")
	public String form(RedirectAttributes ra) {
		List<DepartmentListDto> departments = departmentService.getAllDepartments();
		List<Job> jobs = jobService.getAllJobs();
		List<Employee> managers = employeeService.getAllManagers();
		ra.addAttribute("department", departments);
		ra.addAttribute("job", jobs);
		ra.addAttribute("manager", managers);
		return "emp/form.jsp";
	}
	
	@PostMapping("/insert.do")
	public String insert(EmployeeInsertForm employeeform) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeform, employee);
		employeeService.inserEmployee(employee);
		return "redirect:list.do";
	}
	
	@GetMapping("/detail.do")
	public String detail(int no,Model model) {
		EmployeeDetailDto employee = employeeService.getEmployeeById(no);
		model.addAttribute("employee", employee);
		return "emp/detail.jsp";
	}
	
	@GetMapping("/modify.do")
	public String modifyform(int no, RedirectAttributes ra) {
		EmployeeDetailDto employee = employeeService.getEmployeeById(no);
		List<DepartmentListDto> departments = departmentService.getAllDepartments();
		List<Job> jobs = jobService.getAllJobs();
		ra.addAttribute("department", departments);
		ra.addAttribute("job", jobs);
		ra.addAttribute("employee", employee);
		return "emp/modifyform.jsp";
	}
	
	@PostMapping("/modify.do")
	public String modify(int no, EmployeeModifyForm employeeForm) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeForm, employee);
		employeeService.updateEmployee(employee);
		return "redirect:detail.do?id=" + no;
	}
	
}
