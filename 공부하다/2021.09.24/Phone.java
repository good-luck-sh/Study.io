package example_09_24_abstractReplay;

public interface Phone {//폰이라는 인터페이스가 존재함

	void on();
	void off();
	void call(String tel); //다른폰들은 동일한 기능을 갖고 있음
	void sms(String tel, String message);//다른폰들은 동일한 기능을 갖고 있음
}
