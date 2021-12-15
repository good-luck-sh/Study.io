package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import com.example.dao.TodoDao;
import com.example.vo.Todo;
import com.example.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class TodoInsertController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 *   요청객체에서 HttpSession객체를 획득한다. 
		 * 0.세션객체에서 로그인 사용자 정보를 조회한다.
		 *   로그인 사용자 정보가 null이면 "redirect:/model2-todo/loginform.hta?error=required"를 회득한다.
		 * 1.todo/form.jsp가 제출할 값을 조회한다. 
		 * 		처리예정일은 java.util.Date 타입으로 변환한다.
		 * 		Date dueDate = DateUtils.ParseDate(날짜,"yyyy-MM-dd")
		 * 2. Todo객체를 생성해서 조회된 값을 저장한다. 
		 * 		카테고리번호, 제목, 처리예정일, 사용자번호, 내용을 Todo객체에 저장한다. 
		 * 3. Todo객체를 dao에 전달해서 저장시킨다.
		 * 4. 화면목록을 재요청하는 URL을 응답으로 보낸다. 
		 */
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		if(user == null) {
			return "redirect:/model2-todo/loginform.hta?error=required";
		}
		
		int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Date date = DateUtils.parseDate(request.getParameter("dueDate"),"yyyy-MM-dd");
		
		Todo todo = new Todo();
		todo.setCategoryNo(categoryNo);
		todo.setTitle(title);
		todo.setDueDate(date);
		todo.setUserNo(user.getNo());
		todo.setContent(content);
		
		TodoDao.getInstance().insertTodo(todo);
		
		return "redirect:/model2-todo/todo/list.hta";
	}
}
