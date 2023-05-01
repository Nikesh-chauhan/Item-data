package com.nikesh.itemdataload.exceptionhandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorLogic extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ItemNotFoundException.class)
	public final ResponseEntity<Object> handleItemNOtFoundException(Exception ex,WebRequest request) throws Exception{
		ErrorDetails er=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(ex,HttpStatus.NOT_FOUND);
	}

}
