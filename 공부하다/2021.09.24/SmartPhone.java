package example_09_24_abstractReplay;

public interface SmartPhone {

	void sendEmail(String from, String to, String title, String content);//이메일보낼 수 있음
	void internet(String url); //인터넷 
	void game();//게임할수있음
	//게임제외하고 인터넷과 이메일은 동일할 것 
	// 아이폰은 앱스토워로, 구글은 안드로이드로 , 추상메소드로 나머지 정의
}
