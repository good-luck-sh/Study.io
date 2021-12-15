package com.example.controller;

import java.util.List;

import com.example.dao.CategoryDao;
import com.example.vo.Category;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TodoFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*
		 * 1.모든 카테고리 정보를 조회한다. 
		 * 2.조회된 카테고리 정보를 요청객체에 "categoryList"라는 속성명으로 저장한다.
		 * 3. 내부이동할 URL을 반환한다.
		 */
		
		List<Category> categoryList =  CategoryDao.getInstance().getAllCategories();
		request.setAttribute("categoryList", categoryList);
		
		return "todo/form.jsp";
	}
}
