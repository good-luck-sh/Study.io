package com.sample.bookstores.web.model;

import lombok.Getter;
import lombok.Setter;
/**
 * 클라이언트에게 데이터가 하나 전달되는 응답메세지를 표현하는 클래스다.
 * @author lion3
 *
 * @param <T> 데이터 타입
 */
@Getter
@Setter
public class SingleResponseData<T> extends ResponseData {

	private T item;	
}
