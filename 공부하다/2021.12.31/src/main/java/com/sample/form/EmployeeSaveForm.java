package com.sample.form;

import com.sample.vo.Employee;

/*
 * WEB-INF/jsp/employee/form.jsp의 폼 입력값을 저장하기 위한 객체애 대한 클래스다.
 * *<form method="post" action="insert.do">
		
			<label>First Name</label>
			<input type="text" name="firstName""/>
			
			<label>Last Name</label>
			<input type="text" name="lastName" />
			
			<label>Phone Number</label>
			<input type="text" name="phoneNumber"/>
			
			<label >Email</label>
			<input type="text" name="email"/>
			
			<button type="submit">등록</button>
	</form>
	
	폼 요소의 이름과 같은 이름을 가진 멤버변수로 구성된 클래스다. 
	기본 생성자, getter/setter메소드를 포함해야 한다. 
	현재는 문자열밖에 없지만, 나중에는 int와 Data를 편하게 작성하면 된다. 나중에 문자열로 다 들어가게 된다. 
 * 
 */
public class EmployeeSaveForm {	//form입력값을 담기위해서 만든 객체 , 유효성 체크에 관련한 것이 들어간다.
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	public EmployeeSaveForm() {}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Employee toEmployee() {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setPhoneNumber(phoneNumber);
		employee.setEmail(email);
		
		return employee;
	}
	
}
