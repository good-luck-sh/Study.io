package com.example.web.form;

import lombok.Setter;
import lombok.ToString;

import org.springframework.util.StringUtils;

import lombok.Getter;

@Getter
@Setter
@ToString
public class KakaoLoginForm {

	private String id;
	private String name;
	private String email;
	private String ageRange;
	private String gender;
	
	public int getAge() {
		if (!StringUtils.hasText(ageRange)) {
			return 0;
		}
		return Integer.parseInt(ageRange.substring(0, ageRange.indexOf("~")-1));
	}
}
