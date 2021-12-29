package com.sample.vo;

public class Job {

	private String id;
	private String title;
	private int min_salary;
	private int max_salary;
	
	public Job() {}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMin_salary() {
		return min_salary;
	}

	public void setMin_salary(int min_salary) {
		this.min_salary = min_salary;
	}

	public int getMax_salary() {
		return max_salary;
	}

	public void setMax_salary(int max_salary) {
		this.max_salary = max_salary;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", min_salary=" + min_salary + ", max_salary=" + max_salary + "]";
	}
	
	
}
