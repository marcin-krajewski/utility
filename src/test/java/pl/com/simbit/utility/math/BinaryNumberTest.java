package pl.com.simbit.utility.math;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class BinaryNumberTest {

	@Test
	public void checkIfZeroIsCorrect() {
		assertEquals("0", BinaryNumber.decimalNumberToBin(0));
	}

	@Test
	public void checkIfDecimalNumberIsCorrectInBinary() {
		assertEquals("1", BinaryNumber.decimalNumberToBin(1));
		assertEquals("10000", BinaryNumber.decimalNumberToBin(16));
		assertEquals("111111", BinaryNumber.decimalNumberToBin(63));
	}
}
