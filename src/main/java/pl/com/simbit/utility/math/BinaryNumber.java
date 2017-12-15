package pl.com.simbit.utility.math;

import java.math.BigInteger;

public class BinaryNumber {

	public static String decimalNumberToBin(int number) {
		return Integer.toBinaryString(number);
	}

	public static String hexToBinWithLeadingZeros(String s, int length) {
		return String.format("%" + length + "s", new BigInteger(s, 16).toString(2));
	}
}
