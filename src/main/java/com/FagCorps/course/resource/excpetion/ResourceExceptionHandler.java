package com.FagCorps.course.resource.excpetion;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.FagCorps.course.service.excpetion.DatabaseExpction;
import com.FagCorps.course.service.excpetion.ResourceNotFoundExpetion;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundExpetion.class)
public ResponseEntity<standardError> SourceNotFound(ResourceNotFoundExpetion e , HttpServletRequest  request){
	String error = "Resource not Found";
	HttpStatus status = HttpStatus.NOT_FOUND;
	standardError err = new standardError(
			Instant.now(),status.value(), e.getMessage(),error, request.getRequestURI());
return	ResponseEntity.status(status).body(err);
	
	
}


@ExceptionHandler(DatabaseExpction.class)
public ResponseEntity<standardError> DataBaseIllegalDelete(DatabaseExpction e , HttpServletRequest  request){
String error = "illegal id for delete ";
HttpStatus status = HttpStatus.BAD_REQUEST;	
standardError err = new standardError(
		Instant.now(),status.value(), e.getMessage(),error, request.getRequestURI());
return	ResponseEntity.status(status).body(err);


}


}
