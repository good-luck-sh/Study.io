package demo1;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App3 {
	
	public static void main(String[] args) {
		//스트림 변환하기 
		
		
		//스트림의 생성
		IntStream intStream = IntStream.rangeClosed(1, 10);
		//스트림의 변환
		intStream.map(num -> num*2) 	//map(람다식) : 람다식이 반환값이 포함된 새 스트림을 반환한다. 
		.forEach(System.out::println);
		//::은 메소드 참조라고 한다. 
		
		String[] arr = {"나는 학교에 갑니다.","올해는 2022년 입니다.", "학생들은 줌으로 수업을 듣습니다."};
		//스트림의 생성
		Arrays.stream(arr)
		.flatMap(text -> Stream.of(text.split(" ")))//그냥 map으로 사용했을 경우 [Ljava.lang.String;@4f4a7090
		//스트림의 변환
		.forEach(System.out::println);
		//flatMap(람다식) : 람다식이 반환하는 스트림들이 전부 병합된 새 스트림을 반환하게 된다. 
	}
	
}
