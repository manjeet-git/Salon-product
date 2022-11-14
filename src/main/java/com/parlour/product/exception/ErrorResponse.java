package com.parlour.product.exception;

import java.util.List;

public class ErrorResponse {
    String errorMsg;
    List<String> errors;
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	@Override
	public String toString() {
		return "ErrorResponse [errorMsg=" + errorMsg + ", errors=" + errors + "]";
	}
    
    
}
