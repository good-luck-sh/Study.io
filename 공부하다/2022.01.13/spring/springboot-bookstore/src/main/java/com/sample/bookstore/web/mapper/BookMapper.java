package com.sample.bookstore.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.bookstore.web.vo.Book;

@Mapper
public interface BookMapper {

	List<Book> getAllBooks();
}
