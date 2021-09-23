package example_09_23_interface;

/**
 * Sonata는 Car 인터페이스의 모든 기능을 구현하는 구현 클래스다.<br>
 * Sonata는 Car에 정의된 구현부가 없는 메소드를 전부 재정의해야한다. 
 *
 * @author 김승희
 *
 */
public class Sonata implements Car{

	private int speed;//매개변수 입력됨.
	
	@Override
	public void start() {
		System.out.println("소나타를 출발시킨다. ");
		speed = 10;
	}

	@Override
	public void stop() {
		System.out.println("소나타를 정지시킨다. ");
		speed = 0;
	}

	@Override
	public void speedUp() {

		System.out.println("소나타의 속도를 높힌다.");
		speed += 5;
		if(speed>Car.MAX_SPEED) {//200이상 속도를 높일 수 없음
				speed = Car.MAX_SPEED;
		}
		
	}

	@Override
	public void speedDown() {
		System.out.println("소나타의 속도를 낮춘다. ");
		speed -= 5;
		if(speed < Car.MIN_SPEED) {//0 미만의 속도는 존재하지 않는다.
			speed = Car.MIN_SPEED;
		}
	}

	@Override
	public int getCurrentSpeed() {
		System.out.println("소나타의 현재 속도를 반환한다. ");
		return speed;
	}// 구현부가 없는 메소드를 전부재정의하지 않으면 빨간줄이감. 컴파일 오류
	
	

}
