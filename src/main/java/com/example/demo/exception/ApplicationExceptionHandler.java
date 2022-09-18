package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.dto.ResponseStructure;


@ControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler(value = NoDataForGivenIdFoundException.class)
	public ResponseEntity<ResponseStructure<String>> NoDataForGivenIdFoundExceptionHandler(NoDataForGivenIdFoundException ie){
		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setData(ie.getMessage());
		rs.setStatusCode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("There is no data found for the id provided by the user");
		
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}

}
