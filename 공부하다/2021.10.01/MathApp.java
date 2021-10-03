package example_10_01_math;

public class MathApp {

	public static void main(String[] args) {
		
		//Math 클래스는 수학계산과 관련된 기능을 제공하는 클래스다.
		//Math 클래스의 모든 메소드는 정적 메소드다. 
		
		//난수 얻기 : double random() -->매번 새로운 값이 나타나는 , 랜던 값을 얻게 되는 숫자 
		// random()은 0.0보다 크거나 같고, 1.0보다 작은 임의의 실수를 반환한다. 
		System.out.println("### 난수 얻기 ");
		double value1 = Math.random();
		System.out.println("난수 : " + value1);
		
		// 1 ~ 100 사이의 값을 난수로 얻기 
		int value2 = (int)(Math.random()*6) + 1;
		System.out.println("주사위: " + value2);
		
		//반올림 된 값 얻기 : long round(double value)는 반올림된 값을 반환한다. 
		System.out.println("### 반올림 된 값 얻기 ");
		
		long value3 = Math.round(123.4);
		long value4 = Math.round(123.6);
		System.out.println("123.4의 반올림 된 값 : " + value3);
		System.out.println("123.6의 반올림 된 값 : " + value4);
		
		//천장값 얻기  : double ceil(double value)는 천장값을 반환한다. 
		//값이 실수값일 때 자신보다 큰 정수중에서 가장 작은 정수값을 반환한다. 
		//큰정수 4,5,6,7,8....작은정수는 4
		//반환값이 실수지만 정수로 변환하여 많이 사용한다. 
		System.out.println("### 천장값 얻기 ");
		int value5 = (int)Math.ceil(3.0);
		int value6 = (int)Math.ceil(3.3);
		int value7 = (int)Math.ceil(3.6);
		int value8 = (int)Math.ceil(3.9);
		int value9 = (int)Math.ceil(4.0);
		System.out.println("3.0의 천장값 : " + value5);		//3.0
		System.out.println("3.3의 천장값 : " + value6);		//4.0
		System.out.println("3.6의 천장값 : " + value7);		//4.0
		System.out.println("3.9의 천장값 : " + value8);		//4.0
		System.out.println("4.0의 천장값 : " + value9);		//4.0
		
		//바닥값 얻기  : double floor(double value)는 천장값을 반환한다. 
		//값이 실수값일 때 자신보다 작은 정수중에서 가장 큰 정수값을 반환한다. 
		//작은 정수 3,2,1,0,-1,-2... 큰정수 3
		//반환값이 실수지만 정수로 변환하여 많이 사용한다. 
		System.out.println("### 바닥값 얻기 ");
		int value10 = (int)Math.floor(3.0);
		int value11 = (int)Math.floor(3.3);
		int value12 = (int)Math.floor(3.6);
		int value13 = (int)Math.floor(3.9);
		int value14 = (int)Math.floor(4.0);
		System.out.println("3.0의 바닥값 : " + value10);		//3.0
		System.out.println("3.3의 바닥값 : " + value11);		//3.0
		System.out.println("3.6의 바닥값 : " + value12);		//3.0
		System.out.println("3.9의 바닥값 : " + value13);		//3.0
		System.out.println("4.0의 바닥값 : " + value14);		//4.0
	}
}
