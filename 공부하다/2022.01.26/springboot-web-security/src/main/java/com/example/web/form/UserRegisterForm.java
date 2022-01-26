package com.example.web.form;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegisterForm {

	private String username;
	private String nickname;
	private String password;
	private String email;
	private List<String> roles;
}
