package demo1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App1 {
	public static void main(String[] args) {
		//콜렉션을 이용해서 스트림 생성하기 
		List<String> names = List.of("김유신","강감찬","이순신","류관순","홍길동");
		//스트림의 생성
		Stream<String> streams = names.stream();
		//스트림의 최종연산
		streams.forEach(name -> System.out.println(name));
		
		//배열로부터 스트림 생성하기
		int[] number = {100,70,50,60,70,80,90,70};
		//스트림 생성 
		IntStream intStream = Arrays.stream(number);
		//스트림 최종연산
		int sum = intStream.sum();
		System.out.println("합계 : " + sum);
		
		//객체를 담고 있는 콜렉션으로부터 스트림 생성하기
		List<Score> score = List.of(new Score(100,100,100), new Score(100,90,80));
		//스트림 생성
		Stream<Score> scoreStream = score.stream();
		//스트림 증간연산 
		Stream<Integer> totalStream = scoreStream.map(scores -> scores.kor + scores.eng + scores.math);
		totalStream.forEach(total->System.out.println(total));
	}
	
	static class Score{
		int kor;
		int math;
		int eng;
		
		public Score(int kor, int eng, int math) {
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
	}
}
	
	
