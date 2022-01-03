package demo1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class App2 {

	public static void main(String[] args) {
		//스트림 생성
		IntStream numberStream = IntStream.rangeClosed(1, 10);
		//스트림 필터링
		numberStream
		.filter(num -> num <= 5) 	//filter(Predicate predicate) -- true까지의 값을 반환한다.
		.forEach(num -> System.out.println(num));
		//filter(람다식); 람다식이ㅡ 값이 true를 반환한 것만 새 스트림에 포함된다. 
		
		String[] names = {"서울","경기","인천","서울","부산","인천","울산"};
		Arrays.stream(names)
		.distinct()					//distinct() : 중복된 요소가 제거된 새 스트림을 반환한다. 
		.forEach(name -> System.out.println(name));
		
	}
}
