package com.example.vo;

import java.util.Date;

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
public class User {

	private String id;
	private String name;
	private String password;
	private String email;
	private int age;
	private String gender;
	private String loginType;
	private int point;
	private String disabled;
	private Date updatedDate;
	private Date createdDate;
}
