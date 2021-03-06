package com.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.BookDao;
import com.sample.form.Criteria;
import com.sample.vo.Book;

@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;

	public List<Book> getAllBookList(){
		return bookDao.getAllBooks();
	}
	
	public List<Book> searchBook(Criteria criteria){
		return bookDao.searchBooks(criteria);
	}
	public void addNewBook(Book book) {
		bookDao.insertBook(book);
	}
	
	public Book getBookDetail(int bookNo) {
		return bookDao.getBookByNo(bookNo);
	}
	
	public void updateBookPrice(int bookNo, int price, int discountPrice) {
		Book book = bookDao.getBookByNo(bookNo);
		book.setPrice(price);
		book.setDiscountPrice(discountPrice);
		
		bookDao.updateBook(book);
	}
	
	public void updateBookStock(int bookNo, int amount) {
		Book book = bookDao.getBookByNo(bookNo);
		book.setStock(book.getStock() + amount);
		
		bookDao.updateBook(book);
	}
	public void deleteBook(int bookNo) {
		bookDao.deleteBook(bookNo);
	}
	
}
