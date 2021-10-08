package example_10_08_formating;

import java.text.DecimalFormat;

public class DecimalFormatSimple1 {

	public static void main(String[] args) {
		
		// 정수나 실수를 지정된 패턴의 문자열로 변환하기 
		long amount = 1000000000000L;
		DecimalFormat df = new DecimalFormat("##,###");
		String text1 = df.format(amount);
		System.out.println(text1);//1,000,000,000,000

		double number = 12345.67;
		df.applyPattern("##,###.#");//소수점 한자리수
		String text2 = df.format(number);
		System.out.println(text2);
		
		double number2 = 1.0/3.0;
		df.applyPattern("##,###.##");//소수점 두자리수
		String text3 = df.format(number2);
		System.out.println(text3);
		
		double number3 = 123.2400; //값은 동일한데, 
		df.applyPattern("##,###.####");//100분의 1까지 밖에 계산안한 느낌
		String text4 = df.format(number3);
		System.out.println(text4);
		
		df.applyPattern("##,###.0000");//10000분의 1까지 밖에 계산안한 느낌, 정밀도가 높음, 사용자가 정밀도 높은 작업원하면 0의자리까지 출력
		String text5 = df.format(number3);
		System.out.println(text5);
		
	}
}
