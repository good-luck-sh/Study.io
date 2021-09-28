package example_09_27_inner_class;

public class Outer2 {

	private int x;
	private static int y; 
	public void m1() {
		System.out.println("멤버 메소드");
	}
	public static void m2() {
		System.out.println("정적 메소드");
	}
	//정적 내부 클래스 
	//외부에서 내부를 사용하는 경우가 많음, 내부에서 외부의 것을 사용하는 경우는 적음
	//정적 내부클래스의 경우는 별다른 제약없이 정적변수도 선언이 가능하며, 정적메소드도 작성할 수 있다. 
	//static이기 때문에 static에만 접근이 가능하다. 
	static class Inner1 {
		private int a; 
		private static int b; 
		public void m3() {
			System.out.println("정적 내부 클래스의 멤버변수 ");
			/*
			 * 외부클래스의 멤버메소드를 사용할 수 없다. 
			 * 멤버메소드의 경우 객체를 만들고 사용할 수 있기 때문에 사용할 수 없다. 
			System.out.println(x);
			*/
			
			System.out.println(Outer2.y);
			/*
			 * 외부클래스의 멤버메소드를 사용할 수 없다. 
			m1();
			*/
			Outer2.m2();
			System.out.println(a);
			System.out.println(Inner1.b);
			Inner1.m4();
		}
		public static void m4() {
			System.out.println("정적 내부 클래스의 정적 메소드");
		}
	}
}
