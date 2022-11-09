package com.revature.Aspect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.revature.exceptions.UserNotFoundException;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(HttpServletRequest req, UserNotFoundException exc){
		String errorMessage = "User not found";
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
	}

}
