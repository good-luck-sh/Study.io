package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRoleMapper {

	void insertRole(@Param("userNo") int userNo, @Param("roleName") String roleName);
	List<String> getUserRolesByUserNo(int userNo);
}
