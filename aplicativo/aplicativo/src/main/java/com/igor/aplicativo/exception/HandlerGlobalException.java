package com.igor.aplicativo.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class HandlerGlobalException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	private ResponseEntity<ErroDetails> resourceNotFoundException(ResourceNotFoundException e,WebRequest webRequest){                                   
		ErroDetails erroDetails = ErroDetails.builder()
											.message(e.getMessage())
											.timesTamp(LocalDateTime.now())
											.path(webRequest.getDescription(false))
											.erroCode(HttpStatus.NOT_FOUND)
											.build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroDetails);
	}
	
	@ExceptionHandler(BadRequestException.class)
	private ResponseEntity<ErroDetails> badRequestException(BadRequestException e,WebRequest webRequest){                                   
		ErroDetails erroDetails = ErroDetails.builder()
											.message(e.getMessage())
											.timesTamp(LocalDateTime.now())
											.path(webRequest.getDescription(false))
											.erroCode(HttpStatus.BAD_REQUEST)
											.build();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroDetails);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	private ResponseEntity<ErroDetails> methodArgumentNotValidException(MethodArgumentNotValidException e,WebRequest webRequest){                                   
		ErroDetails erroDetails = ErroDetails.builder()
											.message(e.getMessage())
											.timesTamp(LocalDateTime.now())
											.path(webRequest.getDescription(false))
											.erroCode(HttpStatus.BAD_REQUEST)
											.build();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroDetails);
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	private ResponseEntity<ErroDetails> sqlIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e,WebRequest webRequest){                                   
		ErroDetails erroDetails = ErroDetails.builder()
											.message(e.getMessage())
											.timesTamp(LocalDateTime.now())
											.path(webRequest.getDescription(false))
											.erroCode(HttpStatus.BAD_REQUEST)
											.build();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroDetails);
	}
}
