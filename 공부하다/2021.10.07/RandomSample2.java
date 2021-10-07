package example_10_07_03_Random;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class RandomSample2 {

	public static void main(String[] args) {
		Random random = new Random();
		
		//중복을 허용하지 않음
		Set<Integer> numbers = new TreeSet<>();
		while(true) {
			if(numbers.size() == 6) {//숫자가 6개가 되면 탈출한다.
				break;
			}
			int number = random.nextInt(45) + 1;//1~45사이의 값을 출력한다
			System.out.print(number + "\t");
			numbers.add(number); //중복되는 값은 입력하지 않는다.
		}
		System.out.println();
		System.out.println(numbers);
	}
}
