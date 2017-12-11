package pl.com.simbit.utility.numbers;

public class PalindromNumbers {

	public static boolean isNumberPalindrome(int number) {
		return isStringPalindrome(String.valueOf(number));
	}

	public static boolean isLongNumberPalindrome(long number) {
		return isStringPalindrome(String.valueOf(number));
	}

	public static boolean isStringPalindrome(String stringValue) {
		if (stringValue == null || stringValue.trim().isEmpty()) {
			return false;
		}
		stringValue = stringValue.trim();
		int lengthOfString = stringValue.length();
		int endIndex = getEndIndexForLen(lengthOfString);

		int lengthOfStringDecrementedWith1 = lengthOfString - 1;
		for (int i = 0; i <= endIndex; i++) {
			char charFront = stringValue.charAt(i);
			char charEnd = stringValue.charAt(lengthOfStringDecrementedWith1 - i);

			if (charFront != charEnd) {
				return false;
			}
		}
		return true;
	}

	private static int getEndIndexForLen(int length) {
		int endIndex = 0;
		if (length % 2 == 0) {
			endIndex = length / 2;
		} else {
			endIndex = length / 2 - 1;
		}
		return endIndex;
	}
}
