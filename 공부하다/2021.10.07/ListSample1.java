package example_10_07_02_comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListSample1 {

	public static void main(String[] args) {
		
		//Arrays.asList(E....e)는 지정된 객체들이 저장된 List 자료구조 객체를 반환한다.
		List<Integer> numbers = Arrays.asList(10, 20, 3, 57, 1, 63, 18, 21, 32);
		System.out.println(numbers.getClass().getName());
		//java.util.Arrays$ArrayList가 만들어져서 반환된다.
		Collections.reverse(numbers);
		System.out.println(numbers);
		
		//Collections.sort(List<E> list)는 List객체에 저장된 요소들을 오름차순으로 정렬한다.
		Collections.sort(numbers);
		System.out.println(numbers);
		
		//Collections.reverse(List<E> list)는 List객체에 저장된 요소들을 역순으로 다시 저장한다.
		Collections.reverse(numbers);
		System.out.println(numbers);
		//Collection<E>는 정적메소드다.
		
		//문자열 값 정렬하기 
		List<String> names = Arrays.asList("김유신", "홍길동", "이순신", "강감찬" , "류관순");
		
		Collections.sort(names);
		System.out.println(names);
		
	}
}
