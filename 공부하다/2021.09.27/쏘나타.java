package example_09_27_interface;

public class 쏘나타 extends 중형차{

	//인터페이스를 2개를 구현받고, Abstract의 구현된 것을 상속받은 중형차를 상속받음
	
	@Override
	public void 출발기능() {
		System.out.println("쏘나타의 출발기능을 실행시킵니다.");
		
	}

	@Override
	public void 정지기능() {
		System.out.println("쏘나타의 정지기능을 실행시킵니다.");

		
	}

	@Override
	public void 운전기능() {
		System.out.println("쏘나타의 운전기능을 실행시킵니다.");
		
	}

	@Override
	public void 속도변경기능() {
		System.out.println("쏘나타의 속도변경기능을 실행시킵니다.");
		
	}

	@Override
	public void 라디오기능() {
		System.out.println("쏘나타의 라디오기능을 실행시킵니다.");
		
	}

	@Override
	public void 에어컨기능() {
		System.out.println("쏘나타의 에어컨기능을 실행시킵니다.");
		
	}

	@Override
	public void 길안내기능() {
		System.out.println("쏘나타의 길안내기능을 실행시킵니다.");

		
	} 
	

}
