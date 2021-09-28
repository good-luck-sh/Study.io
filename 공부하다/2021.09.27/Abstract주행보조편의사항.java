package example_09_27_interface;

public abstract class Abstract주행보조편의사항 implements 주행보조편의사항 {
	//주행보조편의사항을 구현한 추상 클래스 , 주행보조편의사항을 전부 구현함
	@Override
	public void 차선유지기능() {
		System.out.println("주행 중 자동으로 차선을 유지시킵니다.");

	}
	@Override
	public void 자동주차기능() {
		System.out.println("주행 중 자동으로 주차시키는 기능입니다.");

		
	}
	@Override
	public void 차간거리유지기능() {
		System.out.println("주행 중 자동으로 앞차와의 간격을 유지하는 기능입니다.");
		
	}
	@Override
	public void 차선자동변경기능() {
		System.out.println("주행 중 자동으로 변경하려는 차선으로 이동합니다.");
		
	}

}
