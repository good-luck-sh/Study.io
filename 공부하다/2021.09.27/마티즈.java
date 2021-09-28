package example_09_27_interface;

public class 마티즈 implements 경차 {
	//경차를 구현한 마티즈라는 class를 정의함
	//경차라는 인터페이스를 구현받았기 때문에 기능 4가지만 구현하면 됨

	@Override
	public void 출발기능() {
	System.out.println("자동차를 출발시킵니다.");
	
	}
	@Override
	public void 정지기능() {
		System.out.println("자동차를 정지시킵니다.");

		
	}
	@Override
	public void 운전기능() {
		System.out.println("자동차를 운전시킵니다.");
		
	}
	@Override
	public void 속도변경기능() {
		System.out.println("자동차의 속도를 변경합니다.");
		
	}
}
