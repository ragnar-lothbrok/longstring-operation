package com.assignment;

import static org.junit.Assert.assertEquals;

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

/**
 * This class consist test cases for Multiplication Test.
 * @author raghunandangupta
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	classes = StringApplication.class,
	loader = SpringApplicationContextLoader.class)
public class MultiplyTest {

	private final static Logger LOGGER = LoggerFactory.getLogger(MultiplyTest.class);

	@Autowired
	private IOperation operation;

	@Test
	public void multiplyOne() {
		StringRequest stringRequest = new StringRequest();
		stringRequest.setOperation("multiply");
		stringRequest.setOperand1("12345");
		stringRequest.setOperand2("1");
		String result = operation.operation(stringRequest);
		LOGGER.info("Result {} ", result);
		assertEquals("12345", result);
	}

	@Test
	public void multiplyTwo() {
		StringRequest stringRequest = new StringRequest();
		stringRequest.setOperation("multiply");
		stringRequest.setOperand1("22345");
		stringRequest.setOperand2("9");
		String result = operation.operation(stringRequest);
		LOGGER.info("Result {} ", result);
		assertEquals("201105", result);
	}
	
	@Test
	public void multiplyThree() {
		StringRequest stringRequest = new StringRequest();
		stringRequest.setOperation("multiply");
		stringRequest.setOperand1("9");
		stringRequest.setOperand2("22345");
		String result = operation.operation(stringRequest);
		LOGGER.info("Result {} ", result);
		assertEquals("201105", result);
	}

}
