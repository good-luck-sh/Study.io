package com.example.controller;

import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;

import com.example.dao.TodoDao;
import com.example.dto.Pagination;
import com.example.dto.TodoDto;
import com.example.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class TodoListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * 1.HttpSession객체를 획득한다. 
		 * 2.HttpSession에서 로그인된 사용자 정보를 조회한다. 
		 * 3.조회된 사용자정보가 null이면 로그인폼을 재요청하는 URL을 반환한다. 
		 * 			"redirect:/model2-todo/loginform.hta?error=required"
		 * 4.요청된 파라미터에서 page번호를 조회한다. 
		 * 	int PageNo= NumberUtils.toInt(request.getParameter("page"),1);
		 * 5.Dao객체를 이용해서 전체 일정 갯수를 조회한다. 
		 * 6.요청한 페이지번호와 전체일정갯수를 전달받아서 Pagination객체를 생성한다. 
		 * 		Pagination pagination = new Pagination(페이지 번호, 전체갯수);
		 * 7.페이지번호에 해당하는 조회범위를 조화한다. 
		 * 	int beginIndex = pagination.getBeginIndex();
		 * 	int endIndex = pagination.getEndIndex(); 
		 * 8. Dao객체를 이용해서 조회범위에 해당하는 일정목록을 조회한다. 
		 * 		List<TodoDto> todoDtoList = ...
		 * 9. 요청객체에 속성으로 Pagination객체와 List<TodoDto>객체를 저장한다. 
		 * 10.todo/list.jsp를 반환한다.	
		 *
		 */
		HttpSession session = request.getSession(); 
		
		User user = (User)session.getAttribute("loginUser");
		if(user == null) {
			return "redirect:/model2-todo/loginform.hta?error=required";
		}
		int pageNo = NumberUtils.toInt(request.getParameter("page"), 1);
		
		int totalTodo = TodoDao.getInstance().getTotalRows();
		Pagination pagin = new Pagination(pageNo, totalTodo);
		
		int beginIndex = pagin.getBeginIndex();
		int endIndex = pagin.getEndIndex();
		
		List<TodoDto> todoList = TodoDao.getInstance().getTodos(beginIndex, endIndex);
		
		request.setAttribute("todoList", todoList);
		request.setAttribute("pagin", pagin);
		
		return "todo/list.jsp";
	}
}
