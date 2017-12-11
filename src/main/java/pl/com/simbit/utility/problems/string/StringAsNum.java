package pl.com.simbit.utility.problems.string;

import java.util.ArrayList;
import java.util.List;

public class StringAsNum {

	public static int[] getStringAsNumArray0IsHigherMaxIsLower(String s) {
		return getStringAsNumArray(s, true);
	}

	public static int[] getStringAsNumArray0IsLowerMaxIsHigher(String s) {
		return getStringAsNumArray(s, false);
	}

	public static String clearStringNumberFromLeadingZeros(String stringNumber) {
		if (stringNumber.trim().isEmpty()) {
			return "";
		}
		int index = 0;
		while (true) {
			if (stringNumber.length() - index == 1) {
				break;
			}
			char c = stringNumber.charAt(index);
			if (c != '0') {
				break;
			}
			index++;
		}
		String substring = stringNumber.substring(index);
		if (substring.trim().isEmpty()) {
			return "0";
		}
		return substring;
	}

	private static int[] getStringAsNumArray(String stringNumber, boolean reverse) {

		stringNumber = clearStringNumberFromLeadingZeros(stringNumber.trim());

		int len = stringNumber.length();
		int[] numbers = new int[len];

		int len2 = len - 1;
		for (int i = 0; i < len; i++) {
			char c = stringNumber.charAt(i);
			if (reverse) {
				numbers[i] = Integer.parseInt(Character.toString(c));
			} else {
				numbers[len2 - i] = Integer.parseInt(Character.toString(c));
			}
		}

		return numbers;
	}

	public static String sumStringNumbers(String... strings) {

		List<String> stringsList = new ArrayList<String>();

		for (String s : strings) {
			stringsList.add((new StringBuilder(s)).reverse().toString());
		}

		return sumStringNumbersReverse(stringsList.toArray(new String[] {}));
	}

	public static String sumStringNumbersReverse(String[] strings) {

		if (strings.length == 1) {
			return new StringBuilder(strings[0]).reverse().toString();
		}
		StringBuilder sb = new StringBuilder();

		int maxLen = 0;
		for (String s : strings) {
			int len = s.length();
			if (len > maxLen) {
				maxLen = len;
			}
		}

		int c = 0;
		String string;
		for (int i = 0; i < maxLen; i++) {
			int sum = c;
			for (String s : strings) {
				try {
					string = Character.toString(s.charAt(i));
				} catch (IndexOutOfBoundsException ex) {
					string = "0";
				}
				int num = Integer.parseInt(string);
				sum += num;
			}
			int result = sum % 10;
			c = (sum / 10);
			sb.append(result);
			if (i == maxLen - 1) {
				sb.append((new StringBuilder(String.valueOf(c))).reverse().toString());
			}
		}

		return clearStringNumberFromLeadingZeros(sb.reverse().toString());
	}

	public static String productTwoNumbers(String num1, String num2) {

		// System.out.println("MNO�ENIE: "+num1+"x"+num2);
		int c = 0;
		boolean num1larger = num1.length() > num2.length();
		int[] tab1 = StringAsNum.getStringAsNumArray0IsLowerMaxIsHigher(num1larger ? num2 : num1);
		int[] tab2 = StringAsNum.getStringAsNumArray0IsLowerMaxIsHigher(num1larger ? num1 : num2);

		List<String> stringsToSum = new ArrayList<String>();
		int len = tab2.length - 1;
		int j2;
		int temp;
		StringBuilder sb;
		for (int i = 0; i < tab1.length; i++) {

			c = 0;
			sb = new StringBuilder();
			for (int k = 0; k < i; k++) {
				sb.append("0");
			}
			j2 = tab1[i] % 10;
			for (int j = 0; j < tab2.length; j++) {

				temp = j2 * tab2[j] + c;
				c = temp / 10;
				sb.append(temp % 10);
				if (j == len && c != 0) {
					sb.append((new StringBuilder(String.valueOf(c))).reverse());
				}

			}
			stringsToSum.add(sb.toString());
		}

		return clearStringNumberFromLeadingZeros(sumStringNumbersReverse(stringsToSum.toArray(new String[] {})));
	}

	public static int sumNumbersInStringNumber(String number) {
		int sum = 0;
		for (int i : StringAsNum.getStringAsNumArray0IsHigherMaxIsLower(number)) {
			sum += i;
		}
		return sum;
	}

	public static String getIntegerArrayAsString(Integer[] numbers) {
		StringBuilder sb = new StringBuilder();
		if (numbers == null || numbers.length == 0) {
			return sb.toString();
		}
		for (Integer number : numbers) {
			sb.append(number);
		}
		return sb.toString();
	}
}
