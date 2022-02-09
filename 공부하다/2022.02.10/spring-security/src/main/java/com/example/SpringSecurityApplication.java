package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}
	
	// 이 애플리케이션에서 사용할 패스워드인코더객체를 스프링 컨테이너에 빈으로 등록한다.
	/*
	 * @Bean
	 * 		- @Bean 어노테이션이 지정된 메소드가 반환하는 객체를 스프링컨테이너의 빈으로 등록시킨다.
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
