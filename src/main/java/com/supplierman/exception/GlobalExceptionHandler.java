package com.supplierman.exception;

import java.text.SimpleDateFormat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler 
{
	
	@ExceptionHandler(SupplierNameAlreadyExistException.class)
	public ResponseEntity<ErrorResponse2> handleProductNameAlreadyExistException(SupplierNameAlreadyExistException exception)
	{
		String timeStamp = new SimpleDateFormat("yyyy:MM:dd.HH:mm:ss").format(new java.util.Date());
		ErrorResponse2 response=new ErrorResponse2(timeStamp, exception.getMessage());
		return new ResponseEntity<ErrorResponse2>(response,HttpStatus.ALREADY_REPORTED);
	}
	
	
	@ExceptionHandler(SupplierNotFoundException.class)
	public ResponseEntity<ErrorResponse2> handleSupplierNotFoundException(SupplierNotFoundException exception)
	{
		String timeStamp = new SimpleDateFormat("yyyy:MM:dd.HH:mm:ss").format(new java.util.Date());
		ErrorResponse2 response=new ErrorResponse2(timeStamp, exception.getMessage());
		return new ResponseEntity<ErrorResponse2>(response,HttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public HashMap<String, Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
//	{
//		HashMap<String, Object> hmap = new HashMap<>();
//		hmap.put("Time", new Date());
//		BindingResult bindingResult = ex.getBindingResult();
//		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//		for (FieldError fieldError : fieldErrors) 
//		{
//			hmap.put(fieldError.getField(), fieldError.getDefaultMessage());
//			
//		}
//		return hmap;
//	}
	
	

  
}
	
