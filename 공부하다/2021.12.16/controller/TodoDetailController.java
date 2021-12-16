package com.example.controller;

import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;

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
/*
 * 1. "model2-todo/tod/detail.hta"요청을 처리하는 컨트롤러다.
 * 2. 요청객체에서 일정번호를 조회한다. 
 * 3. 일정번호에 해당하는 일정정보(TodoDao)를 조회한다. 
 * 4. 전체 카테고리 정보(List<Category>)를 조회한다.
 * 5. 전체 일정상태 정보(List<Status>)를 조회한다. 
 * 6. 요청객체에 속성으로 일정정보, 전체카테고리정보, 전체일정상태정보를 저장한다. 
 * 
 */
public class TodoDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*
		 * 1.HttpSession객체를 획득한다. 
		 * 2.HttpSession에서 인증된 사용자정보를 조회한다. 
		 * 3.사용자 정보가 null이면 로그인폼을 재요청하는 URL을 반환한다. 
		 * 4.요청파라미터에서 일정번호를 조회한다. 
		 * 5.일정번호에 해당하는 일정 상세정보(TodoDto)를 조회한다. 
		 * 6.일정수정에 필요한 전체 카테고리 목록(List<Category>)를 조회한다. 
		 * 7.일정수정에 필요한 전체 일정상태 목록(List<Status>)를 조회한다. 
		 * 8.요청객체에 속성으로 일정상세정보를 저장한다. 
		 * 9.요청객체에 속성으로 전체 카테고리 목록을 저장한다. 
		 * 10.요청객체에 속성으로 전체 일정상태목록을 저장한다. 
		 * 11.내부이동할 jsp경로를 반환한다.
		 */
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		if(user == null) {
			return "redirect:/model2-todo/loginform.hta?error=required";
		}
		
		int no =  NumberUtils.toInt(request.getParameter("no"));
		
		TodoDto todoDto = TodoDao.getInstance().getTodo(no);
		List<Category> category = CategoryDao.getInstance().getAllCategories();
		List<Status> status = StatusDao.getInstance().getAllStatus();
		
		request.setAttribute("status", status);
		request.setAttribute("category", category);
		request.setAttribute("todoDto", todoDto);
		
		return "todo/detail.jsp";
	}
}
