package example_09_24_abstractReplay;

/*
 * 만약 Phone을 그대로 implements를 받게 되면 전체적으로 기능을 구현해야함, 부담이 너무 큼
 * Iphone
 * 	구현클래스다. 
 * 	추상클래스인 AbstractPhone클래스를 상속받았다. 
 * 	Iphone이 Phone인터페이스 대신 AbstractPhone 추상클래스를 상속받았기 때문에 
 * 	추상클래스에서 구현하지 않은 on()메소드만 구현하면 된다. 
 */
public class Iphone extends AbstractSmartPhone{ 
	private String userId;
	
	public Iphone() {
		
	}
	public Iphone(String tel, String ip,String userId) {
		//AbstractPhone의 매개변수 있는 생성자를 호출하는 수행문
		super(tel,ip);
		this.userId = userId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public void on() {
		System.out.println("얼굴인식으로 화면을 켭니다.");
		
	}
	@Override
	public void game() {
		System.out.println("애플 아케이드 게임을 플레이한다. ");
		
	}
	
	//기능을 키게 되면 on에 대한 기능만 구현하도록 나와있음 
	//추상클래스는 구현부가 없어도 아무런 상관이 없음.
	//iphone은 on이라는 구현메소드를 전부 구현해주어야 완벽한 클래스로 완성이된다. 

}
