package com.assignment.exceptions;

import java.util.List;

import com.assignment.dtos.FieldErrorResource;

/**
 * When any of the strings are invalid.
 * @author raghunandangupta
 *
 */
public class InvalidStringException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	List<FieldErrorResource> fieldErrors;

	public InvalidStringException() {
		super("Invalid String");
	}

	public InvalidStringException(String str) {
		super(str);
	}

	public List<FieldErrorResource> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldErrorResource> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
}
