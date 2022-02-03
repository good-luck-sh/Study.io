package com.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {
	
	/*
	 * @Scheduled 어노테이션
	 * 		특정 메소드에 @Scheduled 어노테이션을 지정하면 설정한 값에 따라 주기적으로 해당 메소드를 실행한다.
	 * 		@Scheduled 어노테이션의 주요 옵션
	 * 			fixedDelay	: 이전 작업이 종료된 후 설정된 시간만큼 기다린 후에 시작한다.
	 * 						  @Scheduled(fixedDelay = 1000)
	 * 
	 * 			fixedRate	: 이전 작업이 종료되지 않아도 설정된 시간마다 시작한다.
	 * 						  @Scheduled(fixedRate = 1000)
	 * 
	 * 			cron		: 원하는 시간대를 설정하여 작업을 실행한다.		
	 * 						  @Scheduled(cron="0 59 1, 15 * ?")		// 매월 15일 오전 10시 59분 0초마다 실행
	 * 
	 * 						  cron = "초 분 시 일 월 요일"
	 * 						  이름	필수여부	허용값		허용 특수문자
	 * 						  초 	YES		0 ~ 59		, - * /
	 * 						  분		YES		0 ~ 59		, - * /
	 * 						  시		YES		0 ~ 23      , - * /
	 * 						  일		YES		1 ~ 31		, - * ? / L W C
	 * 					      월		YES		1 ~ 12		, - * /
	 * 					      요일	YES		1 ~ 7 		, - * ? / L C #			  
	 * 
	 * 						  특수문자
	 * 						  * : 모든 값
	 * 					      ? : 해당 필드를 고려하지 않음(일자를 나타내는 필드와 요일을 나타내는 필드에 동시에 설정할 수 없다.)
	 * 						  , : 여러 개의 값을 나열한다 예시) 0,15,30,45
	 * 						  - : 범위를 표시한다. 예시) 2-4는 2,3,4를 의미한다.
	 * 						  / : 초기치를 기준으로 일정하게 증가하는 값을 의히만다. 예시) 초를 나타내는 필드에 0/15는 0을 시작으로 15초씩 증가를 의미한다.
	 * 						  L : 일에서 사용하면 마지막 일, 요일에서는 마지막 요일
	 * 						  W : 가장 가까운 평일 예시) 10W 10일에서 가장 가까운 평일
	 * 						  # : 몇째주의 무슨 요일을 지정 예시) 2#3은 3번째주 화요일
	 */ 
	
	//		"0 0 12 * * ?" 			: 아무 요일, 매월, 매일 12:00:00
	//	 	"0 15 10 ? * *" 		: 모든 요일, 매월, 아무 날이나 10:15:00 
	//	 	"0 15 10 * * ?" 		: 아무 요일, 매월, 매일 10:15:00 
	//	 	"0 * 14 * * ?" 			: 아무 요일, 매월, 매일, 14시 매분 0초 
	//	 	"0 0/5 14 * * ?" 		: 아무 요일, 매월, 매일, 14시 매 5분마다 0초 
	//	 	"0 0/5 14,18 * * ?" 	: 아무 요일, 매월, 매일, 14시, 18시 매 5분마다 0초 
	//	 	"0 0-5 14 * * ?" 		: 아무 요일, 매월, 매일, 14:00 부터 매 14:05까지 매 분 0초 
	//	 	"0 10,44 14 ? 3 WED" 	: 3월의 매 주 수요일, 아무 날짜나 14:10:00, 14:44:00 
	//	 	"0 15 10 ? * MON-FRI" 	: 월~금, 매월, 아무 날이나 10:15:00 
	//	 	"0 15 10 15 * ?" 		: 아무 요일, 매월 15일 10:15:00 
	//	 	"0 15 10 L * ?" 		: 아무 요일, 매월 마지막 날 10:15:00 
	//	 	"0 15 10 ? * 6L" 		: 매월 마지막 금요일 아무 날이나 10:15:00 
	//	 	"0 15 10 ? * 6#3"		 : 매월 3번째 금요일 아무 날이나 10:15:00

	@Scheduled(cron = "0/10 * * * * ?")
	public void fixedDelayTask() {
		System.out.println("cron task - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	}
}
