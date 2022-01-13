package com.sample.bookstore.web.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor//매개변수 없는 생성자
@AllArgsConstructor // 모든 매개변수를 재정의하는 생성자
@Builder		//빌드패턴
@Getter	//getter
@Setter //setter
@ToString//재정의
public class Book {

	private int no;
	private String title;
	private String author;
	private String publisher;
	private Date pubDate;
	private int price;
	private int discountPrice;
	private int stok;
	private Date updatedDate;
	private Date createdDate;
	
}
