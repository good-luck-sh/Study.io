package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.sample.dao.CartItemDao;
import com.sample.dto.CarItemDto;
import com.sample.vo.CartItem;

@Service
public class CartItemService {

	@Autowired
	CartItemDao cartItemDao;
	
	public void addNewCartItem(int userNo, int bookNo) {
		try {
			CartItem cartItem = new CartItem();
			cartItem.setUserNo(userNo);
			cartItem.setBookNo(bookNo);
			
			cartItemDao.insertCartItem(cartItem);
		} catch (DataAccessException e) {
			throw new RuntimeException("동일한 책이 이미 장바구니에 저장되어 있습니다.");
		}
	}
	public void deleteCartItem(int userNo, int itemNo) {
		CartItem cartItem = cartItemDao.getCartItemByNo(itemNo);
		if(cartItem.getUserNo() != userNo) {
			throw new RuntimeException("다른 사용자의 장바구니는 삭제할 수 없습니다.");
		}
		cartItemDao.deleteCartItem(itemNo);
	}
	public List<CarItemDto> getMyCartItems(int userNo) {
		return cartItemDao.getCartItemsByUserNo(userNo);
	}
}
