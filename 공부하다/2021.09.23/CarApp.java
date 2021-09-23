package example_09_23_interface;

public class CarApp {

	public static void main(String[]args) {
		//구현클래스는 인터페이스의 자식이다. 
		// 인터페이스 타입의 참조변수로 자식객체를 참조할 수 있다. 
		Car car1 = new Sonata();
		Car car2 = new Genesis();
		
		car1.start();
		car1.speedUp();
		car1.speedDown();
		int carSpeed = car1.getCurrentSpeed();
		System.out.println(carSpeed);
		car1.stop();
		
		car2.start();
		car2.speedUp();
		car2.speedUp();
		car2.speedUp();
		int carSpeed2 = car2.getCurrentSpeed();
		System.out.println(carSpeed2);
		car2.stop();
	}
}
