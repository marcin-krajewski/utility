package pl.com.simbit.utility.problems.string;

public class ConcatenateIntegers {

	public static Integer getProductedIntegers(int[] array, int max) {
		String concatenatedNumbers = getConcatenatedNumbersForIndex(max);
		int product = 1;
		for (int index : array) {
			product *= Integer.parseInt(concatenatedNumbers.substring(index - 1, index));
		}
		return product;
	}

	public static Integer getSummedIntegers(int[] array, int max) {
		String concatenatedNumbers = getConcatenatedNumbersForIndex(max);
		int sum = 0;
		for (int index : array) {
			sum += Integer.parseInt(concatenatedNumbers.substring(index - 1, index));
		}
		return sum;
	}

	public static Integer getIntegerForIndex(int index) {
		return Integer.parseInt(getConcatenatedNumbersForIndex(index).substring(index, index + 1));
	}

	public static String getConcatenatedNumbersForIndex(int index) {
		StringBuilder sb = new StringBuilder();

		int num = 1;
		while (true) {
			sb.append(num++);
			if (sb.length() > index) {
				break;
			}
		}
		return sb.toString();
	}
}
