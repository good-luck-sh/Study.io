package com.sample.exception;

public class RestLoginErrorException extends CustomException {

	private static final long serialVersionUID = 4937039711845427609L;

	public RestLoginErrorException(String message) {
		super(message);
	}
}
