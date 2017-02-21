package com.assignment.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.assignment.dtos.ErrorResource;

/**
 * This will catch all kinds of exception which are added in this class.
 * @author raghunandangupta
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ InvalidStringException.class })
	protected ResponseEntity<Object> handleInavlidStringExceptionRequest(RuntimeException e, WebRequest request) {
		InvalidStringException ire = (InvalidStringException) e;
		ErrorResource error = new ErrorResource("INVALID_STRING", e.getMessage());
		error.setFieldErros(ire.getFieldErrors());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return handleExceptionInternal(e, error, headers, HttpStatus.BAD_REQUEST, request);
	}

}
