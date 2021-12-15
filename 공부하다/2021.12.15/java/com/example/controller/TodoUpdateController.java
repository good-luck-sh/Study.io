package com.example.controller;

import java.util.Date;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.example.dao.TodoDao;
import com.example.dto.TodoDto;
import com.example.vo.Todo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class TodoUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		String title = request.getParameter("title");
		Date dueDate = DateUtils.parseDate(request.getParameter("dueDate"),"yyyy-MM-dd");
		int statusNo = Integer.parseInt(request.getParameter("statusNo"));
		String content = request.getParameter("content");
	
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
