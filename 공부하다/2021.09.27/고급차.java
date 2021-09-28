package example_09_27_interface;

public abstract class 고급차 extends Abstract주행보조편의사항 implements 차, 기본편의사항, 고급사양{
// 추상클래스를 상속받고, 인터페이스를 구현할 예정
	@Override
	public void 에어컨기능() {
		System.out.println("고급차는 풀오토 에어콘 기능을 지원합니다.");
		
	}
}
