package com.assignment.Impl;

import org.springframework.stereotype.Service;

import com.assignment.api.IOperation;
import com.assignment.dtos.StringRequest;
import com.assignment.exceptions.InvalidStringException;
import com.assignment.utility.NumberUtility;

@Service
public class OperationImpl implements IOperation {

	private String multiply(String operand1, int count) {
		StringBuilder result = new StringBuilder();
		int carry = 0;
		int i = operand1.length() - 1;
		if (count == 0) {
			throw new InvalidStringException("Can not multiply to zero.");
		} else if (count == 1) {
			return operand1;
		}
		while (i >= 0) {
			Integer firstOperand = Integer.parseInt(operand1.charAt(i--) + "");
			Integer mulResult = (firstOperand * count) + carry;
			carry = mulResult / 10;
			result.append(mulResult % 10);
		}
		if (carry > 0) {
			result.append(carry);
		}
		return result.reverse().toString();
	}

	private String divide(String operand1, String operand2) {
		StringBuilder result = new StringBuilder();
		int i;
		if (operand1.length() < operand2.length()) {
			return "0";
		} else if (operand1.equals(operand2)) {
			return "1";
		} else if (operand1.length() == operand2.length() && operand1.compareTo(operand2) < 0) {
			return "0";
		} else if (operand2.length() == 0) {
			throw new InvalidStringException("Denomimnator can not be zero/empty.");
		}
		String operSubString1 = "";
		Boolean start = false;
		for (i = operand2.length() - 1; i < operand1.length(); i++) {
			if (!start) {
				operSubString1 = operand1.substring(0, i + 1);
				String subResult = subtraction(operSubString1, operand2);
				if (subResult.indexOf("-") != -1) {
					continue;
				}
				String previousMulResult = "";
				int j = 1;
				for (j = 1; j < 10; j++) {
					previousMulResult = subResult;
					String multiplyResult = multiply(operand2, j);
					subResult = subtraction(operSubString1, multiplyResult);
					if (subResult.indexOf("-") != -1) {
						break;
					}
				}
				if (j == 10) {
					if (subResult.indexOf("-") != -1) {
						result.append(j - 1);
						operSubString1 = subResult;
					} else {
						result.append(j - 2);
						operSubString1 = previousMulResult;
					}
				} else {
					result.append(j - 1);
					operSubString1 = previousMulResult;
				}
				start = true;
			} else {
				operSubString1 += operand1.substring(i, i + 1);
				String subResult = subtraction(operSubString1, operand2);
				if (subResult.indexOf("-") != -1) {
					result.append(0);
					continue;
				}
				String previousMulResult = "";
				int j = 1;
				for (j = 1; j < 10; j++) {
					previousMulResult = subResult;
					String multiplyResult = multiply(operand2, j);
					subResult = subtraction(operSubString1, multiplyResult);
					if (subResult.indexOf("-") != -1) {
						break;
					}
				}
				if (j == 10) {
					result.append(j - 1);
					operSubString1 = subResult;
				} else {
					result.append(j - 1);
					operSubString1 = previousMulResult;
				}
			}
		}
		return result.toString();
	}

	private String addition(String operand1, String operand2) {
		StringBuilder result = new StringBuilder();
		operand1 = operand1.length() == 0 ? "0":operand1;
		operand2 = operand1.length() == 0 ? "0":operand2;
		int carry = 0;
		int i, j;
		if (operand1.length() == 0) {
			return operand1;
		} else if (operand2.length() == 0) {
			return operand2;
		}

		for (i = operand1.length() - 1, j = operand2.length() - 1; i >= 0 && j >= 0; i--, j--) {
			Integer firstOperand = Integer.parseInt(operand1.charAt(i) + "");
			Integer secondOperand = Integer.parseInt(operand2.charAt(j) + "");
			Integer addResult = firstOperand + secondOperand + carry;
			carry = addResult / 10;
			result.append(addResult % 10);
		}
		while (i >= 0) {
			if (carry > 0) {
				Integer firstOperand = Integer.parseInt(operand1.charAt(i--) + "");
				Integer addResult = firstOperand + carry;
				carry = addResult / 10;
				result.append(addResult % 10);
			} else {
				result.append(operand1.charAt(i--));
				carry = 0;
			}
		}
		while (j >= 0) {
			if (carry > 0) {
				Integer firstOperand = Integer.parseInt(operand2.charAt(j--) + "");
				Integer addResult = firstOperand + carry;
				carry = addResult / 10;
				result.append(addResult % 10);
			} else {
				result.append(operand2.charAt(j--));
				carry = 0;
			}
		}

		if (carry > 0) {
			result.append(carry);
		}
		return result.reverse().toString();
	}

	private String subtraction(String operand1, String operand2) {
		operand1 = operand1.length() == 0 ? "0":operand1;
		operand2 = operand2.length() == 0 ? "0":operand2;
		StringBuilder result = new StringBuilder();
		int carry = 0;
		Boolean isSecondBigger = false;
		int i, j;
		if (operand1.length() == 0) {
			return operand1;
		} else if (operand2.length() == 0) {
			return operand2;
		} else if (operand1.equals(operand2)) {
			return "0";
		} else if (operand1.length() < operand2.length() || (operand1.length() == operand2.length() && operand1.compareTo(operand2) < 0)) {
			String temp = operand1;
			operand1 = operand2;
			operand2 = temp;
			isSecondBigger = true;
		}

		for (i = operand1.length() - 1, j = operand2.length() - 1; i >= 0 && j >= 0; i--, j--) {
			Integer firstOperand = Integer.parseInt(operand1.charAt(i) + "") - carry;
			Integer secondOperand = Integer.parseInt(operand2.charAt(j) + "");
			if (secondOperand > firstOperand) {
				firstOperand = firstOperand + 10;
				carry = 1;
			} else {
				carry = 0;
			}
			Integer addResult = firstOperand - secondOperand;
			result.append(addResult);
		}
		while (i >= 0) {
			Integer firstOperand = Integer.parseInt(operand1.charAt(i--) + "") - carry;
			carry = 0;
			result.append(firstOperand);
		}
		return (isSecondBigger ? "-" : "") + NumberUtility.removeZeros(result.reverse().toString());
	}

	public String operation(StringRequest stringRequest) {
		if (stringRequest != null) {
			stringRequest.validate();
			if ("addition".equalsIgnoreCase(stringRequest.getOperation())) {
				return addition(stringRequest.getOperand1(), stringRequest.getOperand2());
			} else if ("divide".equalsIgnoreCase(stringRequest.getOperation())) {
				return divide(stringRequest.getOperand1(), stringRequest.getOperand2());
			} else if ("subtraction".equalsIgnoreCase(stringRequest.getOperation())) {
				return subtraction(stringRequest.getOperand1(), stringRequest.getOperand2());
			} else if ("multiply".equalsIgnoreCase(stringRequest.getOperation())) {
				if (!(stringRequest.getOperand2().length() > 1 && stringRequest.getOperand1().length() > 1)) {
					if (stringRequest.getOperand1().length() > 1) {
						if (stringRequest.getOperand2().length() == 0) {
							return multiply(stringRequest.getOperand1(), 0);
						}
						return multiply(stringRequest.getOperand1(), Integer.parseInt(stringRequest.getOperand2()));
					} else {
						if (stringRequest.getOperand1().length() == 0) {
							return multiply(stringRequest.getOperand2(), 0);
						}
						return multiply(stringRequest.getOperand2(), Integer.parseInt(stringRequest.getOperand1()));
					}
				}else{
					throw new InvalidStringException("One of the string should be of length 1 and non zero value.");
				}
			}
		}
		return null;
	}

}
