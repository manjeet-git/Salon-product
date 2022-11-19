package com.parlour.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RareCombinationException extends RuntimeException{

	String msg;
	
	public RareCombinationException(String msg) {
		super(msg);
	}
}
