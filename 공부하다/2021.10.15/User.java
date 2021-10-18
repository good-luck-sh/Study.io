package example_10_15_object;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class User implements Serializable {//직렬화하려는 VO에 마크업인터페이스 구현해야함
	//노란줄이 생기는 이유 


	private static final long serialVersionUID = -143249601838985971L;//시리얼버젼 UID가 만들어짐
	//이 소스를 나중에 소스버젼관리 진행예정 
	
	private String id; 
	//transient 키워드는 해당 멤버변수를 직렬화 대상에서 제외시킨다. 
	private transient String password; //역직렬화에서 제외되는 키워드
	private String name; 
	private int point;
	private Car myCar; //직렬화 안된 부분
	private Date createdDate; 
	
	User() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Car getMyCar() {
		return myCar;
	}
	public void setMyCar(Car myCar) {
		this.myCar = myCar;
	}
}
