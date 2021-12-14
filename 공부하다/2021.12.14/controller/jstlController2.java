package kr.co.jhta.jstl.controller;

import com.sample.model2.controller.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class jstlController2 implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("student1", new Student("홍길동", 80, 40, 30));
		request.setAttribute("student2", new Student("김유신", 80, 70, 80));
		request.setAttribute("student3", new Student("강감찬", 100, 90, 100));
		
		request.getRequestDispatcher("/WEB-INF/views/jstl/sample2.jsp").forward(request, response);
		
	}
	
	public class Student {
		String name;
		int kor;
		int eng;
		int math;
		
		public Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
			
		}

		public String getName() {
			return name;
		}

		public int getKor() {
			return kor;
		}

		public int getEng() {
			return eng;
		}

		public int getMath() {
			return math;
		}
		public int getTotal( ) {
			return kor + eng + math;
		}
		public int getAverage() {
			return getTotal()/3;
		}
		public boolean isPassed() {
			return getAverage() >= 60;
		}
	}
}
