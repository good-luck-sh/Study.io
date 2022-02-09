package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;	// 데이터베이스에서 사용자정보를 조회해서 반환하는 사용자정의 UserDetailsService

	@Autowired
	private PasswordEncoder passwordEncoder;		// 비밀번호를 인코딩하는 패스워드인코더

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
			.antMatchers("/", "/registerform", "/register", "/completed").permitAll()
			.anyRequest().authenticated()
		.and()
			.formLogin()
			.loginPage("/loginform")
			.loginProcessingUrl("/login")
			.usernameParameter("email")
			.passwordParameter("password")
			.permitAll()
		.and()
			.logout()
			.logoutSuccessUrl("/")
			.permitAll();
	}

	// 인증관리자객체(AuthenticationManager)에게 사용자정의 UserDetailsService객체와 패스워드인코더객체를 전달한다.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder);
	}
}






