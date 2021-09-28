package example_09_28_inner_class_example;

import example_09_28_inner_class_example.Employee.EmployeeBuilder;

public class EmployeeApp {

	public static void main(String[] args) {
		/*
		 * Employee 객체는 생성자를 이용해서 생성할 수 없다.
		 * 
		 * public class Employee{
		 *  private int no;
		 *  private String name;
		 *  ....
		 *  
		 *  생성자를 이용해서 객체를 생성하지 못하게 만듦
		 * private Employee(){}
		 * private Employee(int no, String name, String dept,.....){}
		 * }
		 */
		//Employee employee = new  Employee();
		//private로 정의되어있기 때문에 오류가 발생함.
		//employee employee = new Employee(100,"홍길동","영업팀","과장","hong@gmail.com","010-1111-222","해외영업",45000000L,0L,new Date());
	
		//제일많이 사용하는 방법
		//Builder객체를 이용해서 객체를 생성하고 초기화 된 객체를 획득하기
		EmployeeBuilder builder = Employee.builder();
		//메소드 체이닝 : 체인이 연결되는 것처럼 연결해서 작성할 수 있다. 
		Employee employee = builder.no(100) //생성자를 사용할 때 보다 직관적으로 사용가능함
			.name("홍길동")
			.dept("영업1팀")
			.position("과장")
			.salary(5_000_000)
			.job("해외영업")
			.build(); //실행하게 되면 객체가 생성됨
		
		//Builder객체를 이용해서 객체를 생성하고 초기화된 객체를 획득하기
		Employee employee2 = Employee.builder()
										.no(200)
										.name("김유신")
										.dept("연구소")
										.salary(4_000_000)
										.build();
		//이렇게도 사용됨
		//생성자가 너무 많으면, Builder를 사용하도록 권장된다. 
		// 작성하기 어렵기때문에 라이브러리화되어있다. 
		//static내부클래스의 대표적인 사용방법
		
	
	
	}
}
