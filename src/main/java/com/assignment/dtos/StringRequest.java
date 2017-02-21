package com.assignment.dtos;

import java.io.Serializable;

import com.assignment.api.StringValidator;
import com.assignment.exceptions.InvalidStringException;
import com.assignment.utility.NumberUtility;

public class StringRequest implements Serializable, StringValidator {

	private static final long serialVersionUID = -9054338712738471458L;
	private String operation;
	private String operand1;
	private String operand2;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String opeartion) {
		this.operation = opeartion;
	}

	public String getOperand1() {
		return operand1;
	}

	public void setOperand1(String operand1) {
		this.operand1 = operand1;
	}

	public String getOperand2() {
		return operand2;
	}

	public void setOperand2(String operand2) {
		this.operand2 = operand2;
	}

	public void validate() {
		operand1 = operand1.trim();
		operand2 = operand2.trim();
		if (NumberUtility.isNumericOnly(operand1) && NumberUtility.isNumericOnly(operand2)) {
			operand1 = NumberUtility.removeZeros(operand1);
			operand2 = NumberUtility.removeZeros(operand2);
		} else {
			throw new InvalidStringException("Either or both strings are invalid.");
		}
	}

	@Override
	public String toString() {
		return "StringRequest [opeartion=" + operation + ", operand1=" + operand1 + ", operand2=" + operand2 + "]";
	}

}
