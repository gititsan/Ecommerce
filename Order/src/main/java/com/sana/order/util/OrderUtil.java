package com.sana.order.util;

import org.springframework.http.HttpStatus;

import com.sana.order.model.ErrorMessage;

 
public class  OrderUtil {
	public static ErrorMessage  getErrorModel(String message , HttpStatus status) {
		
		return new ErrorMessage(message, status);
	}
}
