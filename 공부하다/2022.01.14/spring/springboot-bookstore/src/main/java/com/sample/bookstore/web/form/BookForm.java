package com.sample.bookstore.web.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookForm {

	private String title;
	private String author;
	private String publisher;
	@DateTimeFormat(pattern = "yyyy-MM-dd") //날짜가 유니코드가 아닌 일반적으로 들어가도록 설정함
	private Date pubDate;
	private int price; //금액으로는 거의 long이 많다. 
	private int discountPrice;
	private int stock;
	
}
