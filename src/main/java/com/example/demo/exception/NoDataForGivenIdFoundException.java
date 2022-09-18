package com.example.demo.exception;

import lombok.Setter;


public class NoDataForGivenIdFoundException extends RuntimeException {

	private String message="No data for given id found";
	
	public NoDataForGivenIdFoundException() {
	}
	public NoDataForGivenIdFoundException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
