package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void addNewUser(User user) {
		Optional<User> optional = userRepository.findByEmail(user.getEmail());
		if (optional.isPresent()) {
			throw new RuntimeException("이미 가입된 이메일입니다.");
		}
		userRepository.save(user);
	}
}
