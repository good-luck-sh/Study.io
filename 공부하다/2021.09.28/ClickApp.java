package example_09_28_anonymous;

public class ClickApp {

	public static void main(String[] args) {
		//익명클래스는 메인메소드 내부에서 작성함.
		Click homeButtonClick = new Click() {
			public void actionPerformed() {
				System.out.println("홈페이지를 표시합니다.");
			}
		};
		//Click 객체타입으로 메소드 재정의를 실행하지만, {}으로 class가 대체가 되어서 
		//이름이 없는 익명 객체 -->이름없는 설계도로 만들어짐 
		
		Click prevButtonClick = new Click() {
			public void actionPerformed() {
			System.out.println("이전페이지를 표시합니다.");	
			}
		};
		Click nextButtonClick = new Click() {
			public void actionPerformed() {
				System.out.println("다음페이지를 표시합니다.");
			}
		};
		//이런식으로 익명객체를 만들 수 있음
		//익명객체를 만들기 위한 설계도는 생성되나 우리가 직접적으로 만들지 않아서 익명파일
	}
}