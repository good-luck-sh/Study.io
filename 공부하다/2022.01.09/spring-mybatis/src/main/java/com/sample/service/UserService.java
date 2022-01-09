package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.UserDao;
import com.sample.exception.LoginErrorException;
import com.sample.vo.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User login(String id, String password) {
		User user = userDao.getUserById(id);
		if(user == null) {
			throw new LoginErrorException("회원정보가 존재하지 않습니다. ");
		} if("Y".equals(user.getDisabled())) {
			throw new LoginErrorException("탈퇴처리가 완료된 회원입니다. ");
		} if(!user.getPassword().equals(password)) {
			throw new LoginErrorException("회원정보의 비밀번호가 틀렸습니다. ");
		}
		//인증된 사용자정보를 반환
		return user;
	}
	
}
