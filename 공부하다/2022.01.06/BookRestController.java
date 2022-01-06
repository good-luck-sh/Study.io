package com.sample.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.service.BookService;
import com.sample.vo.Book;
/*
 * @RestController
 * 	-요청핸들러 메소드가 반환하는 값을 응답메세지의 body에 포함시킨다.
 * 	-jackson-databind 라이브러리가 프로젝트에 포함되어 있으면 요청핸들러 메소드가 반환하는 값을 json형식의 텍스트로 변환한 다음
 * 	응답메세지의 body부에 포함시켜서 클라이언트로 보낸다. 
 * 	-@RestController를 사용하는 대신 아래와 같이 적어도 동일하게 동작한다.
 *  		@Controller //@RestController 대신 @Controller를 적었다. 
 *  		@RequestMapping("/rest/book")
 *  		public class BookRestController{
 *  			@Autowired
 *  			BookService bookservice;
 *  			@GetMapping("/detail.do")
 *  			public @ResponseBody Book detail(int no) { //@ResponseBody이렇게 반환타입 앞에 어노테이션을 붙여야한다.
 *  			Book book = bookService.getBookDetail(no);
 *  			return book;
 *  		}
 * 		
 *  			@GetMapping("/detail.do")
 *  			@ResponseBody				//요청핸들러 메소드에 붙인다. 
 *  			public  Book detail(int no) { //@ResponseBody이렇게 반환타입 앞에 어노테이션을 붙여야한다.
 *  			Book book = bookService.getBookDetail(no);
 *  			return book;
 *  		}
 *  			//응답객체에 정보를 보내는 방법이다.
 *  어노테이션이나 restController라고 따로 지정하지 않으면 book/detail.jsp를 찾는다. Book을 반환하는 것이 아닌 jsp페이지를 찾아간다.
 */
@RestController
@RequestMapping("/rest/book")
public class BookRestController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/detail.do")
	public Book detail(int no) {
		//restController는 반환값이 객체를 보내주기 때문에 String이 아닌 객체의 이름을 붙인다. 
		//요청할 때 rest/book.do?no=로 받나오면 된다. 
		//객체를 JSON으로 변환해주는 라이브러리가 필요하다. 
		Book book = bookService.getBookDetail(no);
		return book;	//그정보를 그대로 보내준다. 값이 들어있는 객체를 전달하면 끝이다.
	}
}
