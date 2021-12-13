package kr.co.jhta.el.controller;

import java.util.ArrayList;
import java.util.List;

import com.sample.model2.controller.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ELSampleController2 implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<CartItem> firstCart = null;
		List<CartItem> secondCart = new ArrayList<>();
		List<CartItem> thirdCart = new ArrayList<>();
		thirdCart.add(new CartItem(10, "색연필", 2500, 0.01, 10));
		thirdCart.add(new CartItem(20, "오리털 패딩", 550000, 0.05, 1));
		thirdCart.add(new CartItem(30, "런닝화", 210000, 0, 2));
		thirdCart.add(new CartItem(40, "무릎보호대", 35000, 0.01, 5));
		thirdCart.add(new CartItem(50, "기모바지", 150000, 0.5, 2));
		
		request.setAttribute("cart1", firstCart);
		request.setAttribute("cart2", secondCart);
		request.setAttribute("cart3", thirdCart);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/views/el/sample2.jsp");
		requestDispatcher.forward(request, response);
	}
	
	public class CartItem {
		int no;
		String name;
		int price;
		double discountRate;
		int amount;
		public CartItem(int no, String name, int price, double discountRate, int amount) {
			super();
			this.no = no;
			this.name = name;
			this.price = price;
			this.discountRate = discountRate;
			this.amount = amount;
		}
		public int getNo() {
			return no;
		}
		public String getName() {
			return name;
		}
		public int getPrice() {
			return price;
		}
		public double getDiscountRate() {
			return discountRate;
		}
		public int getAmount() {
			return amount;
		}
		//할인비율(%단위)
		public double getDiscountPerCent( ) {
			return getDiscountRate()*100;
		}
		
		//할인 가격
		public int getDiscountPrice() {
			return (int)(price*(1-discountRate));
		}
		
		//구매가격
		public int getOrderPrice() {
			return getDiscountPrice()*amount;
		}
		//원래 멤버변수에는 존재하지 않지만 할인비율과 할인가격, 구매가격을 따로 설정한다. 
	}
}
