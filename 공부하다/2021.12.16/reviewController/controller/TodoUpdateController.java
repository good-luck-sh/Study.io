package com.example.controller;

import java.util.Date;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.example.dao.TodoDao;
import com.example.dto.TodoDto;
import com.example.vo.Todo;
import com.example.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class TodoUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 *1. HttpSession객체 획득하기 
		 *2. 인증된 사용자 정보 조회하기 
		 *3. 사용자정보가 null이면 로그인폼을 요청하는 URL을 응답으로 보내기 
		 *4.제출된 요청파라미터값을 조회하기, no/page/categoryNo/title/dueDate/statusNo/content값을 조회한다.
		 *5.일정번호에 해당하는 일정정보를(TodoDto)를 조회한다.
		 *6.일정정보의 사용자번호와 로그인한 사용자번호를 비교해서 서로 다르면 상세화면을 재요청하는 URL을 응답으로 보낸다. 
		 *7.Todo객체를 생성해서 no, categoryNo, title, dueDate,content정보를 저장한다.
		 *8.TodoDao객체의 updateTodo(Todo todo)를 실행해서 변경된 내용을 테이블에 반영한다.
		 *9.일정상세화면을 요청하는 URL("redirect:/model2-todo/todo/detail.hta?no="+ no +"&page=" +page")을 반환한다.
		 */
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		if(user == null) {
			return "redirect:/model2-todo/loginform.hta?error=required";
		}
		
		int no = NumberUtils.toInt(request.getParameter("no"));
		int page = NumberUtils.toInt(request.getParameter("page"),1);
		int categoryNo = NumberUtils.toInt(request.getParameter("categoryNo"));
		String title = request.getParameter("title");
		Date dueDate = DateUtils.parseDate(request.getParameter("dueDate"),"yyyy-MM-dd");
		int statusNo = NumberUtils.toInt(request.getParameter("statusNo"));
		String content = request.getParameter("content");
		
		TodoDto todoDto = TodoDao.getInstance().getTodo(no);
		
		if(todoDto.getUserNo() != user.getNo()) {
			return "redirect:/model2-todo/todo/detail.hta?no="+ no +"&page=" + page;
		}
	
		Todo todo = new Todo();
		todo.setNo(no);
		todo.setCategoryNo(categoryNo);
		todo.setTitle(title);
		todo.setDueDate(dueDate);
		todo.setStatusNo(statusNo);
		todo.setContent(content);
		
		TodoDao.getInstance().updateTodo(todo);
		
		return "redirect:/model2-todo/todo/detail.hta?no="+ no +"&page=" +page;
	}
}
