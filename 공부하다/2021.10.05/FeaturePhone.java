package example_10_05_2_generic;

public class FeaturePhone implements Phone{

	@Override
	public void call(String to) {
		System.out.println("옛날 폰으로 전화걸기 : " + to);
		
	}
	@Override
	public void sms(String to, String message) {
		System.out.println("옛날폰으로 문자보내기 " + to + " ," + message);
		
	}
}
