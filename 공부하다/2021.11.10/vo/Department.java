package com.sample.vo;

public class Department {

	private int id;
	private String name;
	private Employee manager;		//managerId에 해당하는 관리자 정보 		
	private Location location;		//location_id에 해당하는 부서소재지 정보
	
	
	public Department() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", manager=" + manager + ", location=" + location + "]";
	}
	
}
