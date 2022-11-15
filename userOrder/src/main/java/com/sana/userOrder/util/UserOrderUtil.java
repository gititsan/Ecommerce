package com.sana.userOrder.util;

import org.springframework.http.HttpStatus;

import com.sana.userOrder.model.ErrorMessage;

 
public class UserOrderUtil {
	public static ErrorMessage  getErrorModel(String message , HttpStatus status) {
		
		return new ErrorMessage(message, status);
	}
}
