package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.UserMapper;
import com.example.vo.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User loginWithKakao(User user) {
		User savedUser = userMapper.getUserById(user.getId());
		if (savedUser == null) {
			userMapper.insert(user);
		}
		return savedUser;
	}
	
	public User registerUser(User user) {
		User savedUser = userMapper.getUserById(user.getId());
		if (savedUser != null) {
			throw new RuntimeException("사용할 수 없는 아이디입니다.");
		}
		savedUser = userMapper.getUserByEmail(user.getEmail());
		if (savedUser != null) {
			throw new RuntimeException("사용할 수 없는 이메일입니다.");
		}
		userMapper.insert(user);
		
		return user;
	}
	
	public User login(String id, String password) {
		User savedUser = userMapper.getUserById(id);
		if (savedUser == null) {
			throw new RuntimeException("사용자가 존재하지 않습니다.");
		}
		if (!"normal".equals(savedUser.getLoginType())) {
			throw new RuntimeException("사이트에 가입된 사용자가 아닙니다.");
		}
		if ("Y".equals(savedUser.getDisabled())) {
			throw new RuntimeException("탈퇴처리된 사용자입니다.");
		}
		if (!password.equals(savedUser.getPassword())) {
			throw new RuntimeException("비밀번호가 일치하지 않습니다.");
		}
		return savedUser;
	}
}
