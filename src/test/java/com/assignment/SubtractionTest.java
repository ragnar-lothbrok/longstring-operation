package com.assignment;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
 * This class consist test cases for Subtraction Test.
 * @author raghunandangupta
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	classes = StringApplication.class,
	loader = SpringApplicationContextLoader.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubtractionTest {

	private final static Logger LOGGER = LoggerFactory.getLogger(SubtractionTest.class);

	@Autowired
	private IOperation operation;

	@Test
	public void subtractionOne() {
		StringRequest stringRequest = new StringRequest();
		stringRequest.setOperation("subtraction");
		stringRequest.setOperand1("12345");
		stringRequest.setOperand2("12345");
		String result = operation.operation(stringRequest);
		assertEquals("0", result);
	}

	@Test
	public void subtractionTwo() {
		StringRequest stringRequest = new StringRequest();
		stringRequest.setOperation("subtraction");
		stringRequest.setOperand1("12345");
		stringRequest.setOperand2("1234");
		String result = operation.operation(stringRequest);
		LOGGER.info("Result {} ", result);
		assertEquals("11111", result);
	}

	@Test
	public void subtractionThree() {
		StringRequest stringRequest = new StringRequest();
		stringRequest.setOperation("subtraction");
		stringRequest.setOperand1("12345");
		stringRequest.setOperand2("4234");
		String result = operation.operation(stringRequest);
		LOGGER.info("Result {} ", result);
		assertEquals("8111", result);
	}

	@Test
	public void subtractionFour() {
		StringRequest stringRequest = new StringRequest();
		stringRequest.setOperation("subtraction");
		stringRequest.setOperand1("12345");
		stringRequest.setOperand2("44234");
		String result = operation.operation(stringRequest);
		LOGGER.info("Result {} ", result);
		assertEquals("-31889", result);
	}

	@Test
	public void subtractionFive() {
		StringRequest stringRequest = new StringRequest();
		stringRequest.setOperation("subtraction");
		stringRequest.setOperand1("44234");
		stringRequest.setOperand2("12345");
		String result = operation.operation(stringRequest);
		LOGGER.info("Result {} ", result);
		assertEquals("31889", result);
	}

	@Test
	public void subtractionSix() {
		StringRequest stringRequest = new StringRequest();
		stringRequest.setOperation("subtraction");
		stringRequest.setOperand1("0011111111 ");
		stringRequest.setOperand2("0012345 ");
		String result = operation.operation(stringRequest);
		LOGGER.info("Result {} ", result);
		assertEquals("11098766", result);
	}
	
	@Test(expected=InvalidStringException.class)
	public void zsubtraction(){
		StringRequest stringRequest = new StringRequest();
		stringRequest.setOperation("subtraction");
		stringRequest.setOperand1("11-111111");
		stringRequest.setOperand2("12345");
		String result = operation.operation(stringRequest);
		LOGGER.info("Result {} ", result);
		assertEquals("11098766", result);
	}

}
