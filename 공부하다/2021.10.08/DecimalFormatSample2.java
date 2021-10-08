package example_10_08_formating;

import java.text.DecimalFormat;
import java.text.ParseException;

public class DecimalFormatSample2 {

	public static void main(String[] args) throws ParseException {
		
		String text1 = "12345";
		String text2 = "12,345";
		
		//숫자외의 문자가 없는 경우
		int number1 = Integer.parseInt(text1); //comma가 없거나 다른 문자가 없는 경우 
		//int number2 = Integer.parseInt(text2);//그대로 사용시 java.lang.NumberFormatException 오류 발생
		
		//숫자외의 문자를 전부 삭제한 다음 숫자로 바꾸기
		text2 = text2.replace(",", ""); //콤마를 공백으로 변경한다.
		int number2 = Integer.parseInt(text2);
		
		//숫자로 변경된 값으로 사칙연산 수행해보기
		System.out.println(number1 + number2);
		
		String text3 = "12,345,678";
		DecimalFormat df = new DecimalFormat("##,###");
		//Number는 Byte, Short, Integer, Long, Float,Double의 부모 클래스다.
		Number number = df.parse(text3);
		long value = number.intValue();
		System.out.println(value);
		
		
		
	}
}
