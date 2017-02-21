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
 * This class consist test cases for Division Test.
 * @author raghunandangupta
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	classes = StringApplication.class,
	loader = SpringApplicationContextLoader.class)
public class DivisionTest {

	private final static Logger LOGGER = LoggerFactory.getLogger(DivisionTest.class);

	@Autowired
	private IOperation operation;

	@Test
	public void divideOne() {
		StringRequest stringRequest = new StringRequest();
		stringRequest.setOperation("divide");
		stringRequest.setOperand1("12345");
		stringRequest.setOperand2("12345");
		String result = operation.operation(stringRequest);
		LOGGER.info("Result = {}", result);
		assertEquals("1", result);
	}

	@Test
	public void divideTwo() {
		StringRequest stringRequest = new StringRequest();
		stringRequest.setOperation("divide");
		stringRequest.setOperand1("12345");
		stringRequest.setOperand2("1234");
		String result = operation.operation(stringRequest);
		LOGGER.info("Result {} ", result);
		assertEquals("10", result);
	}

	@Test
	public void divideThree() {
		StringRequest stringRequest = new StringRequest();
		stringRequest.setOperation("divide");
		stringRequest.setOperand1("12345");
		stringRequest.setOperand2("4234");
		String result = operation.operation(stringRequest);
		LOGGER.info("Result {} ", result);
		assertEquals("2", result);
	}

	@Test
	public void divideFour() {
		StringRequest stringRequest = new StringRequest();
		stringRequest.setOperation("divide");
		stringRequest.setOperand1("1234512345");
		stringRequest.setOperand2("4234");
		String result = operation.operation(stringRequest);
		LOGGER.info("Result {} ", result);
		assertEquals("291571", result);
	}

	@Test
	public void divideFive() {
		StringRequest stringRequest = new StringRequest();
		stringRequest.setOperation("divide");
		stringRequest.setOperand1("987654321");
		stringRequest.setOperand2("12345");
		String result = operation.operation(stringRequest);
		LOGGER.info("Result {} ", result);
		assertEquals("80004", result);
	}

	@Test
	public void divideSix() {
		StringRequest stringRequest = new StringRequest();
		stringRequest.setOperation("divide");
		stringRequest.setOperand1("12345678900001");
		stringRequest.setOperand2("99990");
		String result = operation.operation(stringRequest);
		LOGGER.info("Result {} ", result);
		assertEquals("123469135", result);
	}

}
