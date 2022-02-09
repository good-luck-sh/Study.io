package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.UserService;
import com.example.vo.User;


@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping(path = "/")
	public String home() {
		return "home";
	}
	
	@GetMapping(path = "/registerform")
	public String registerForm() {
		return "registerform";
	}
	
	@PostMapping(path = "/register") 
	public String register(String email, String password, String name) {
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));
		return "redirect:/completed";
	}
	
	@GetMapping("/completed")
	public String completed() {
		return "completed";
	}
	
	@GetMapping("/loginform")
	public String loginform() {
		return "loginform";
	}
}
