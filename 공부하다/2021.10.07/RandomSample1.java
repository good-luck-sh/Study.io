package example_10_07_03_Random;

import java.util.Random;

public class RandomSample1 {

	public static void main(String[] args) {
		//좀 더 편리한 방법으로 난수를 발생시킬 수 있는 Random 객체를 사용함
		//자연수 범위에서 난수를 발생시키고 싶을 때에는 Random객체가 더 편함
		System.out.println("### Math.random() 사용해보기");
		// Math.random()			 0.0 <= 값의 범위 < 1.0
		for(int i = 1; i <= 5; i++) {
			double randomNumber = Math.random();
			System.out.println(randomNumber);
		}
		
		Random random = new Random();
		System.out.println("### Random객체의 nextDouble()사용해보기");
		// Random.nextDouble() 		 0.0 <= 값의 범위 < 1.0
		for(int i = 1; i <= 5; i++) {
			double randomNumber = random.nextDouble();
			System.out.println(randomNumber);
		}
		System.out.println("### Random객체의 nextInt()사용해보기");
		//Random.nextInt()		int의 최소값 <= 값의 범위<= int의 최대값
		for(int i = 1; i <= 5; i++) {
			int randomNumber = random.nextInt();
			System.out.println(randomNumber);
		}
		System.out.println("### Random객체의 nextInt(int bound)사용해보기");
		//Random.nextInt()		0 <= 값의 범위<= bound					bound=6 	0,1,2,3,4,5
		//Random.nextInt()		0 + 1 <= 값의 범위<= bound + 1 //값을 조절할 때 bound=6 1,2,3,4,5,6
		for(int i = 1; i <= 20; i++) {
			int randomNumber = random.nextInt(6) + 1;//0 ~ 9사이 값이 출력됨 +1을 하면 1~10사이의 값이 출력됨
			System.out.print(randomNumber);
		}
		
	}
}
