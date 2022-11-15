package com.sana.category.util;

import org.springframework.http.HttpStatus;

import com.sana.category.model.ErrorMessage;

 

public class CategoryUtil {
	public static ErrorMessage  getErrorModel(String message , HttpStatus status) {
		
		return new ErrorMessage(message, status);
	}
}
