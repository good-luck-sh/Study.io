package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.service.EmployeeService;
import com.sample.vo.Employee;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	/*
	 * http://localhost:8080/emp/list.do 요청을 처리하는 요청 핸들러 메소드다.
	 * 클래스의 경로와 메소드의 경로가 합쳐지는 것이다. 
	 * 요청핸들러 메소드가 반환하는 값은 내부이동 혹은 재요청할 URL이다. 
	 * 데이터를 보여주는 것을 재요청해야한다. 
	 * 데이터 조회하려면 업무로직으로 보여주는 EmployeeService를 자동의존성 주입을 해줘야한다. 
	 * 요청처리를 완료하면 /WEB-INF/jsp/employee/list.jsp로 내부이동시킨다.
	 */
	@RequestMapping(path = "/list.do")
	public String list(Model model) {
		//전체 직원 목록 조회
		List<Employee> employees = employeeService.getAllEmployees();
		//보여주기 위해서 list.jsp에 Model model매개변수에 담아서 전달해준다. spring이 list에 담아보낼때 ui.model에 담아서 보낸다. 
		//employee/list.jsp에서 표현할 데이터를 Model객체에 저장한다. 
		//model에 담은걸 속성에 넣는다. ui로 표현할 데이터를 객체에 저장한다. 
		model.addAttribute("employees", employees);
		return "/employee/list.jsp";
		
	}
	//나중에는 계속 늘려갈 예정이다.
	@RequestMapping(path = "/insert.do")
	public String form() {
		return "/employee/list.jsp";
		
	}
	
}
