package example_10_05_3_generic_wildcard;

public class Course<T> { 	//과정을 만듦, Course에 Type이있음
	
	private String name;
	private T[] requests;
	
	public Course(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

}
