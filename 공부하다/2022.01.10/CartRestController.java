package com.sample.restcontroller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.annotation.LoginedUser;
import com.sample.argumentResolver.LoginedUserArgumentResolver;
import com.sample.dto.ResponseDto;
import com.sample.exception.CartErrorException;
import com.sample.exception.LoginErrorException;
import com.sample.service.CartItemService;
import com.sample.util.SessionUtils;
import com.sample.vo.User;

@RestController
@RequestMapping("/rest/cart")
public class CartRestController {

	static final Logger logger = LogManager.getLogger(CartRestController.class);//로고를 가져온다.
	
	@Autowired
	CartItemService cartItemService;
	
	@GetMapping("/counts.do")
	public ResponseDto<Integer> getCartItemCounts(){
		User user = (User)(SessionUtils.getAttribute("LOGIN_USER"));
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		response.setStatus("OK");
		response.setItems(List.of(0));	//처음에는 0개의 숫자를 전달하고
		
		if(user != null) {
			int cartItemsCount = cartItemService.getMyCartItems(user.getNo()).size();
			response.setItems(List.of(cartItemsCount)); // {status:"OK", error:null}이렇게 들어감
		} 
		return response;
		
	}
	
	
	@GetMapping("/add.do")
	public ResponseDto<?> add(@LoginedUser User user,int bookNo) {
		//User user = (User)(SessionUtils.getAttribute("LOGIN_USER"));
		if(user == null) {
			throw new CartErrorException("장바구니 아이템 추가는 로그인 후 가능합니다");
		}
		//service를 검색해서 필요한 매개변수가 무엇인지 확인하는 것이 중요하다.예외를 던지는 친구다.
			//장바구니에 정보를 추가시킨다. 
			cartItemService.addNewCartItem(user.getNo(), bookNo);
			int cartItemsCount = cartItemService.getMyCartItems(user.getNo()).size();
			//장바구니에 동일한 상품이 있으면 에러가 나온다. 정상적일 때 OK라는 응답이 내려온다.
			ResponseDto<Integer> response = new ResponseDto<>();
			//?는 아무거나 와도 상관없다. 
			response.setStatus("OK");
			response.setItems(List.of(cartItemsCount));
			return response;
	
	}
	
	@GetMapping("/delete.do")
	public ResponseDto<?> delete(@LoginedUser User user, int no) {//아무거나 와도 상관없다 <?>
		//SessionUtil를 사용해서 세션객체에 저장된 인증된 사용자 정보를 조회한다.
		//User user = (User)(SessionUtils.getAttribute("LOGIN_USER"));
		if(user == null) {
			throw new CartErrorException("장바구니 아이템 삭제는 로그인 후 가능합니다");
		}
		
			//성공한 경우 내려질 내용
		cartItemService.deleteCartItem(user.getNo(), no);
		int cartItemsCount = cartItemService.getMyCartItems(user.getNo()).size();//몇개있는지 조회한다. 
		
		ResponseDto<Integer> response = new ResponseDto<>();
		response.setStatus("OK");
		response.setItems(List.of(cartItemsCount));	//카운트를 넣어서 보낸다.
		return response;
		
	}
	
}
