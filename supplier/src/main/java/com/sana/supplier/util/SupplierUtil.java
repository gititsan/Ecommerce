package com.sana.supplier.util;

import org.springframework.http.HttpStatus;

import com.sana.supplier.model.ErrorMessage;

public class SupplierUtil {
	
	public static ErrorMessage  getErrorModel(String message , HttpStatus status) {
		
		return new ErrorMessage(message, status);
	}

}
