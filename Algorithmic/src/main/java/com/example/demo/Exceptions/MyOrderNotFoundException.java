package com.example.demo.Exceptions;

public class MyOrderNotFoundException extends RuntimeException {
	
	
	 public MyOrderNotFoundException(String message) {
	        super(message);
	    }

	    public MyOrderNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }

}
