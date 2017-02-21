package com.assignment.utility;

public class NumberUtility {

	public static Boolean isNumericOnly(String str) {
		if (str.matches("[0-9]+")) {
			return true;
		}
		return false;
	}

	public static String removeZeros(String str) {
		StringBuilder sb = new StringBuilder(str);
		Boolean isZeroPresentInBeg = true;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '0' && isZeroPresentInBeg) {
				sb.deleteCharAt(i);
				i--;
			} else {
				isZeroPresentInBeg = false;
				break;
			}
		}
		return sb.toString();
	}
}
