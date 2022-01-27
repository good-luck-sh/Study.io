package com.example.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Book {

	private int no;
	private String title;
	private String author;
	private String publisher;
	private String description;
	private int price;
	private int discountPrice;
	private int stock;
	private Date updatedDate;
	private Date deletedDate;
}
