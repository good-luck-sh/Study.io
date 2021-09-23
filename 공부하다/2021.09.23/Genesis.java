package example_09_23_interface;

public class Genesis implements Car {


	private int speed;//매개변수 입력됨.
	
	@Override
	public void start() {
		System.out.println("제네시스를 출발시킨다. ");
		speed = 10;
	}

	@Override
	public void stop() {
		System.out.println("제네시스를 정지시킨다. ");
		speed = 0;
	}

	@Override
	public void speedUp() {

		System.out.println("제네시스의 속도를 높힌다.");
		speed += 10;
		if(speed>Car.MAX_SPEED) {//200이상 속도를 높일 수 없음
				speed = Car.MAX_SPEED;//스피드를 car의 최대스피드를 넘어갈 수 없구나,
				//글에 대해서 이해도가 높아지기 때문에 상수로 작성해주는 것이 좋다. 
		}
		
	}

	@Override
	public void speedDown() {
		System.out.println("제네시스의 속도를 낮춘다. ");
		speed -= 10;
		if(speed < Car.MIN_SPEED) {//0 미만의 속도는 존재하지 않는다.
			speed = Car.MIN_SPEED;
		}
	}

	@Override
	public int getCurrentSpeed() {
		System.out.println("제네시스의 현재속도를 반환한다. ");
		return speed;
	}// 구현부가 없는 메소드를 전부재정의하지 않으면 빨간줄이감. 컴파일 오류
	
	
}
