package com.sample.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sample.service.BookService;
import com.sample.vo.Book;

public class BookListApplivation {

	public static void main(String[] args) {
		
		String resource = "C:\\spring-workspace\\spring-mybatis\\src\\main\\webapp\\WEB-INF\\spring\\context-root.xml";
		
		ApplicationContext ctx = new FileSystemXmlApplicationContext(resource);
		//classpathxml을 사용하면 경로를 찾지못해서 FileSystem으로 지정해서 확인하는 작업을 거쳤다.
		BookService service = ctx.getBean(BookService.class);
		List<Book> books = service.getAllBookList();
		System.out.println(books);
	}
}
