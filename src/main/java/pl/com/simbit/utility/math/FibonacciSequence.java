package pl.com.simbit.utility.math;

import pl.com.simbit.utility.string.StringAsNum;

public class FibonacciSequence {

	public static String findFibonacciStringForIndex(int index) {
		return findFibonacciStringForDoubleIndex(index);
	}

	public static String findFibonacciStringForDoubleIndex(double index) {

		String prev1 = "1";
		if (index == 1.0) {
			return prev1;
		}
		String prev2 = "1";
		if (index == 2.0) {
			return prev2;
		}

		String value = "";
		for (double i = 3; i <= index; i++) {
			value = StringAsNum.sumStringNumbers(new String[] { prev1, prev2 });
			prev1 = prev2;
			prev2 = value;
		}
		return StringAsNum.clearStringNumberFromLeadingZeros(value);
	}

	public static int getFirstTermOfFibonacciWithNumberOfDigits(int numberOfDigits) {
		String prev1 = "1";
		String prev2 = "1";
		String value = "";
		int index = 3;
		while (true) {
			value = StringAsNum.sumStringNumbers(new String[] { prev1, prev2 });
			if (value.length() >= numberOfDigits) {
				return index;
			}
			index++;
			prev1 = prev2;
			prev2 = value;
		}
	}
}
