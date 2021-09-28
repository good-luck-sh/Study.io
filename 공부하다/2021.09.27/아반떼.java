package example_09_27_interface;

public class 아반떼 implements  소형차{

	@Override
	public void 길안내기능() {
		System.out.println("아반떼의 길안내기능을 실행합니다.");

	}
	@Override
	public void 라디오기능() {
		System.out.println("아반떼의 라디오기능을 실행합니다.");
		
	}
	@Override
	public void 에어컨기능() {
		System.out.println("아반떼의 에어컨기능을 실행합니다.");
		
	}
	@Override
	public void 출발기능() {
		System.out.println("아반떼의 출발기능을 실행합니다.");
		
	}
	@Override
	public void 정지기능() {
		System.out.println("아반떼의 정지기능을 실행합니다.");

		
	}
	@Override
	public void 운전기능() {
		System.out.println("아반떼의 운전기능을 실행합니다.");
		
	}
	@Override
	public void 속도변경기능() {
		System.out.println("아반떼의 속도변경기능을 실행합니다.");
		
	}
}
