package kr.co.jhta.controller;

import java.util.List;

import com.sample.model2.controller.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jhta.dao.BoardDao;
import kr.co.jhta.vo.Board;

public class HomeController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HomeController.execute(request, response) 실행");
		
		//home.jsp에 환영메세지를 전달해서 출력시키기 
		String greeting = "홈체이지 방문을 환영합니다. ";
		
		//요청객체에 속성으로 전달할 값을 저장한다. 
		request.setAttribute("message", greeting);
		//greeting이라는 글자를 message라는 이름으로 저장했다
		
		//최신글 5개 조회하기
		BoardDao boardDao = new BoardDao();
		List<Board> boards = boardDao.findAll();
		//전체를 조회한다. 
		boards = boards.subList(1, 5);
		//전체에서 5개를 가져온다. 
		//요청객체에 속성으로 전달할 값을 저장한다. 
		request.setAttribute("boardList", boards);
		//요청객체에 이름만 다르게 여러개를 저장해도된다. 
		
		//home.jsp로 이동 -->프론트컨트롤러가 알아서한다.
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
		//요청받은 것을 다른 곳으로 보낸다. 그것이 RequsetDispatcher이다.
		requestDispatcher.forward(request, response);
		//forward에 request와 response에 전달해주고 있다. 받은 것을 전달한다. 
		
	}

}
