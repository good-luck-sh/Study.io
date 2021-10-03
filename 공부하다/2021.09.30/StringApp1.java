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
		
		//String 의 boolean isEmpty()는 String객체가 빈 문자열(길이가 0인 문자열)인 경우 true를 반환한다. 
		System.out.println("### String객체의 문자열이 빈 문자열인지 확인해보자");
		str1 ="";// 빈 문자열이다. 길이가 0인 문자열이다.
		str2 =" "; // 공백문자 하나를 가지고 있는 문자열이다.빈 문자열이 아니다.
		System.out.println(str1.isEmpty()); //true
		System.out.println(str2.isEmpty()); //false

		//빈 문자열은 공백조차 글자로 인식한다
		
		//String의 boolean isBlank()는 String 객체가 빈 문자열이거나 공백만 포함하고 있는 문자열인 경우 true를 반환한다.
		//자바 11버젼부터 지원되는 API
		System.out.println(str1.isBlank()); //true
		System.out.println(str2.isBlank()); //true
		
		//String boolean contains(CharSequence str)은 String 객체가 포함하고 있는 문자열에 지정된 문자열을 포함하고 있는지 여부를 반환한다. 
		System.out.println("### String 객체의 문자열에 지정된 문자열이 있는가?");
		str1 = "서울, 부산, 광주, 경기, 인천";
		boolean result1 = str1.contains("부산");
		boolean result2 = str1.contains("울산");
		System.out.println(result1);
		System.out.println(result2);
		//contains에 부산이라는 글자가 있는지 찾는다.
		//boolean값은 if문에서 많이 사용하는 값이다. 
		
		//String String substring(int beginIndex)는 String객체가 포함하고 있는 문자열에서 지정된 시작위치부터 문자열의 끝에
		// 해당하는 문자열로 구성된 새로운 문자열을 생성해서 반환한다. //부분문자열을 생성한다는 의미이다. 
		//String String substring(int beginIndex, int endIndex)는 String 객체가 포함하고 있는 문자열에서 지정된 범위내의
		//문자열로 구성된 새로운 문자열을 생성하여 반환한다. 
		//중복정의 되어있다. 
		System.out.println("### String객체의 문자열에 대한 부분 문자열 생성하기 ");
		str1 = "abcdefghijklmn";
		System.out.println(str1.substring(3)); //defghijklmn  // beginIndex~끝까지
		System.out.println(str1.substring(3,8));//defgh			//beginIndex~endIndex-1까지
		
		

		String 주민등록번호 = "010311-1234567";
		//생일이 궁금할 떄 
		System.out.println("생일 :" + 주민등록번호.substring(2,6));
		String sex = null;
	
		//성별이 궁금할 때 
		System.out.println("성별:");
		if(주민등록번호.substring(7).equals(1)) {
			sex = "남자";
			System.out.println(sex);
		} else {
				sex = "여자";
				System.out.println(sex); }
//		main메소드외에서 진행시 -->main반환값이 void라서 출력안됨,return으로 값을 적기 
	
		//String의 String toUpperCase()와 String toLowerCase()는 
		//각각 String객체가 포함하고 있는 문자열에 대해서 대문자와 소문자로 
		//구성된 새로운 문자열을 생성하여 반환한다. 
		System.out.println("### String객체의 문자열에 대해서 대문자/소문자로만 구성된 문자열을 얻기");
		str1 = "Good Morning!";
		String result3 = str1.toUpperCase();
		String result4 = str1.toLowerCase();
		System.out.println("원래 문자열: " + str1);
		System.out.println("대문자로 구성된 새 문자열 :" + result3);
		System.out.println("소문자로 구성된 새 문자열 :" + result4);
		//str을 바꾸는 것이 아닌 대/소문자로 새롭게 만들어서 저장 후 출력하는 것임
		
		
		//repalce(CharSequence target, CharSequence replacement)는 부모이다.
		//String의 replace(String regExp, String replaceText)은 String객체가 포함하고 있는 문자열에 대해서 
		// 첫번째 표현식에 해당하는 문자들을 찾아서 두번쨰 인자에 해당하는 문자열로 대체된 새로운 문자열을 생성해서 반환한다. 
		//String regExt :원래의 표현식 , String replaceText : 변경할 문자열
		//regExt == 정규표현식(regular) 
		System.out.println("### String 객체의 문자열에 대해서 문자를 찾아서 새 문자로 구성된 문자열을 얻기");
		str1 = "나는 자바 개발자입니다. 자바프로그램을 만듭니다. ";
		result3 = str1.replace("자바","python");
		System.out.println( "원본 문자열 :"+ str1);
		System.out.println( "원본 문자열 :"+ result3);
		//항상 새로운 것을 만드는 것이지, 값을 변경하는 것이 아니다.
		//문자열은 불변객체이다. 참고해서 새롭게 만드는 것이다. 
		
		//String의 boolean startsWith(String prefix)와 boolean endsWith(String suffix)는 각각
		//String 객체가 포함하고 있는 문자열이 특정 글자로 시작되는지, 특정 글자로 끝나는지 여부를 반환한다. 
		System.out.println("### String객체의 문자열에 대해서 특정문자로 시작하는지, 특정 문자로 끝나는지를 확인해보자");
		str1 = "http://www.daum.net";
		str2 = "www.naver.com";
		str3 = "google.com"; //문자열이 존재함 
		System.out.println(str1.startsWith("http://")); //true
		System.out.println(str2.startsWith("http://")); //false
		System.out.println(str3.startsWith("http://")); //false
		System.out.println(str1.endsWith("com")); //true
		System.out.println(str2.endsWith("com")); //true
		System.out.println(str3.endsWith("com")); //true
		//이력서를 받는 사이트를 만들경우 word파일이면, 아래한글의 확장자일 경우 알아낼 수 있다. 
		//url의 경우 http://는 외부 Url , 프로젝트Url인지 확인시 사용할 수 있다. 
		//boolean값을 반환한다. 
		
		//String의 int indexOf(String text)와 int lastIndexOf(String text)는 문자열 객체가 포함하고 있는
		//문자열에서 지정된 문자열이 처음으로 등장하는 위치와 마지막으로 등장하는 위치를 반환한다. 
		//지정된 문자열이 존재하지 않으면 -1을 반환한다. 
		System.out.println("### String객체의 문자열에 대해서 특정 문자열이 어느 위치에 있는지 확인하기");
		 String[] phones = {"02)123-4567","051)345-907","031)0980-1234"};
		 //전화번호가 이렇게 존재함
		 //지역번호만 알고 싶음 1번은 2개 2번은 3개 3번도 3개 필요함
		 //섞여있어서 몇개인지 확인할 수 없음 
		 //)까지의 문자열을 가져오면 됨
		 
		 for(String phone : phones) {
			 System.out.println(phone+","+phone.indexOf(")"));
			 //괄호의 위치를 표현하기 끝위치-1로 표현됨
			 System.out.println("지역 번호 : "+ phone.substring(0,phone.indexOf(")")));
			 //0부터 괄호가 있는 위치까지 표현함 -1이니까 
			 // 항상 괄호를 만들지 말고,괄호가 열때 닫아지도록 하기, 문장을 채워놓도록 하기 
		 }
		 
		 //String의 String[] split(String delim)은 String객체가 포함하고 있는 문자열에 대해서 
		 //지정된 구분문자로 문자열을 자르고, 잘린 문자들을 배열에 담아서 반환한다. 
		 // String text = "김유신, 강감찬, 이순신";  
		 // String[] names = text.split(","); 
		 // names = {"김유신","강감찬" ,"이순신"};
		 //str1에서 이번 강의에 신청한 사람들이다. 
		 //신청자 수와 신청한 사람의 이름을 화면에 출력하기 
		 System.out.println("### String객체의 문자열이 ,로 구분된 텍스트일 때 그 데이터를 분석해서 처리하기 ");
		 str1 = "김유신,강감찬,이순신,유관순,안중근";
		
		 String[] names = str1.split(",");//String[]이 얻어짐
		 int count = names.length;
		 System.out.println("전체 참가자수 : " + count + "명");
		 for(String name : names) { //참가자의 이름을 출력함
			 System.out.println("참가자 이름 :" + name);
		 }
		
		 //String의 String trim()은 String객체가 포함하고 있는 문자열에 대해서 
		 // 문자열의 좌/우에 포함된 불필요한 공백이 제거된 새로운 문자열을 생성해서 반환한다. 
		 System.out.println("### String객체의 문자열에서 좌우공백이 제거된 문장열을 얻기");
		 //trim(잘라내다라는 뜻)
		 str1 = "                           안녕하세요                    반갑습니다.                    ";
		 result3 = str1.trim();
		 System.out.println("원본 문자열 ["+str1+"]");
		 System.out.println("새 문자열 ["+result3+"]");//글자사이에 있는 공백은 없애지 않음. 그 사이에 의미가 있다고 생각함
		 //검색할 때, 회원가입할 때 , 주소를 입력할 떄 , 실제 데이터 저장시에는 공백을 없애고 저장하게 됨
		 
		 //String의 정적 메소드 String valueOf(int value), String valueOf(long value), String valueOf(double value),
		 //					 String valueOf(boolean value) , String valueOf(char value) 들은
		 // 입력값에 대한 문자열을 생성해서 반환한다. 
		 System.out.println("### String 클래스의 valueOf(값)는 입력으로 전달받은 값에 대한 문자열을 생성한다. ");
		 //화면에 표시되는 것은 똑같아서 구분하기 어렵다.
		String value1 =  String.valueOf(100);  	//100	-> 	"100"
		String value2 =  String.valueOf(10000000000L);//문자열로 변환
		String value3 =  String.valueOf(3.141592);//문자열로 변환
		String value4 =  String.valueOf('a');//문자열로 변환
		String value5 =  String.valueOf(true);//문자열로 변환 
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);
		System.out.println(value5);
		
		//문자열을 숫자로 변환하는 것은 Integet.ParseInt();

		//parse 1.원래값을 알아낸다 2.text데이터로부터 해석해서 객체를 생성한다. 
		//범용적인 의미로 사용됨
		/*
		 * 	기본자료형과 문자열간의 데이터 변환
		 * 	기본자료형을 문자열로 변환하기 
		 * 			String 문자열 = String.valueOf(정수);
		 * 			String 문자열 = String.valueOf("1000000000000");
		 * 			String 문자열 = String.valueOf(true);
		 * 			String 문자열 = String.valueOf('A');
		 * 			
		 * 	문자열을 기본자료형값으로 변환하기 //전부 Java.lang에 존재하는 클래스임
		 * 			int 정수 = Integer.parseInt("1234"); //integer라는 클래스 내부에 있음 ()을 해석하여 정수로 출력한다. ,많이사용
		 * 			long 정수 = Long.parseLong("1000000000000");
		 * 			double 실수 = Double.parseDouble("3.141592");//많이 사용됨
		 * 			boolean 논리값 = Boolean.parseBoolean("true");
		 *			캐릭터는 잘 사용하지 않음
		 * 			
		 */
		
		
		
		
	}
}
