package com.parlour.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ProductNotFoundException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1815806635354055813L;
	
	String exceptionMsg;
	
	public ProductNotFoundException(String exceptionMsg) {
		super(exceptionMsg);
	}
	
}
