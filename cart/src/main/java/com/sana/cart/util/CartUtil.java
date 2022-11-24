package com.sana.cart.util;

import org.springframework.http.HttpStatus;

import com.sana.cart.model.ErrorMessage;

public class CartUtil {

	public static ErrorMessage  getErrorModel(String message , HttpStatus status) {
		
		return new ErrorMessage(message, status);
	}

}
