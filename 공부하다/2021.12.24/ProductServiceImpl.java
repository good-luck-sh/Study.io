package com.sample.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.sample.vo.Product;

@Component
@Primary
public class ProductServiceImpl implements ProductService{

	@Override
	public Product getProductByNo(int no) {
		return new Product(100, "애플워치", "애플", 650000, 610000);
	}

}
