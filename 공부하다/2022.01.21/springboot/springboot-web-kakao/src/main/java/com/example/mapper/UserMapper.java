package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.User;

@Mapper
public interface UserMapper {

	void insert(User user);
	User getUserById(String id);
	User getUserByEmail(String email);
	void update(User user);
}
