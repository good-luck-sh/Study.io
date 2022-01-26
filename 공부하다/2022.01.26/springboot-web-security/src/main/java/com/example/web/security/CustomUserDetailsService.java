package com.example.web.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.mapper.UserMapper;
import com.example.mapper.UserRoleMapper;
import com.example.vo.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	UserRoleMapper userRoleMapper;
	
	// 전달받은 사용자 아이디에 해당하는 사용자정보를 반환한다.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("["+username+"]이 존재하지 않습니다.");
		}
		user.setAuthorities(getUserRole(user.getNo()));
		return user;
	}
	
	// 사용자 번호에 해당하는 사용자가 보유한 권한을 반환한다.
	// 사용자 권한은 테이블에 "USER" 혹은 "ADMIN"으로 저장되어 있는데, "ROLE_USER", "ROLE_ADMIN"으로 바꿔서 SimpleGrantedAauthority객체를 생성한다.
	private Collection<? extends GrantedAuthority> getUserRole(int userNo) {
		List<String> roles = userRoleMapper.getUserRolesByUserNo(userNo);
		return roles.stream().map(role -> {return new SimpleGrantedAuthority("ROLE_" +  role);}).collect(Collectors.toList());
	}
}
