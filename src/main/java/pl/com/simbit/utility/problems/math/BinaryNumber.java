package pl.com.simbit.utility.problems.math;

public class BinaryNumber {

	public static String getBinaryStringForNumber(int number) {

		StringBuilder binaryNumber = new StringBuilder();
		int tempNumber = number;
		while (tempNumber >= 1) {
			binaryNumber.append(tempNumber & 1);
			tempNumber >>= 1;
		}
		return binaryNumber.reverse().toString();
	}
}
