package com.sample.form;

public class EmployeeModifyForm {

	private int id;
	private String jobId;
	private int departmentId;
	private double salary;
	private double commissionPct;
	
	public EmployeeModifyForm() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(double commissionPct) {
		this.commissionPct = commissionPct;
	}

	@Override
	public String toString() {
		return "EmployeeModifyForm [id=" + id + ", jobId=" + jobId + ", departmentId=" + departmentId + ", salary="
				+ salary + ", commissionPct=" + commissionPct + "]";
	}
	
}
