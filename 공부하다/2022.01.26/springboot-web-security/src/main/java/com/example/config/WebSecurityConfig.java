package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.web.security.CustomUserDetailsService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeHttpRequests()
			// 권한별 접근제어
			.antMatchers("/", "/register", "/login", "/error/*").permitAll()
			.antMatchers("/admin/*").hasRole("ADMIN")
			.anyRequest().hasRole("USER")
			// 접근거부 예외 처리(http 응답코드 : 403)
			.and()
		    	.exceptionHandling().accessDeniedPage("/error/forbidden")
		    // 로그인  설정
			.and()
				.formLogin()					// 폼 로그인사용
				.loginPage("/login")			// 사용자 로그인 페이지 지정, 로그인이 필요한 경우 /login을 시큐리티가 요청한다.
				.loginProcessingUrl("/login")	// 로그인폼에서 로그인을 요청할 때 사용하는 URL을 지정
				.defaultSuccessUrl("/login", true)	// 로그인 성공일 때 요청하는 URL 지정
				.failureUrl("/login?error=true")// 로그인 실패했을 때 요청하는 URL 지정
			// 로그아웃 설정
			.and()
				.logout()
				.logoutUrl("/logout")			// 로그아웃을 요청하는 URL 지정
				.logoutSuccessUrl("/")			// 로그아웃 성공일 때 요청하는 URL 지정
				.deleteCookies("JSESSIONID");	// 로그아웃이 완료되면 쿠키값을 삭제
				
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// UserDetails			- 인증된 사용자 정보를 제공하는 기능이 정의된 인터페이스다. 
		// UserDetailsService	- 사용자 인증처리를 수행하는 기능이 정의된 인터페이스다.
		
		// 스프링 시큐리티의 인증관리자객체에 사용자정의 UserDetailsService(사용자정보를 제공한다.)와 비밀번호를 암호화하는 패스워드인코더를 전달한다.
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 스프링 시큐리티 인증과정을 사용하지 않는 요청 URL을 지정한다.
		// 주로 정적 자원(이미지, CSS, 자바스크립트)을 요청하는 URL을 지정한다.
		web.ignoring().antMatchers("/resources/**");
	}
}
