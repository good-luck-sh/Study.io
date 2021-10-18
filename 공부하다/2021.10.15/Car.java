package example_10_15_object;

import java.io.Serializable;

public class Car implements Serializable {


	private static final long serialVersionUID = 2034123329551617274L;
	
	
	private String name; 
	private String company; 
	private long price; 
	
	public Car() {}
	public Car(String name, String company, long price) { 
		this.name = name; 
		this.company = company;
		this.price = price; 
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
}
