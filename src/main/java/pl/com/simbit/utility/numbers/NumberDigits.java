package pl.com.simbit.utility.numbers;

import pl.com.simbit.utility.classes.ArrayUtils;

public class NumberDigits {

	private static NumberDigits instance;

	private NumberDigits() {
	}

	public static synchronized NumberDigits getInstance() {
		if (instance == null) {
			instance = new NumberDigits();
		}
		return instance;
	}

	public Boolean checkIfNumberHasDifferentDigits(int number) {

		boolean[] numbers = new boolean[10];

		int temp = number;
		int mod = 0;

		while (temp > 0) {
			mod = temp % 10;
			if (numbers[mod]) {
				return false;
			}
			numbers[mod] = true;
			temp /= 10;
		}

		return true;
	}

	public Boolean checkIfNumberHasDifferentDigitsForLong(long number) {

		boolean[] numbers = new boolean[10];

		long temp = number;
		int mod = 0;

		while (temp > 0) {
			mod = (int) (temp % 10);
			if (numbers[mod]) {
				return false;
			}
			numbers[mod] = true;
			temp /= 10;
		}

		return true;
	}

	public Boolean checkIfNumbersHasTheSameDigits(int number1, int number2) {

		String sNumber1 = number1 + "";
		String sNumber2 = number2 + "";

		if (sNumber1.length() != sNumber2.length()) {
			return false;
		}

		int[] numbers = new int[10];

		int temp = number1;
		int mod = 0;
		while (temp > 0) {
			mod = temp % 10;
			numbers[mod]++;
			temp /= 10;
		}

		temp = number2;
		mod = 0;
		while (temp > 0) {
			mod = temp % 10;
			numbers[mod]--;
			temp /= 10;
		}

		for (int i = 0; i < 10; i++) {
			if (numbers[i] != 0) {
				return false;
			}
		}

		return true;
	}

	public Boolean checkIfNumberHasDifferentDigitsAndNotContains0(int number) {

		if (number <= 0) {
			return false;
		}

		Boolean[] numbers = ArrayUtils.createArrayWithSizeAndValue(10, false, Boolean.class);

		int temp = number;
		int mod = 0;

		while (temp > 0) {
			mod = temp % 10;
			if (mod == 0) {
				return false;
			}

			if (numbers[mod]) {
				return false;
			}
			numbers[mod] = true;
			temp /= 10;
		}

		return true;
	}
}
