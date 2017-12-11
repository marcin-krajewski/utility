package pl.com.simbit.utility.string;

import java.util.HashMap;
import java.util.Map;

public class EnglishNumbersWordLength {

	private static Map<Integer, String> numbersAndEnglishNames = new HashMap<Integer, String>();
	static {
		numbersAndEnglishNames.put(0, "zero");
		numbersAndEnglishNames.put(1, "one");
		numbersAndEnglishNames.put(2, "two");
		numbersAndEnglishNames.put(3, "three");
		numbersAndEnglishNames.put(4, "four");
		numbersAndEnglishNames.put(5, "five");
		numbersAndEnglishNames.put(6, "six");
		numbersAndEnglishNames.put(7, "seven");
		numbersAndEnglishNames.put(8, "eight");
		numbersAndEnglishNames.put(9, "nine");
		numbersAndEnglishNames.put(10, "ten");
		numbersAndEnglishNames.put(11, "eleven");
		numbersAndEnglishNames.put(12, "twelve");
		numbersAndEnglishNames.put(13, "thirteen");
		numbersAndEnglishNames.put(14, "fourteen");
		numbersAndEnglishNames.put(15, "fifteen");
		numbersAndEnglishNames.put(16, "sixteen");
		numbersAndEnglishNames.put(17, "seventeen");
		numbersAndEnglishNames.put(18, "eighteen");
		numbersAndEnglishNames.put(19, "nineteen");
		numbersAndEnglishNames.put(20, "twenty");
		numbersAndEnglishNames.put(30, "thirty");
		numbersAndEnglishNames.put(40, "forty");
		numbersAndEnglishNames.put(50, "fifty");
		numbersAndEnglishNames.put(60, "sixty");
		numbersAndEnglishNames.put(70, "seventy");
		numbersAndEnglishNames.put(80, "eighty");
		numbersAndEnglishNames.put(90, "ninety");
		numbersAndEnglishNames.put(100, "hundred");
		numbersAndEnglishNames.put(1000, "thousand");
	}

	public static Integer getNumberLen(int number) {
		return getStringForNumberBelow10000(number, true).trim().length();
	}

	public static String getStringForNumberBelow10000(int number, boolean toCount) {
		if (toCount) {
			return getStringForNumberBelow10000(number).replaceAll(" ", "").replaceAll("-", "");
		}
		return getStringForNumberBelow10000(number);
	}

	public static String getStringForNumberBelow10000(int number) {

		if (number >= 10000) {
			return "ERROR";
		}

		int thousands = (number / 1000) % 10;
		int hundreds = (number / 100) % 10;
		int tens = (number / 10) % 10;
		int singles = number % 10;

		StringBuilder sb = new StringBuilder();

		if (thousands > 0) {
			sb.append(numbersAndEnglishNames.get(thousands));
			sb.append(" ");
			sb.append(numbersAndEnglishNames.get(1000));
		}
		if (hundreds > 0) {
			if (!sb.toString().trim().isEmpty()) {
				sb.append(" and ");
			}
			sb.append(numbersAndEnglishNames.get(hundreds));
			sb.append(" ");
			sb.append(numbersAndEnglishNames.get(100));
		}
		if (tens > 1) {
			if (!sb.toString().trim().isEmpty()) {
				sb.append(" and ");
			}
			sb.append(numbersAndEnglishNames.get(tens * 10));
			if (singles > 0) {
				if (!sb.toString().trim().isEmpty()) {
					sb.append("-");
				}
				sb.append(numbersAndEnglishNames.get(singles));
			}
		} else if (tens > 0) {
			if (!sb.toString().trim().isEmpty()) {
				sb.append(" and ");
			}
			sb.append(numbersAndEnglishNames.get(tens * 10 + singles));
		} else if (singles > 0) {
			if (!sb.toString().trim().isEmpty()) {
				sb.append(" and ");
			}
			sb.append(numbersAndEnglishNames.get(singles));
		}

		return sb.toString();
	}
}
