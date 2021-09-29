package example_09_29_String;

public class StringApp1 {

	public static void main(String[] args) {
		String str = "A class implements the Cloneable interface to indicate to the Object.clone() method that it is legal for that method to make a field-for-field copy of instances of that class.";
	
		//String의 int length()는 문자열의 길이를 반환한다. 
		int len =  str.length();
		System.out.println("문자열의 총 길이 : " + len);
		//많이 사용되는 곳
		//아이디는 9글자 이상, 비번은 8글자이상, 사용자가 입력시 몇글자이상인지 확인할 때 
		//글자수를 확인해야할 때 
		//몇 글자 이상이 되면 
		
		int len1 = "A class implements the Cloneable interface to indicate to the Obje.".length();
		//""자체가 String 객체임 
		//만드는 순간 작성하지않아도 String의 객체가 만들어짐 
		//반환타입있는 경우 꼭 앞에 같은타입과 담을 참조변수를 입력하자! !
		System.out.println("문자열의 총 길이 : " + len1);
		
		//String의 boolean equals(Object str)은 String객체가 가지고 있는 문자열의 내용을 비교해서 내용이 같으면 true를 반환한다. 
		//String의 equals(Object str)은 Object클래스의 equals(Object o)를 재정의한 것이다. 
		String str1 = "홍길동";
		String str2 = "홍길동";
		String str3 = new String("홍길동");
		String str4 = new String("홍길동");
		
		System.out.println("### String 객체의 동일성을 확인해보자");
		System.out.println(str1 == str2); //객체의 동일성을 확인하는 코드다. , true의 값이 나옴
		System.out.println(str3 == str4); //객체의 동일성을 확인하는 코드다. , flase의 값이 나옴

		System.out.println("### String 객체의 동등성을 확인해보자");
		System.out.println(str1.equals(str2)); //객체의 동등성을 확인하는 코드다.true의 값이 나옴
		System.out.println(str3.equals(str4)); //객체의 동등성을 확인하는 코드다.true의 값이 나옴
		System.out.println(str1.equals(str3)); //객체의 동등성을 확인하는 코드다.true의 값이 나옴
		System.out.println(str2.equals(str4)); //객체의 동등성을 확인하는 코드다.true의 값이 나옴
	}
}
