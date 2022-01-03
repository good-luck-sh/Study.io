package com.sample.form;

public class DepartmentInsertForm {

	private String name;
	private int locationId;
	
	public DepartmentInsertForm() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "DepartmentInsertForm [name=" + name + ", locationId=" + locationId + "]";
	}
	
}
