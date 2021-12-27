package com.sample.service;

import com.sample.vo.Product;

public class ProductServiceImpl {

	public Product getProductByNo(int no) {
		return new Product(100, "애플워치", "애플", 650000, 610000);
	}
}
