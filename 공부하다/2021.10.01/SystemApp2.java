package example_10_01_system;

import java.util.Date;

public class SystemApp2 {

	public static void main(String[] args) {
		
		//시스템의 유닉스타임을 조회하기 
		long unixTime = System.currentTimeMillis();
		System.out.println("유닉스 타임: " + unixTime);
		
		//시스템의 현재 날짜와 시간정보를 제공하는 객체를 생성하기 
		Date now = new Date();
		//생성이 되는 그 순간에 대한 System에 시간이 보안된다. 
		System.out.println(now);
		//toString이 재정의 되어있어서 날짜정보를 이렇게 출력함

		Date day = new Date(0);
		System.out.println(day);
		//우리나라가 영국보다 9시간 빠름 유닉스타임은 영국을 기준으로 해서 작성이 되어있고,
		//Date의 해당되는 시간을 넣으면 날짜를 얻을 수 있음 
		// 우리나라는 9시간이 빠르기 때문에 00시로 나오지 않음 
		
		//날짜와 시간정보를 제공하는 객체 java.util.Date 
		
		//날짜 정보를 제공하는 객체 java.sql.Date //날짜정보만 제공함
		//시간 정보를 제공하는 객체 java.sql.TimeStamp
		
		//날짜 정보를 제공하는 객체 java.time.LocalDate
		//시간 정보를 제공하는 객체 java.time.LocalTime
		//Local 내가 지금 살고있는 이 지금을 의미함
		//날짜와 시간정보를 제공하는 객체 java.time.LocalDateTime
		
	}
}
