package pl.com.simbit.utility.numbers;

import static org.junit.Assert.*;
import org.junit.Test;
import pl.com.simbit.utility.problems.numbers.NumberDigits;

public class NumberDigitsTest {

	@Test
	public void checkIfNumberHasDifferentDigits() {

		assertTrue(NumberDigits.getInstance()
				.checkIfNumberHasDifferentDigits(12345));
		assertTrue(NumberDigits.getInstance()
				.checkIfNumberHasDifferentDigits(0));
		assertTrue(NumberDigits.getInstance()
				.checkIfNumberHasDifferentDigits(1));
		assertTrue(NumberDigits.getInstance()
				.checkIfNumberHasDifferentDigits(1234567890));
		assertTrue(NumberDigits.getInstance()
				.checkIfNumberHasDifferentDigits(12));
		assertFalse(NumberDigits.getInstance()
				.checkIfNumberHasDifferentDigits(11));
		assertFalse(NumberDigits.getInstance()
				.checkIfNumberHasDifferentDigits(1111111));
		assertFalse(NumberDigits.getInstance()
				.checkIfNumberHasDifferentDigits(1234567891));

	}

	@Test
	public void checkIfNumberHasDifferentAndNotContains0Digits() {

		assertTrue(NumberDigits.getInstance()
				.checkIfNumberHasDifferentDigitsAndNotContains0(12345));
		assertFalse(NumberDigits.getInstance()
				.checkIfNumberHasDifferentDigitsAndNotContains0(0));
		assertTrue(NumberDigits.getInstance()
				.checkIfNumberHasDifferentDigitsAndNotContains0(1));
		assertFalse(NumberDigits.getInstance()
				.checkIfNumberHasDifferentDigitsAndNotContains0(1234567890));
		assertTrue(NumberDigits.getInstance()
				.checkIfNumberHasDifferentDigitsAndNotContains0(12));
		assertFalse(NumberDigits.getInstance()
				.checkIfNumberHasDifferentDigitsAndNotContains0(11));
		assertFalse(NumberDigits.getInstance()
				.checkIfNumberHasDifferentDigitsAndNotContains0(1111111));
		assertFalse(NumberDigits.getInstance()
				.checkIfNumberHasDifferentDigitsAndNotContains0(1234567891));
	}
}
