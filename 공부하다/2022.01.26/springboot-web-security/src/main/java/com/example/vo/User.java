package com.example.vo;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class User implements UserDetails {

	private static final long serialVersionUID = -7529436226295943141L;
	
	private int no;
	private String name;
	private String password;
	private String nickname;
	private String email;
	private String disabled;
	private Date updatedDate;
	private Date createdDate;
	private Collection<? extends GrantedAuthority> authorities;
	
	@Override
	public String getUsername() {				// 사용자 아이디를 반환하는 기능
		return name;
	}
	@Override
	public boolean isAccountNonExpired() {		// 계정만료 여부를 반환하는 기능
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {		// 계정잠김 여부를 반환하는 기능
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {	// 비밀번호 만료여부를 반환하는 기능
		return true;
	}
	@Override
	public boolean isEnabled() {				// 사용중이 계정인지 여부를 반환하는 기능
		return disabled.equals("N");
	}
}
