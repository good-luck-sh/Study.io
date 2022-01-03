package com.sample.vo;

public class Location {

	private int id;
	private String city;
	private String streetAddress;
	
	public Location() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + ", streetAddress=" + streetAddress + "]";
	}
	
}
