package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.entity.Book;
import com.example.entity.User;
import com.example.repository.BookRepository;
import com.example.repository.UserRepository;

@EnableJpaAuditing
@SpringBootApplication
public class KakaopayApplication {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(KakaopayApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public CommandLineRunner runner() {
    	PasswordEncoder passwordEncoder = passwordEncoder();
    	return (arg) -> {
    		userRepository.save(new User("hong@gmail.com", passwordEncoder.encode("zxcv1234"), "홍길동"));
    		userRepository.save(new User("kim@gmail.com", passwordEncoder.encode("zxcv1234"), "김유신"));
    		userRepository.save(new User("kang@gmail.com", passwordEncoder.encode("zxcv1234"), "강감찬"));
    		
    		bookRepository.save(new Book("진짜 쓰는 실무 엑셀", "전진권", "제이펍", 21000));
    		bookRepository.save(new Book("1일 1로그 100일 완성 IT지식", "브라이언 W. 커니핸", "인사이트", 20000));
    		bookRepository.save(new Book("Do it! 점프 투 파이썬", "박응용", "이지스퍼블리싱", 18000));
    		bookRepository.save(new Book("비전공자를 위한 이해할 수 있는 IT 지식", "최원영", "티더블유아이지", 16000));
    		bookRepository.save(new Book("회사에서 바로 통하는 실무 엑셀+파워포인트", "전미진", "한빛미디어", 22000));
    		bookRepository.save(new Book("혼자 공부하는 파이썬", "윤인성", "한빛미디어", 18000));
    		bookRepository.save(new Book("맛있는 디자인 포토샵과 일러스트레이트", "박정아", "한빛미디어", 22000));
    		bookRepository.save(new Book("프로그래머의 뇌", "펠리너 헤르만스", "제이펍", 24000));
    		bookRepository.save(new Book("Clean Code 클린 코드", "로버트 C. 마틴", "인사이트", 33000));
    		bookRepository.save(new Book("혼자 공부하는 머신러닝+딥러닝", "박해선", "한빛미디어", 26000));
    	};
    }

}
