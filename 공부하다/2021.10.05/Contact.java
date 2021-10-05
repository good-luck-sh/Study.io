package example_10_05_1_generic;

public class Contact {

	private String name;
	private String tel;
	private String company;
	
	public Contact(String name, String tel, String company) {
		this.name = name;
		this.tel = tel;
		this.company = company;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTel() {
		return tel;
	}
	
	public String getCompany() {
		return company;
	}
}
