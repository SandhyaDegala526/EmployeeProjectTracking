package com.alacriti.projecttracking.util;


import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Random;
import java.util.regex.Pattern;

import com.alacriti.projecttracking.constants.Constants;


public class NumberUtils {

	public static double getDouble(String numStr) {
		try {
			return Double.valueOf(StringUtil.noNullTrim(numStr));
		} catch (NumberFormatException e) {
			return Constants.DEFAULT_DOUBLE;
		}
	}

	public static int getInt(String numStr) {
		try {
			return Integer.valueOf(StringUtil.noNullTrim(numStr));
		} catch (NumberFormatException e) {
			return Constants.DEFAULT_INT;
		}
	}

	public static long getLong(String numStr) {
		try {
			return Long.valueOf(StringUtil.noNullTrim(numStr));
		} catch (NumberFormatException e) {
			return Constants.DEFAULT_LONG;
		}
	}

	public static short getShort(String numStr) {
		try {
			return Short.valueOf(StringUtil.noNullTrim(numStr));
		} catch (NumberFormatException e) {
			return Constants.DEFAULT_SHORT;
		}
	}

	public static long getLong(Object object) {

		if (object == null) {
			return Constants.DEFAULT_LONG;
		}

		if (object instanceof String) {
			return getLong((String) object);
		}

		if (object instanceof Long) {
			return (Long) object;
		}

		return Constants.DEFAULT_LONG;
	}

	public static int getInt(Object object) {

		if (object == null) {
			return Constants.DEFAULT_INT;
		}

		if (object instanceof String) {
			return getInt((String) object);
		}

		if (object instanceof Integer) {
			return (Integer) object;
		}

		return Constants.DEFAULT_INT;
	}

	public static BigDecimal getAmountBigDecimal(int precision, boolean signBit, long l) {
		BigDecimal bigDecimal = new BigDecimal(l);
		bigDecimal = bigDecimal.movePointLeft(precision);
		if (!signBit)
			bigDecimal = bigDecimal.negate();
		return bigDecimal;
	}

	public static BigDecimal getPercentageBigDecimal(boolean indicator, long integerVal, long decimalVal) {
		BigDecimal integerValDecimal = new BigDecimal(integerVal);
		BigDecimal decimalValDecimal = new BigDecimal(decimalVal);
		decimalValDecimal = decimalValDecimal.movePointLeft(decimalValDecimal.precision());
		BigDecimal returnVal = integerValDecimal.add(decimalValDecimal);
		if (!indicator) {
			returnVal = returnVal.negate();
		}

		return returnVal;
	}

	public static BigDecimal getPercentageBigDecimal(boolean indicator, String integerVal, String decimalVal) {
		BigDecimal bigDecimal = new BigDecimal((indicator ? "+" : "-") + integerVal + "." + decimalVal);
		return bigDecimal;
	}

	public static boolean isNumeric(String s) {
		return Pattern.matches("[0-9]+", s);
	}

	public static boolean isDecimal(String str) {
		try {
			 Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static BigDecimal getBigdecimal(String stringNumber) {
		try {
			stringNumber = stringNumber.trim();
			BigDecimal money = new BigDecimal(stringNumber.replaceAll(",", ""));
			return money;
		} catch (NumberFormatException e) {
			return new BigDecimal("0.00");
		}

	}

	public static boolean isLong(String str) {
		if (str == null) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isDigit(str.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	public static BigDecimal getBigDecimalUptoTwoDecimalPlaces(BigDecimal num) {

		return num.setScale(2, BigDecimal.ROUND_HALF_EVEN);

	}

	public static int randInt(int min, int max) {
		Random rand = new Random();

		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public static String amountFormatUSD(String d) {

		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return formatter.format(d) + "";
	}

	public static String amountFormatUSDForMail(BigDecimal amt) {
		return NumberFormat.getCurrencyInstance().format(amt);
	}

}
