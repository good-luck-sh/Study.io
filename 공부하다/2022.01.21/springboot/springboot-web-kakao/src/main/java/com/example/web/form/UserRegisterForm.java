package com.example.web.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegisterForm {

	private String id;
	private String name;
	private String password;
	private String email;
	private int age;
	private String gender;
}
