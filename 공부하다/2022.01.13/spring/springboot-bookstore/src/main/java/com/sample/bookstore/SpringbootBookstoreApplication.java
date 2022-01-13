package com.sample.bookstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sample.bookstore.web.service.BookService;

@SpringBootApplication
@MapperScan(basePackages = "com.sample.bookstore.web.mapper") //basepackages를 읽어오게 설정하는것 Context-root에서 작성한 부분임
public class SpringbootBookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBookstoreApplication.class, args);
	}
	
	@Bean
	public BookService getBookService() {
		return new BookService();  //이렇게 메소드로 호출하는 빈으로 등록가능하다 xml을 따로 만들지 않고 이렇게 설정하자 라는 것이다.
	}

}
