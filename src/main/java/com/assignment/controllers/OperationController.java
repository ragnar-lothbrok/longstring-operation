package com.assignment.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.api.IOperation;
import com.assignment.dtos.StringRequest;

/**
 * Starting point of all operations.
 * 
 * @author raghunandangupta
 *
 */
@RestController
@RequestMapping(
	value = "/evaluate")
public class OperationController {

	private final static Logger LOGGER = LoggerFactory.getLogger(OperationController.class);

	@Autowired
	private IOperation iOperation;

	@RequestMapping(
		method = { RequestMethod.GET },
		produces = { MediaType.APPLICATION_JSON_VALUE })
	public Map<String, String> get(StringRequest stringRequest) {
		LOGGER.info("Request received {} ", stringRequest);
		Map<String, String> responses = new HashMap<String, String>();
		responses.put("result", iOperation.operation(stringRequest));
		return responses;
	}

}
