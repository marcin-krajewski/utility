package pl.com.simbit.utility.problems.numbers.primes;

import java.util.List;

public class PrimeNumbers {

	public static List<Integer> getPrimesBelowNumberEratostothenesSieve(Integer number) {
		return getPrimesBelowNumber(number, new EratosthenesSieve());
	}

	public static List<Integer> getPrimesBelowNumberAtkinSieve(Integer number) {
		return getPrimesBelowNumber(number, new AtkinSieve());
	}

	private static List<Integer> getPrimesBelowNumber(Integer number, IPrimeNumbersInRange algorithm) {
		return algorithm.getPrimesBelowNumber(number);
	}

}
