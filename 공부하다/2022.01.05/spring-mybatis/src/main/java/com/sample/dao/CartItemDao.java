package com.sample.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.dto.CarItemDto;
import com.sample.vo.CartItem;

@Mapper
public interface CartItemDao {

	void insertCartItem(CartItem cartItem);
	void deleteCartItem(int no);
	List<CarItemDto> getCartItemsByUserNo(int userNo);
	CartItem getCartItemByNo(int no);
}
