package com.sample.vo;

public class Job {

	private String id;
	private String title;
	private int minSalary;
	private int maxSalaty;
	
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

	public int getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}

	public int getMaxSalaty() {
		return maxSalaty;
	}

	public void setMaxSalaty(int maxSalaty) {
		this.maxSalaty = maxSalaty;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", minSalary=" + minSalary + ", maxSalaty=" + maxSalaty + "]";
	}
	
	
}
