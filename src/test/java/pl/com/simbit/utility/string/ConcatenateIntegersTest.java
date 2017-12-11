package pl.com.simbit.utility.string;

import static org.junit.Assert.*;
import org.junit.Test;
import pl.com.simbit.utility.problems.string.ConcatenateIntegers;

public class ConcatenateIntegersTest {

	@Test
	public void checkIf12thDigitIs1Test() {
		int numberForIndex = ConcatenateIntegers.getIntegerForIndex(12);
		assertEquals(1, numberForIndex);
	}

	@Test
	public void checkIfSumOfNumbersIsCorrect() {
		int sum = ConcatenateIntegers.getSummedIntegers(new int[] { 12 }, 12);
		assertEquals(1, sum);
		sum = ConcatenateIntegers.getSummedIntegers(new int[] { 1, 2, 3 }, 3);
		assertEquals(6, sum);
		sum = ConcatenateIntegers.getSummedIntegers(new int[] { 12, 13, 14 },
				14);
		assertEquals(3, sum);
		sum = ConcatenateIntegers.getSummedIntegers(new int[] { 21, 23, 25 },
				25);
		assertEquals(18, sum);
	}

	@Test
	public void checkIfProduxtOfNumbersIsCorrect() {
		int product = ConcatenateIntegers.getProductedIntegers(
				new int[] { 12 }, 12);
		assertEquals(1, product);
		product = ConcatenateIntegers.getProductedIntegers(
				new int[] { 1, 2, 3 }, 3);
		assertEquals(6, product);
		product = ConcatenateIntegers.getProductedIntegers(new int[] { 12, 13,
				14 }, 14);
		assertEquals(1, product);
		product = ConcatenateIntegers.getProductedIntegers(new int[] { 21, 23,
				25 }, 25);
		assertEquals(210, product);
	}
}
