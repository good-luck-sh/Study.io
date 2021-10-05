package example_10_05_2_generic;

public class SmartPhone implements Phone{

	@Override
	public void call(String to) {
		System.out.println("스마트폰으로 전화걸기 : " + to);
		
	}
	@Override
	public void sms(String to, String message) {
		System.out.println("스마트폰으로 문자보내기 :" + to +" , " + message);
		
	}
	
	public void internet() {
		System.out.println("스마트폰으로 인터넷하기 ");
	}
}
