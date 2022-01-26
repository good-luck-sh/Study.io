package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.UserMapper;
import com.example.mapper.UserRoleMapper;
import com.example.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	/**
	 * 이 사이트의 회원가입 폼에서 입력한 사용자 정보를 데이터베이스에 등록시킨다.<p>
	 * 사용자명(사용자 아이디), 이메일 중복 여부를 체크한다.
	 * @param user 신규 사용자 정보
	 * @return 사용자정보
	 */
	public User registerUser(User user, List<String> roles) {
		log.info("일반 회원가입 유저정보: " + user);
		
		User savedUser = userMapper.getUserByUsername(user.getName());
		if (savedUser != null) {
			log.warn("일반 회원가입: 아이디 중복");
			throw new RuntimeException("사용할 수 없는 아이디입니다.");
		}
		
		savedUser = userMapper.getUserByEmail(user.getEmail());
		if (savedUser != null) {
			log.warn("일반 회원가입: 이메일 중복");
			throw new RuntimeException("사용할 수 없는 이메일입니다.");
		}
		
		userMapper.insert(user);
		for (String roleName : roles) {
			userRoleMapper.insertRole(user.getNo(), roleName);
		}
		log.info("일반 회원가입 신규 사용자 정보 등록 완료");
		
		return user;
	}
	
	
}
