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
	//HttpServlet은 ApachiTomcate라이브러리내부에 jakarto.servlet.http를 상속받는다.
	//Tomcat은 웹서버에 대한 모든 라이브러리를 가지고 있다.
	//Jsp에 필요한 라이브러리를 가지고 있고, 사용하고 있다. 톰캣을 저장하지 않으면 사용할수없다.

	private static final long serialVersionUID = 339661543186959731L;
	//시리얼 넘버를 상수로 부여한다. 
	private Map<String, Controller> controllers = new HashMap<>();
	//조상이 hashMap의 형태로 키와 값의 형태인 Map의 배열을 생성했다. 
	//요청 URL을 Key로 controller객체를 value로 가지는 Map객체 생성
	
	//FrontControllerservlet의 초기화 메소드에서 애플리케이션에서 사용하는 모든 Controller객체를 생성해서 
	//요청 URL, Controller객체의 쌍으로 Map객체에 저장한다.
	public void init() throws ServletException {
		//init, service, destroy init는 초기화 메소드이다.
		controllers.put("/home.hta", new HomeController());
		///home.hta가 발생하면 해당하는 컨트롤러를 Map배열에 추가한다. 
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
	//FrontControllerServlet의 서비스메소드는 *.hta요청이 올때마다 실행되는 메소드이다.
	//1.요청 URL을 알아낸다. 
	//2.요청 URL에 맞는 Controller객체를 Map객체에서 가져온다. 
	//3.Map객체에서 가져온 Controller객체의 execute(request,response)메소드를 실행한다. 
	//4.execute(request, response)메소드를 실행하면 URL을 반환값으로 받는다. 
	//5.execute(request, response)메소드가 반환한 URL을 분석해서 JSP로 내부이동해서 JSP를 실행시켜 HTML응답을 제공하거나 
	//	재요청 URL을 응답으로 제공한다. 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1.요청 URL을 알아낸다.
			String requestURI = request.getRequestURI().replace(request.getContextPath(), "");
			//요청객체를 통해 요청 URI이 들어오면 해당하는 요청객체의 경로를 잘라낸다. 
			//2.요청 URL에 맞는 Controller객체를 Map객체에서 가져온다. 
			Controller controller = controllers.get(requestURI);
			//컨트롤러객체에 잘라낸 요청URI를 Map에 저장되있는 이름값으로 값을 찾는다.
			if (controller == null) {
				//컨트롤러가 null이라면 
				throw new RuntimeException("요청 URI에 대응되는 컨트롤러가 존재하지 않습니다.");
				//해당 예외를 생성하여 던진다. 
			}
			//3.Map객체에서 가져온 Controller객체의 execute(request,response)메소드를 실행한다.
			//4.execute(request, response)메소드를 실행하면 URL을 반환값으로 받는다. 
			String path = controller.execute(request, response);
			//컨트롤러의 요청객체와 응답객체를 매개변수로하는 입력받는 메소드를 문자열에 저장한다.
			if (path == null) {
				//문자열의 참조변수가 null이라면
				throw new RuntimeException("내부이동 혹은 재요청할 경로가 null입니다.");
			}
			//5.execute(request, response)메소드가 반환한 URL을 분석해서 JSP로 내부이동해서 JSP를 실행시켜 HTML응답을 제공하거나 
			//	재요청 URL을 응답으로 제공한다. 
			if (path.startsWith("redirect:")) {
				//문자열의 참조변수가 redirect:로 시작된다면
				//재요청 URL을 응답으로 제공한다.
				response.sendRedirect(path.replace("redirect:", ""));
				//응답객체에 문자열을 넣고보내는데, 문자열의 redirect는 반칸으로 변경하여 보낸다.
			} else {
				// /WEB-INF/views/ 폴더의 jsp로 클라이언트의 요청을 내부이동 시켜서 JSP를 실행하고, HTML을 응답으로 제공하게 한다.
				path = "/WEB-INF/views/" + path;
				//문자열이 참조변수로 redirect:로 시작되지 않는다면, 문자열에 /WEB-INF/views/를 붙여서 문자열을 출력한다.
				request.getRequestDispatcher(path).forward(request, response);
				//내부이동을 진행한다.
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
