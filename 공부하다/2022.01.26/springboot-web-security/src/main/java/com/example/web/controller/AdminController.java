package com.example.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.vo.User;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/main")
	public String main(Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		System.out.println(user.getNo() + " " + user.getName() + " " + user.getNickname());
		return "admin/main";
	}
	
}
