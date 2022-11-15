package com.sana.product.util;

import org.springframework.http.HttpStatus;

import com.sana.product.model.ErrorMessage;
 

public class ProductUtil {
	public static ErrorMessage  getErrorModel(String message , HttpStatus status) {
		
		return new ErrorMessage(message, status);
	}
}
