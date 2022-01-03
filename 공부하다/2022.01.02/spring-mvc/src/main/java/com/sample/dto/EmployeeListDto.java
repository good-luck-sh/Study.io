package com.sample.dto;

public class EmployeeListDto {

	private int id;
	private String firstName;
	private String lastName;
	private String jobId;
	private String jobTitle;
	private int departmentId;
	private String departmentName;
	
	public EmployeeListDto() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "EmployeeListDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", jobId=" + jobId
				+ ", jobTitle=" + jobTitle + ", departmentId=" + departmentId + ", departmentName=" + departmentName
				+ "]";
	}
	
	
}
