package com.parlour.product.exception;

import javax.persistence.metamodel.StaticMetamodel;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ProductTypeNotFoundException extends RuntimeException{
     String msg;
     
     public ProductTypeNotFoundException(String msg) {
    	 super(msg);
     }
}
