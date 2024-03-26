package com.as.ssd.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.as.ssd.services.UserBlockedException;
import com.as.ssd.services.UserNotActivatedException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { UserBlockedException.class, UserNotActivatedException.class })
	protected ResponseEntity<Object> handleError(
			RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "User account suspended or not activated.";
		return handleExceptionInternal(ex, bodyOfResponse,
				new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
	}
}
