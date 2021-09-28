package example_09_27_inner_class_example;

import example_09_27_inner_class_example.StudentScoreRepository.ScoreStats;

public class ScoreApp {

	public static void main(String[] args) {
		//성적정보에 대한 통계기능이 구현된 내부클래스를 가지고 있는 객체를 제공하는 클래스다.
		StudentScoreRepository repo = new StudentScoreRepository();
		
		//학생성적정보 추가/ 변경/ 조회/ 삭제... 많은 업무 완료
		//학생성적정보 추가/ 변경/ 조회/ 삭제... 많은 업무 완료
		//학생성적정보 추가/ 변경/ 조회/ 삭제... 많은 업무 완료
		//학생성적정보 추가/ 변경/ 조회/ 삭제... 많은 업무 완료
		//학생성적정보 추가/ 변경/ 조회/ 삭제... 많은 업무 완료
		//학생성적정보 추가/ 변경/ 조회/ 삭제... 많은 업무 완료
		//학생성적정보 추가/ 변경/ 조회/ 삭제... 많은 업무 완료
		//학생성적정보 추가/ 변경/ 조회/ 삭제... 많은 업무 완료
		//학생성적정보 추가/ 변경/ 조회/ 삭제... 많은 업무 완료
		//성적정보에 대한 통계정보를 획득하게 하는 내부객체를 획득함
		//성적정보에 대한 통계정보를 제공하는 객체를 조회.
		ScoreStats stats=repo.getStats();
		//import 시켜줌
		
		System.out.println("전체 평균 : " + stats.average() );
		System.out.println("국어과목평균 : " + stats.korAverage() );
		System.out.println("영어과목평균 : " + stats.engAverage() );
		System.out.println("수학과목평균 : " + stats.mathAverage() );
		
	}
}
