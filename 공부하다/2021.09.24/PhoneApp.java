package example_09_24_abstractReplay;

public class PhoneApp {

	public static void main(String[] args) {
		//Iphone객체를 Iphone타입의 참조변수가 참조한다. 
		//Iphone은 구현클래스다. 
		//Iphone은 AbstractPhone에 구현된 기능 AbstractSmartPhone에 구현된 기능을 상속받았다. 
		//Iphone은 Phone인터페이스의 기능 중 AbstractPhone에서 구현하지 않는 on기능을 구현했다.. 
		//Iphone은 SmartPhone인터페이스의 기능 중 AbstractSmartPhone에서 구현하지 않은 game기능을 구현했다. 
		System.out.println("### Iphone객체를 Iphone타입의 참조변수로 참조하기 ");
		Iphone p1 = new Iphone("010-1111-1111","192.168.0.1","hong");
		p1.on();
		p1.call("010-2222-2222");
		p1.sms("010-2222-2222", "밥 먹으러 와라 ");
		p1.off();
		p1.sendEmail("hong@gmail.com", "kim@gmail.com","보고서", "연차신청 보고서 입니다.");
		p1.internet("http://google.com");
		p1.game();
		
		
		//Iphone객체를 SmartPhone타입의 참조변수가 참조한다.
		//SmartPhone은 인터페이스 타입이다. 
		//SmartPhone 인터페이스에는 sendEmail, internet, game기능이 선언되어 있다. 
		//이렇게적힌 기능만 사용할 수 있다. 물론, Object기능 +이다.
		System.out.println("### Iphone객체를 SmartPhone타입의 참조변수로 참조하기 ");
		//p2는 이 3가지의 기능밖에 사용할 수 없음
		SmartPhone p2 = new Iphone("010-1111-1111","192.168.0.1","hong");
		p2.sendEmail("hong@gmail.com", "kim@gmail.com","보고서", "연차신청 보고서 입니다.");
		p2.internet("http://google.com");
		p2.game();
		
		
		//Iphone객체를 Phone타입의 참조변수가 참조한다.
		//Phone은 인터페이스 타입이다.
		//Phone 인터페이스에는 on,off, call sms기능이 선언되어 있다. 
		System.out.println("### Iphone객체를 Phone타입의 참조변수로 참조하기 ");
		Phone p3 = new Iphone("010-1111-1111","192.168.0.1","hong");
		p3.on();
		p3.call("010-2222-2222");
		p3.sms("010-2222-2222", "밥 먹으러 와라 ");
		p3.off();
	}
}
