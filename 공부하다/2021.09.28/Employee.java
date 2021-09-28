package example_09_28_inner_class_example;

import java.util.Date;

public class Employee {

	private int no; //사원정보
	private String name; //사원이름
	private String dept; //소속부서명
	private String position; //직위
	private String email; //이메일주소 
	private String tel; // 전화번호 
	private String job; //업무
	private long salary; //급여
	private long commission; // 성과급
	private Date hireDate;  //입사일

	//멤버변수의 항목이 많을 수록 생성자의 경우의 수가 많아짐, 어떤 생성자인지 파악하기 어려움
	//객체를 만들때 순서를 알기어려움
	//private 접근제한이 지정된 기본생성자
	private Employee () {
		//생성자를 은닉화로 만듦, new를 사용하지 못하게 만듦
		//Employee employee = new Employee(); //수행문을 다른 클래스에서는 실행할 수 없다.
	}
	//private 접근제한이 지정된 중복정의된 생성자
	private Employee(int no, String name, String dept, String position, String email, String tel, String job,
			long salary, long commission, Date hireDate) {
		super();
		this.no = no;
		this.name = name;
		this.dept = dept;
		this.position = position;
		this.email = email;
		this.tel = tel;
		this.job = job;
		this.salary = salary;
		this.commission = commission;
		this.hireDate = hireDate;
	}

	//빌더를 만들 예정
//	//신입사원의 생성자
//	public Employee(int no, String name, String dept, long salary, Date hireDate) {
//		super();
//		this.no = no;
//		this.name = name;
//		this.dept = dept;
//		this.salary = salary;
//		this.hireDate = hireDate;
//	}
//
//	//경력지원으로 들어온 일꾼
//	public Employee(int no, String name, String dept, String position, String job, long salary, long commission) {
//		super();
//		this.no = no;
//		this.name = name;
//		this.dept = dept;
//		this.position = position;
//		this.job = job;
//		this.salary = salary;
//		this.commission = commission;
//	}
//	//10개의 멤버변수가 들어간 생성자가 만들어 질 것
//	public Employee(int no, String name, String dept, String position, String email, String tel, String job,
//			long salary, long commission, Date hireDate) {
//		super();
//		this.no = no;
//		this.name = name;
//		this.dept = dept;
//		this.position = position;
//		this.email = email;
//		this.tel = tel;
//		this.job = job;
//		this.salary = salary;
//		this.commission = commission;
//		this.hireDate = hireDate;
//	}
//

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public long getCommission() {
		return commission;
	}

	public void setCommission(long commission) {
		this.commission = commission;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	//마지막에 입력해줌
	/**
	 * EmployeeBuilder 객체를 제공하는 정적 메소드다
	 * @return 객체
	 */
	public static EmployeeBuilder builder() { //패턴화가 되어있음
		return new EmployeeBuilder();
		//static이기 때문에 객체생성하지 않고 사용할 수 있게 됨
	}
	/**
	 * EmployeeBuilder는 Employee객체를 생성시켜주는 클래스다.
	 * @author 김승희
	 *
	 */
	//정적 내부 클래스
	static class EmployeeBuilder {
		private int no; 
		private String name; 
		private String dept; 
		private String position; 
		private String email;  
		private String tel; 
		private String job; 
		private long salary; 
		private long commission; 
		private Date hireDate;  
		
		public EmployeeBuilder() {
			//기본생성자를 만듦 
		}
		public EmployeeBuilder no(int no) {
			this.no = no;
			return this;
		}
		public EmployeeBuilder name(String name) {
			this.name = name;
			return this;
		}
		public EmployeeBuilder dept(String dept) {
			this.dept = dept;
			return this;
		}
		public EmployeeBuilder position(String position) {
			this.position = position;
			return this;
		}
		public EmployeeBuilder email(String email) {
			this.email = email;
			return this;
		}
		public EmployeeBuilder tel(String tel) {
			this.tel = tel;
			return this;
		}
		public EmployeeBuilder job(String job) {
			this.job = job;
			return this;
		}
		public EmployeeBuilder salary(long salary) {
			this.salary = salary;
			return this;
		}
		public EmployeeBuilder commission(long commission) {
			this.commission =commission;
			return this;
		}
		public EmployeeBuilder hireDate(Date hireDate) {
			this.hireDate =hireDate;
			return this;
		}
		/**
		 * Employee객체를 생성하고 입력된 값을 사용해서 초기화된 Employee객체를 반환한다.
		 * @return Employee 객체
		 */
		public Employee build() { //build라는 메소드를 이용하여 객체를 내보내줌
			Employee employee = new Employee(no,name,dept,position,email,tel,job,salary,commission,hireDate);
			return employee;
		}
		
	}

}
