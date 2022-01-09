package com.sample.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
//mybatis에 들어가면 ibatis로 패키지 설정되어있음
import org.apache.ibatis.annotations.Param;

import com.sample.form.Criteria;
import com.sample.vo.Book;
import com.sample.vo.BookPicture;

@Mapper
public interface BookDao {

	//mapper인터페이스이다. 데이터베이스 엑세스 작업이 작성된 인터페이스이다. 
	void insertBook(Book book);
	void updateBook(Book book);
	List<Book> getAllBooks();	
	List<Book> searchBooksByTitle(String title);
	List<Book> searchBooksByPrice(@Param("minPrice") int minPrice,@Param("maxPrice") int maxPrice);
	int getBookTotalRows(Criteria criteria);
	Book getBookByNo(int no);
	void deleteBook(int no);
	List<Book> searchBooks(Criteria criteria);
	
	void insertBookPicture(BookPicture bookPicture);
	List<BookPicture> getBookPicturesByBookNo(int bookNo);
}
