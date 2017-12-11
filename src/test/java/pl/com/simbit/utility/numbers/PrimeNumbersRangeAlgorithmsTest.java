package pl.com.simbit.utility.numbers;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import pl.com.simbit.utility.numbers.primes.PrimeNumbers;

public class PrimeNumbersRangeAlgorithmsTest {

	@Test
	public void checkIfEratosthenesSieveWorksCorrect() {

		List<Integer> primesBelowNumber;

		primesBelowNumber = PrimeNumbers
				.getPrimesBelowNumberEratostothenesSieve(10);
		System.out.println(primesBelowNumber);
		Assert.assertEquals(4, primesBelowNumber.size());

		primesBelowNumber = PrimeNumbers
				.getPrimesBelowNumberEratostothenesSieve(60);
		System.out.println(primesBelowNumber);
		Assert.assertEquals(17, primesBelowNumber.size());

		primesBelowNumber = PrimeNumbers
				.getPrimesBelowNumberEratostothenesSieve(500);
		System.out.println(primesBelowNumber);
		Assert.assertEquals(95, primesBelowNumber.size());

		primesBelowNumber = PrimeNumbers
				.getPrimesBelowNumberEratostothenesSieve(10000);
		System.out.println(primesBelowNumber);
		Assert.assertEquals(1229, primesBelowNumber.size());
	}

	@Test
	public void checkIfAtkinSieveWorksCorrect() {

		List<Integer> primesBelowNumber;

		primesBelowNumber = PrimeNumbers.getPrimesBelowNumberAtkinSieve(10);
		System.out.println(primesBelowNumber);
		Assert.assertEquals(4, primesBelowNumber.size());

		primesBelowNumber = PrimeNumbers.getPrimesBelowNumberAtkinSieve(60);
		System.out.println(primesBelowNumber);
		Assert.assertEquals(17, primesBelowNumber.size());

		primesBelowNumber = PrimeNumbers.getPrimesBelowNumberAtkinSieve(500);
		System.out.println(primesBelowNumber);
		Assert.assertEquals(95, primesBelowNumber.size());

		primesBelowNumber = PrimeNumbers.getPrimesBelowNumberAtkinSieve(10000);
		System.out.println(primesBelowNumber);
		Assert.assertEquals(1229, primesBelowNumber.size());
	}

}
