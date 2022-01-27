package com.example.web.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleResponseData<T> extends ResponseData {

	private T item;
}
