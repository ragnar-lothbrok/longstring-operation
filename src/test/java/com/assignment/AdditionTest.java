package com.assignment;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.assignment.api.IOperation;
import com.assignment.dtos.StringRequest;
import com.assignment.exceptions.InvalidStringException;

/**
 * This class consist test cases for addition.
 * @author raghunandangupta
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	classes = StringApplication.class,
	loader = SpringApplicationContextLoader.class)
public class AdditionTest {

	private final static Logger LOGGER = LoggerFactory.getLogger(AdditionTest.class);

	@Autowired
	private IOperation operation;

	@Test
	public void additionOne() {
		StringRequest stringRequest = new StringRequest();
		stringRequest.setOperation("addition");
		stringRequest.setOperand1("12345");
		stringRequest.setOperand2("54321");
		String result = operation.operation(stringRequest);
		LOGGER.info("Result {} ", result);
		assertEquals("66666", result);
	}

	@Test(expected=InvalidStringException.class)
	public void additionTwo() {
		StringRequest stringRequest = new StringRequest();
		stringRequest.setOperation("addition");
		stringRequest.setOperand1("12345");
		stringRequest.setOperand2("");
		String result = operation.operation(stringRequest);
		LOGGER.info("Result  = {} ", result);
		assertEquals("12345", result);
	}

}
