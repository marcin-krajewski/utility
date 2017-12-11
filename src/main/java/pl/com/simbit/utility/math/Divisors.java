package pl.com.simbit.utility.math;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Divisors {

	public static Set<Double> getDivisorsOfNumber(Double number) {
		Set<Double> divisors = new HashSet<Double>();
		for (double i = 0.0; i <= number; i++) {
			if (number % i == 0) {
				divisors.add(i);
			}
		}
		return divisors;
	}

	public static Integer getCountOfDivisorsForNumber(Double number) {
		int res = 1;
		// http://primes.utm.edu/glossary/xpage/Tau.html
		Map<Double, Integer> countsForFactors = LeastCommonMultiple.getCountsForFactors(PrimeFactor
				.getPrimeFactorsOfNumber(number));
		for (int val : countsForFactors.values()) {
			res *= (val + 1);
		}
		return res;
	}
}
