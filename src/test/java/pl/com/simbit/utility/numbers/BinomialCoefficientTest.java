package pl.com.simbit.utility.numbers;

import junit.framework.Assert;

import org.junit.Test;

import pl.com.simbit.utility.problems.numbers.BinomialCoefficient;

public class BinomialCoefficientTest {

	@Test
	public void checkIfWorksCorrectTest() {
		Assert.assertEquals(10.0,
				BinomialCoefficient.getBinomialCoefficient(5, 3));
		Assert.assertEquals(1144066.0,
				BinomialCoefficient.getBinomialCoefficient(23, 10));
		Assert.assertEquals(118264581564861424.0,
				BinomialCoefficient.getBinomialCoefficient(60, 30));
		// Assert.assertEquals(100891344545564193334812497256.0,
		// BinomialCoefficient.getBinomialCoefficient(100, 50));
	}
}
