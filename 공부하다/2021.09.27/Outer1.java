package example_09_27_inner_class;

public class Outer1 {
	private int x;     			// 멤버변수, 인스턴스 변수, 프로퍼티
	private static int y;		// 정적변수, 클래스변수
	
	public void m1() {			//멤버메소드, 인스턴스 메소드
		System.out.println("멤버 메소드");
	}
	public static void m2() {	//정적메소드, 클래스메소드
		System.out.println("정적 메소드");
	}
	 
	//멤버내부 클래스, 인스턴스 내부 클래스
	//멤버 내부클래스는 객체를 생성하고 사용할 수 있기 때문에 객체 생성안하고 사용할 수 있는 정적인 것은 사용할 수 없다. 
	//outer가 먼저 생성된 후 inner1이 사용할 수 있음
	//객체를 만들고나서야 사용할 수 있다. 
	class Inner1 {
		private int a ;  //멤버 내부클래스의 멤버변수 , 인스턴스 변수 프로퍼티
		/*
		 *멤버 내부클래스에서는 정적변수를 선언할 수 없다.
	//	private static c; 	//오류, 멤버 내부클래스의 정적변수, 클래스 변수 
		*/
		public void m3() { //멤버 내부클래스의 멤버메소드, 인스턴스 메소드
			System.out.println(x);  //외부클래스의 멤버변수 사용가능
			System.out.println(Outer1.y); // 외부클래스의 정적변수 사용가능
			m1(); 						// 외부클래스의 멤버메소드 사용가능
			Outer1.m2();				//외부클래스의 정적메소드 사용가능
			System.out.println(a);		// 자신의 멤버변수 사용가능
			//어디까지 사용이 가능한지에 대한 문법적인 사항이 중요함 
		}
		/*  멤버 내부클래스에서는 정적메소드를 선언할 수 없다. 
		 * public static void m4 () {
		 * 정적 변수와 메소드는 객체를 생성하지 않고 사용이 가능하기 때문ㅇ
		 * 
		 * }
		 */
	}

}
