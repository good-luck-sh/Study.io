package com.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.service.UserService;
import com.example.vo.User;
import com.example.web.form.UserRegisterForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	/*
	 * 홈화면 요청을 처리한다.
	 * 요청URI : /
	 * 요청 파라미터 : 없음
	 * 뷰 페이지 : /WEB-INF/views/home.jsp
	 */
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	/*
	 * 회원가입폼 요청을 처리한다.
	 * 요청 URI : /register
	 * 요청 파라미터 : 없음
	 * 뷰 페이지 : /WEB-INF/views/registerform.jsp
	 */
	@GetMapping("/register")
	public String registerform() {
		return "registerform";
	}
	
	/*
	 * 회원가입 요청을 처리한다.
	 * 요청 URI : /register
	 * 폼 데이터 : username, password, nickname, email, age, gender
	 * 재요청 URI : 성공 - /completed, 실패 - /register
	 */
	@PostMapping("/register") 
	public String register(UserRegisterForm form, RedirectAttributes redirectAttributes) {
		log.info("회원가입 정보: " + form);
		User user = User.builder()
				.name(form.getUsername())
				.password(passwordEncoder.encode(form.getPassword()))
				.nickname(form.getNickname())
				.email(form.getEmail())
				.build();
		try {
			// 서비스에 회원정보를 전달해서 회원가입을 처리하게 한다. 
			userService.registerUser(user, form.getRoles());
			return "redirect:/completed";
		} catch (RuntimeException e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/register";
		}
	}
	
	/*
	 * 회원가입 완료 페이지 요청을 처리한다.
	 * 요청 URI : /completed
	 * 요청 파라미터 : 없음
	 * 뷰 페이지 : /WEB-INF/views/completed.jsp
	 */
	@GetMapping("/completed") 
	public String completed(){
		return "completed";
	}
	
	/*
	 * 로그인 페이지 요청을 처리한다.
	 * 요청 URI : /login
	 * 요청 파라미터 : 없음
	 * 뷰 페이지 : /WEB-INF/views/login.jsp
	 */
	@GetMapping("/login") 
	public String loginform(){
		return "login";
	}
	
	
	
}
