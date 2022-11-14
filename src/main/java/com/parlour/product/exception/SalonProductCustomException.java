package com.parlour.product.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SalonProductCustomException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ProductNotFoundException.class)
   public ResponseEntity<ErrorResponse> productIdNotFoundExcep(ProductNotFoundException pNFE, WebRequest req){
	    ErrorResponse errRes=new ErrorResponse();
	    
		String msg=pNFE.getMessage();
		List<String> errorMsgs=new ArrayList<>();
		errorMsgs.add(pNFE.getLocalizedMessage());
		errRes.setErrorMsg(msg);
		errRes.setErrors(errorMsgs);
		return new ResponseEntity<ErrorResponse>(errRes, HttpStatus.BAD_REQUEST);
	}
		
	
}
