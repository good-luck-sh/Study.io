package com.sample.bookstore.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.bookstore.web.service.BookService;
import com.sample.bookstore.web.vo.Book;

@CrossOrigin(origins = "*")//전체를 선택한다. "http://localhost:8080"이렇게 허용해놓아도 된다.
@RestController //전부 restController이다.JSON데이터로 보내기 때문
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<Book> books() {
		return bookService.getAllBooks();
	}
}
