package com.sample.bookstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.bookstore.vo.Book;

@Mapper
public interface BookMapper {

	List<Book> getAllBooks();
	void updateBook(Book book);
	void deleteBook(int no);
	void insertBook(Book book);
	Book getBookByNo(int no);
	
}
