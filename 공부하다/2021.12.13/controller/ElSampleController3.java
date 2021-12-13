package kr.co.jhta.el.controller;

import com.sample.model2.controller.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ElSampleController3 implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.getRequestDispatcher("/WEB-INF/views/el/sample3.jsp").forward(request, response);
		
	}
	
}
