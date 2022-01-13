package com.sample.bookstore.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.bookstore.web.mapper.BookMapper;
import com.sample.bookstore.web.vo.Book;

@Service
public class BookService {

	@Autowired
	private BookMapper bookmapper;
	
	public List<Book> getAllBooks(){
		return bookmapper.getAllBooks();
	}
}
