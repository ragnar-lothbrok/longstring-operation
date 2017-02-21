package com.assignment.api;

import com.assignment.dtos.StringRequest;

public interface IOperation {

	/**
	 * This will accept 2 operands and return result.
	 * @param stringRequest
	 * @return
	 */
	String operation(StringRequest stringRequest);
}
