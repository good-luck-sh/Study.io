package kr.co.jhta.jstl.controller;

import java.util.List;

import com.sample.model2.controller.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JstlController3 implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Employee> employeeList = List.of(new Employee(101,"홍길동",10, "대리", 300),
				new Employee(158,"김유신",10, "사원", 280),
				new Employee(120,"강감찬",10, "과장", 400),
				new Employee(40,"이순신",20, "과장", 420),
				new Employee(90,"윤봉길",20, "차장", 500),
				new Employee(210,"류관순",20, "부장", 700),
				new Employee(113,"안창호",30, "과장", 480),
				new Employee(60,"이봉창",30, "대리", 350));
		
		List<Department> departmentList = List.of(new Department(10,"영업1팀"), 
				new Department(20,"영업2팀"), 
				new Department(30,"영업3팀"));
		
		request.setAttribute("employees", employeeList);
		request.setAttribute("departments", departmentList);
		
		Pagination pagination = new Pagination(2, 1, 5);
		request.setAttribute("pagination", pagination);
		
		request.getRequestDispatcher("/WEB-INF/views/jstl/sample3.jsp").forward(request, response);
		
	}
	
	public class Pagination {
		int pageNo;
		int beginPage;
		int endPage;
		
		public Pagination(int pageNo, int beginPage, int endPage) {
			this.pageNo = pageNo;
			this.beginPage = beginPage;
			this.endPage = endPage;
		}

		public int getPageNo() {
			return pageNo;
		}

		public int getBeginPage() {
			return beginPage;
		}

		public int getEndPage() {
			return endPage;
		}
		
	}
	
	public class Department {
		int no;
		String name;
		
		public Department(int no, String name) {
			this.no = no;
			this.name = name;
		}

		public int getNo() {
			return no;
		}

		public String getName() {
			return name;
		}
		
	}
	
	public class Employee {
		int no; 
		String name;
		int deptNo;
		String position;
		int salary;
		
		public Employee(int no, String name, int deptNo, String position, int salary) {
			this.no = no;
			this.name = name;
			this.deptNo = deptNo;
			this.position = position;
			this.salary = salary;
		}

		public int getNo() {
			return no;
		}

		public String getName() {
			return name;
		}

		public int getDeptNo() {
			return deptNo;
		}

		public String getPosition() {
			return position;
		}

		public int getSalary() {
			return salary;
		}
		
		
	}
}
