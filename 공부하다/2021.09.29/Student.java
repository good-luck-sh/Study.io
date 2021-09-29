package example_09_29_object;

public class Student {
	//Student getter/setter , 기본생성자, 매개변수 생성자를 입력한 클래스를 작성함

	private int no; 		//학번
	private String name; 	//이름
	private String dept;	//학과
	private int grade; 		//학년
	 
	public Student() {}

	public Student(int no, String name, String dept, int grade) {
		super();
		this.no = no;
		this.name = name;
		this.dept = dept;
		this.grade = grade;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	// Student객체에 대한 동등성 비교가 가능하도록 hashCode()와 equals(object o) 재정의하기
	// Student객체에서는 학번이 같으면 같은 학생이기 때문에 학번이 같으면 같은 객체로 판단하게 할 것이다. 
	
	//학번이 같으면 해시코드값도 같은 값을 반환하도록 재정의하기
	@Override
	public int hashCode() {
		//해시코드가 같으면 no를 반환한다. 
		return no;
	}
	
	// 학번이 같면 true값으로 반환하도록 재정의하기
	@Override
	public boolean equals(Object obj) {//다른 학번의 객체가 오는 것 
		//비교할 다른 객체가 null이면 false를 반환한다. 
		if(obj == null) {
			return false;
		}
		//비교할 다른 객체가 Student설계도로 만들어진 객체가 아니면 false를 반환한다. 
		if(!(obj instanceof Student)) { //반대로(obj가 Student의 객체가 맞다면) //아니라면
			return false;//실패
		}
		//비교할 다른 객체가 Student설계도로 만들어진 객체로 판정이 났기 때문에 Student타입으로 형변환 한다. 
		//obj를 Student로 형변환하여 Student타입의 otherStudent 참조변수에 입력한다
		Student otherStudent =(Student)obj;//여기까지 진행되면 student의 객체이다.
		//이 객체의 학번과 다른 학생의 학번이 서로 다르면 false를 반환한다. 
		if(this.no != otherStudent.no) {
			return false;
		}
		//위의 모든 조건이 통과했다면 이 객체와 비교할 다른 객체는 같은 학번을 가진 객체다.
		return true;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student [no=" +no+" , name = "+name+",dept ="+dept+",grade ="+grade+"]";
		//toString()메소드를 임의의 문자열로 재정의 함 
	}
		
	}

