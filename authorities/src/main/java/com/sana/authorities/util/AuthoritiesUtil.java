package com.sana.authorities.util;

import org.springframework.http.HttpStatus;

import com.sana.authorities.model.ErrorMessage;


public class AuthoritiesUtil {
	public static ErrorMessage  getErrorModel(String message , HttpStatus status) {
		
		return new ErrorMessage(message, status);
	}
}
