package example_09_24_abstractReplay;

public class PhoneApp2 {

	//전화걸기 기능이 잘 동작하는지 테스트하는 메소드
	public static void testCall(Phone phone) {//전화가 잘되는지 테스트 하고 싶음,Phone이라는 객체를 넣어놓음
		phone.call("010-222-3333");
	}
//	//인터넷하기 기능이 잘 동작하는지 테스트하는 메소드
//	public static void testInternet(Phone phone) {
//		//인터넷이 없음 
//		if(phone instanceof SmartPhone) { //Phone에 SmartPhone의 객체가 존재하는지 확인하는 기능
//			System.out.println("전달받은 객체는 SmartPhone타입이다.");
//			((SmartPhone)phone).internet("http://www.daum.net"); //강제형변환을 시켜서 옮겨가도록 만듦
//		} else {
//			System.out.println("전달받은 객체는 SmartPhone타입이 아니다.");
//		}
//	}
	//인터넷하기 기능이 잘 동작하는지 테스트하는 메소드
	//매개변수의 타입을 SmartPhone타입으로 정의하면, SmartPhone 인터페이스를 구현한 객체만 전달받을 수 있다. 
	//즉, 인터넷 기능이 지원되지 않는 일반폰들은 이 메소드를 실행할 수도 없다. 훨씬 더 안전하다. 
	// 따라서, 위의 주석처리 된 코드처럼 instanceof연산자를 사용하거나, SmartPhone타입으로 강제형변환하는 코드도 필요없다. 
	
	public static void testInternet(SmartPhone smartPhone) {//이렇게 전달하면 더 쉬워짐 
		smartPhone.internet("http://www.daum.net");//이렇게 한줄로 작성하면 되니까, 매개변수로 정의해놓은 타입에 따라서 달라짐
	}
	
	public static void main(String[] args) {
		System.out.println("### 아이폰으로 테스트하기 ");
		Iphone iphone = new Iphone("010-1111-1111","192.168.0.1","hong");//객체를 생성한후 
		
		PhoneApp2.testCall(iphone);// 클래스메소드를 호출함
		System.out.println();
		PhoneApp2.testInternet(iphone);//전달받은 객체가 iphone이라서 true로 나옴
		System.out.println("### 일반폰으로 테스트하기 ");

		NormalPhone normal = new NormalPhone("010-3333-3233");
		PhoneApp2.testCall(normal);// 클래스메소드를 호출함
		System.out.println();
		//PhoneApp2.testInternet(normal);//normal은 할필요가 없어서 그냥 오류가 나버림,인터넷 안되는폰은 전달받을필요가 없어짐
		
	}
}
