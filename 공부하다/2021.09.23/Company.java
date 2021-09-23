package example_09_23_interface;

public class Company {

	//어떤게 조립되어야하는지 어뎁터를 만들어서 표시함
	//Company객체가 사용할 Reporter 구현객체를 참조하는 멤버변수 선언함
	//* Company객체는 Reporter인터페이스를 구현한 구현클래스로 만들어진 객체만 사용할 것이다.
	//* Company객체는 Reporter인터페이스를 구현한 다양한 객체를 사용할 것이다. 
	private Reporter reporter;
	
	//전달받을 setter/ getter를 입력 
	//Reporter인터페이스를 구현한 객체를 전달받는 setter메소드를 정의한다. 
	//* Reporter인터페이스를 구현한 객체만 전달받아서 멤버변수 reporter에 대입하는 setter메소드다.
	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}
	
	// 부서별 총매출액과 영업이익을 리포트로 출력하는 기능
	public void displayCompanyEarning() {
		reporter.printReport();
	}
	
	
}
