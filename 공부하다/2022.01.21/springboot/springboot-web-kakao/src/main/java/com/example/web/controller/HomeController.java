package com.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.service.UserService;
import com.example.utils.SessionUtils;
import com.example.vo.User;
import com.example.web.form.KakaoLoginForm;
import com.example.web.form.UserRegisterForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	private static final String NORMAL_LOGIN_TYPE = "normal";
	private static final String KAKAO_LOGIN_TYPE = "normal";
	
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	// 회원 가입폼 요청을 처리한다.
	@GetMapping("/register")
	public String registerform() {
		return "registerform";
	}
	
	// 일반 회원가입 요청을 처리한다.
	@PostMapping("/register") 
	public String register(UserRegisterForm form, RedirectAttributes redirectAttributes) {
		User user = User.builder()
				.id(form.getId())
				.name(form.getName())
				.password(form.getPassword())
				.email(form.getEmail())
				.age(form.getAge())
				.gender(form.getGender())
				.loginType(NORMAL_LOGIN_TYPE)	// 일반회원 가입은 로그인타입을 "normal"로 설정한다.
				.build();
		try {
			// 서비스에 회원정보를 전달해서 회원가입을 처리하게 한다. 
			userService.registerUser(user);
			redirectAttributes.addFlashAttribute("user", user);
			
			return "redirect:/completed";
		} catch (RuntimeException e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/register";
		}
	}
	
	// 회원가입 완료 페이지 요청을 처리한다.
	@GetMapping("/completed") 
	public String completed(RedirectAttributes redirectAttributes){
		return "completed";
	}
	
	// 로그인 폼 요청을 처리한다.
	@GetMapping("/login") 
	public String loginform(){
		return "login";
	}
	
	// 일반로그인 요청을 처리한다.
	@PostMapping("/login") 
	public String login(String id, String password, RedirectAttributes redirectAttributes){
		try {
			User user = userService.login(id, password);
			SessionUtils.addAttribute("LOGIN_USER", user);
			
			return "redirect:/";
		} catch (RuntimeException e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/login";
		}
	}
	
	// 카카오 로그인 요청을 처리한다.
	@PostMapping("/kakao-login")
	public String loginWithKakao(KakaoLoginForm form) {
		log.info("카카오 로그인 인증정보 : " + form );
		
		User user = User.builder()
					.id(form.getId())
					.name(form.getName())
					.email(form.getEmail())
					.age(form.getAge())
					.gender(form.getGender())
					.loginType(KAKAO_LOGIN_TYPE)
					.build();
		
		User savedUser = userService.loginWithKakao(user);
		
		if (savedUser != null) {
			SessionUtils.addAttribute("LOGIN_USER", savedUser);
		} else {
			SessionUtils.addAttribute("LOGIN_USER", user);
		}
		
		return "redirect:/";
	}
	
	// 로그아웃 요청을 처리한다.
	@GetMapping("/logout")
	public String logout() {
		SessionUtils.sessionInvlidate();
		return "redirect:/";
	}
	
}
