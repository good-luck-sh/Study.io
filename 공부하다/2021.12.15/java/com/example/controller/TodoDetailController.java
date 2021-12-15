package com.example.controller;

import java.util.List;

import com.example.dao.CategoryDao;
import com.example.dao.StatusDao;
import com.example.dao.TodoDao;
import com.example.dto.TodoDto;
import com.example.vo.Category;
import com.example.vo.Status;
import com.example.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class TodoDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		if(user == null) {
			return "redirect:/model2-todo/loginform.hta?error=required";
		}
		
		int no = Integer.parseInt(request.getParameter("no"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		TodoDto todoDto = TodoDao.getInstance().getTodo(no);
		List<Category> category = CategoryDao.getInstance().getAllCategories();
		List<Status> status = StatusDao.getInstance().getAllStatus();
		
		request.setAttribute("no", no);
		request.setAttribute("status", status);
		request.setAttribute("category", category);
		request.setAttribute("todoDto", todoDto);
		request.setAttribute("page", page);
		
		return "todo/detail.jsp";
	}
}
