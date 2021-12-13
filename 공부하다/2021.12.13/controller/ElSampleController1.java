package kr.co.jhta.el.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sample.model2.controller.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.jhta.vo.User;

public class ElSampleController1 implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//HttpSession객체 획득하기
		//클라이언트가 최초 접속시 생성되고, 로그아웃하면 사라지는 객체
		HttpSession session = request.getSession();
		
		//ServletContext객체 획득하기 
		//웹서버가 켜질 때 생성되고, 웹서버가 종료될때 사라지는 객체
		ServletContext application = request.getServletContext();
		
		//기본자료형타입의 값을 속성으로 저장하고 JSP에서 EL로 표현하기 
		request.setAttribute("message", "EL 연습하기 페이지 방문을 환영합니다.");
		request.setAttribute("viewCount", 1000);
		request.setAttribute("userDeleted", true);
		request.setAttribute("discountRate", 0.01);
		
		//String타입의 값을 속성으로 저장하고 JSP에서 EL로 표현하기 
		request.setAttribute("deptName", "경영지원팀");
		request.setAttribute("deptname", "경영지원팀");
		
		//배열타입의 값을 속성으로 저장하고 JSP에서 EL로 표현하기
		String[] names = {"김유신", "이순신", "홍길동"};
		int[] scores = {100, 90, 80, 100, 80};
		request.setAttribute("names",names);
		request.setAttribute("scores", scores);
		
		//객체타입의 값을 속성으로 저장하고 JSP에서 EL로 표현하기
		User user1 = new User("hong","zxcv1234","홍길동",new Date());
		User user2 = new User("kim","zxcv2222","김유신",new Date());
		User user3 = new User("lee","zxcv3333","이순신",new Date());
		request.setAttribute("user1", user1);
		request.setAttribute("user2", user2);
		request.setAttribute("user3", user3);
		
		//List타입의 값을 속성으로 저장하고 JSP에서 EL로 표현하기
		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		request.setAttribute("users", userList);
		
		//Map타입의 값을 속성으로 저장하고 JSP에서 EL로 표현하기
		Map<String,Object> map = new HashMap<>();
		map.put("id", 10000);
		map.put("name","영업1팀");
		map.put("manager","류관순");
		map.put("adress", "서울특별시 종로구 봉익동 디아망빌딩 401호");
		map.put("tel", "02-1111-2222");
		request.setAttribute("dept", map);
		
		//요청객체에 속성으로 저장된 데이터를 표현할 JSP로 내부이동 시키기
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/el/sample1.jsp");
		requestDispatcher.forward(request,response);
	}

}
