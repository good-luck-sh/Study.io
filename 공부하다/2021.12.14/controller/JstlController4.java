package kr.co.jhta.jstl.controller;

import java.util.Date;

import com.sample.model2.controller.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JstlController4 implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Date today = new Date();
		long balance = 25000000000L;
		
		request.setAttribute("today", today);
		request.setAttribute("balance", balance);
		
		request.getRequestDispatcher("/WEB-INF/views/jstl/sample4.jsp").forward(request, response);
		
	}

}
