package com.sample.service;

import com.sample.vo.User;

public class UserServiceImpl {

	public User getUserByNo(int no) {
		User user = new User(100,"홍길동","hong@gmail.com","zxcv1234");
		return user;
	}
}
