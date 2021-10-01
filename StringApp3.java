package example_09_29_String;

public class StringApp3 {

	public static void main(String[] args) {
		//이삼백사십육 4자리의 숫자를 변환하고 싶음
		
		//                0    1   2   3   4    5    6   7   8  
		String[] words = {"일","이","삼","사","오","육","칠","팔","구"};
		String[] units = {"천","백","십",""};
		int balance = 2346;
		//천, 백, 십, 일
		//첫번째 글자가 어떤건지 알아야 함. 글자가 치환되어야함 
		//if문으로 사용이 가능함
		
		//한글자를 담을 String 타입의 변수를 선언한다. String text = "";
		//2346 ->"2346" ->["2","3","4","6"]으로 나눔
		//for문을 이용해서 배열에서 문자열을 하나씩 조회한다.
		//조회된 문자열을 숫자로 변환한다. Integer.parseInt(문자열) 
		//조회된 숫자값보다 하나 작은 위치에서 글자를 출력한다. 
		//words배열에서 숫자에 맞는 글자를 가져온다.(가져올 위치는 계산된 숫자보다 하나 작은 위치다. )
		//units배열에서 해당자리숫자에 맞는 단위를 가져온다. 
		//위에서 정의한 text에 두 글자를 추가한다. 
		//텍스트 내용을 출력한다.
		String text ="";
		//String.valueOf(balance)는 숫자를 String으로 바꾼다. 
		//String.valueOf(balance)가 String이기 때문에 .split("")을 바로 사용해보자
		//String.valueOf(balance).split("")은 숫자를 문자열로 바꾸고 문자열을 빈 문자열로 조각내서 ["2","3","4","6"]가 획득된다.
		String[] numberWords = String.valueOf(balance).split("");
		
		//numberWords.length는 4이다. 따라서 반복문은 i가 0,1,2,3일 동안 실행된다. 
		for(int i = 0; i<numberWords.length; i++) {
			//numberWords[i]는 블록내의 수행문이 실행될 때마다 "2","3","4","6"이 순서대로 조회된다.
			//Integer.pareInt(numberWords[i])는 블록문이 실행될 때 마다 2,3,4,6이 획득된다.
			//Integer.pareInt(numberWords[i]) - 1은 블록문내의 수행문이 실행될 때마다 조회된 수가 1,2,3,5가 계산된다.
			//계산된 값은 조회된 숫자에 대한 한글 숫자가 위치하고 있는 배열의 인덱스로 활용할 수 있다. 
			int wordIndex = Integer.parseInt(numberWords[i])-1;
			//위에서 계산된 인덱스값으로 words배열에서 한글 숫자를 조회한다. 
			String word = words[wordIndex];
			//블록내의 반복문이 실행될 때마다 i는 0,1,2,3으로 값이 변한다. 
			//i의 값은 한글숫자에 대한 단위가 들어있는 배열의 인덱스로 활용할 수 있다. 
			//i번째의 단위를 조회한다. 
			String unit = units[i];
			
			//위에서 조회된 한글숫자와 단위를 text에 더한다.
			text += word + unit;
		}
		//텍스트의 내용을 출력한다.
		
		System.out.println(text);
		
		
	}
}
