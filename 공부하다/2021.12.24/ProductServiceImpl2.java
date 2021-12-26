package com.sample.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.sample.vo.Product;

@Component
//@Primary
public class ProductServiceImpl2 implements ProductService {

	@Override
	public Product getProductByNo(int no) {
		return new Product(200,"갤럭시워치","삼성전자",500000,450000);
	}

}
