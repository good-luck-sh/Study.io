package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
 * @EnableScheduling 어노테이션
 * 		@EnableScheduling 어노테이션은 스프링 스케줄링 기능을 활성화 시킨다.
 * 		@EnableScheduling 어노테이션이 선언된 클래스가 포함된 패키지 및 하위 패키지에 스케줄러 클래스를 정의하고 @Scheduled 어노테이션 설정을 추가하면 스케줄러 구현이 완료된다.
 */
@EnableScheduling
@SpringBootApplication
public class SpringbootSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSchedulerApplication.class, args);
	}

}
