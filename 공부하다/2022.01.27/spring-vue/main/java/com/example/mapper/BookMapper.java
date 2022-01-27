package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.Book;

@Mapper
public interface BookMapper {

	void insertBook(Book book);
	List<Book> getBooks();
	Book getBooByNo(int no);
	void updateBook(Book book);
	void deleteBook(int no);
}
