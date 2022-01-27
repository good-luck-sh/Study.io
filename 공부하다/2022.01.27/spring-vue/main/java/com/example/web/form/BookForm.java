package com.example.web.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookForm {

	private String title;
	private String author;
	private String publisher;
	private String description;
	private int price;
	private int discountPrice;
	private int amount;
}
