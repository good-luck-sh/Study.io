package com.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.dto.PayReadyResponseDto;
import com.example.entity.Book;
import com.example.service.BookService;
import com.example.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/form")
	public String form(@RequestParam(name = "id") long id, Model model) {
		
		Book book = bookService.getBook(id);
		model.addAttribute("book", book);
		
		return "order/form";
	}
	
	@GetMapping("/pay")
	public @ResponseBody PayReadyResponseDto pay(@RequestParam(name = "id") long id,
			@RequestParam(name = "quantity") int quantity,
			@RequestParam(name = "total_amount") int totalAmount) {
		
		Book book = bookService.getBook(id);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "KakaoAK 3e168fa6b46ea4b83a4b7f9195e27db5");
		headers.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.add("cid", "TC0ONETIME");
		parameters.add("partner_order_id", String.valueOf(System.currentTimeMillis()));
		parameters.add("partner_user_id", "jhta");
		parameters.add("item_name", book.getTitle());
		parameters.add("item_code", String.valueOf(book.getId()));
		parameters.add("quantity", String.valueOf(quantity));
		parameters.add("total_amount", String.valueOf(totalAmount));
		parameters.add("tax_free_amount", "0");
		parameters.add("approval_url", "http://localhost/order/pay/completed");
		parameters.add("cancel_url", "http://localhost/order/pay/cancel");
		parameters.add("fail_url", "http://localhost/order/pay/fail");
		
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, headers);
		
		RestTemplate template = new RestTemplate();
		String url = "https://kapi.kakao.com/v1/payment/ready";
		PayReadyResponseDto dto = template.postForObject(url, requestEntity, PayReadyResponseDto.class);
		System.out.println(dto);
		
		return dto;
	}
}
