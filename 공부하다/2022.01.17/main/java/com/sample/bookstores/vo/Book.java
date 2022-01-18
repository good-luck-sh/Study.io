package com.sample.bookstores.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Book {

	private int no;
	private String title;
	private String author;
	private String publisher;
	@JsonFormat(pattern = "yyyy년 M월 d일")
	private Date pubDate;
	private int price;
	private int discountPrice;
	private int stock;
	@JsonFormat(pattern = "yyyy년 M월 d일")
	private Date updatedDate;
	@JsonFormat(pattern = "yyyy년 M월 d일")
	private Date createdDate;
}
