package com.example.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.hta")
public class FrontControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 339661543186959731L;
	private Map<String, Controller> controllers = new HashMap<>();
	
	public void init() throws ServletException {
		controllers.put("/home.hta", new HomeController());
		controllers.put("/loginform.hta", new LoginFormController());
		controllers.put("/login.hta", new LoginController());
		controllers.put("/logout.hta", new LogoutController());
		controllers.put("/todo/list.hta", new TodoListController());
		controllers.put("/todo/detail.hta", new TodoDetailController());
		controllers.put("/todo/form.hta", new TodoFormController());
		controllers.put("/todo/insert.hta", new TodoInsertController());
		controllers.put("/todo/update.hta", new TodoUpdateController());
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String requestURI = request.getRequestURI().replace(request.getContextPath(), "");
			Controller controller = controllers.get(requestURI);
			if (controller == null) {
				throw new RuntimeException("요청 URI에 대응되는 컨트롤러가 존재하지 않습니다.");
			}
			String path = controller.execute(request, response);
			if (path == null) {
				throw new RuntimeException("내부이동 혹은 재요청할 경로가 null입니다.");
			}
			if (path.startsWith("redirect:")) {
				response.sendRedirect(path.replace("redirect:", ""));
			} else {
				path = "/WEB-INF/views/" + path;
				request.getRequestDispatcher(path).forward(request, response);
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
