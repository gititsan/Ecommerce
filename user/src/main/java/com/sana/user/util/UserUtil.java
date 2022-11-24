package com.sana.user.util;

import org.springframework.http.HttpStatus;

import com.sana.user.model.ErrorMessage;
 

public class UserUtil {
	public static ErrorMessage  getErrorModel(String message , HttpStatus status) {
		
		return new ErrorMessage(message, status);
	}
}
