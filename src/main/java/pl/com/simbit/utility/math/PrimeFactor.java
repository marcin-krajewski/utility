package pl.com.simbit.utility.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import pl.com.simbit.utility.classes.ArrayUtils;

public class PrimeFactor {

	public static Double[] getPrimeFactorsOfNumber(double number) {
		List<Double> list = new ArrayList<Double>();

		double factor = number;
		double last = 2.0;
		while (factor > 1) {
			for (; last <= factor; last++) {

				if (factor % last == 0.0f) {
					factor = factor / last;
					list.add(last);
					break;
				}
			}
		}
		// System.out.println("LIST "+list);
		return list.toArray(new Double[] {});
	}

	public static Integer countOfFactorsWithoutNumber(int number) {
		return countOfFactors(number) - number;
	}
 
	public static Integer countOfFactors(int number) {
		Map<Integer, Integer> factors = primeFactorsWithCount(number);
		Integer mul = 1;
		for (Entry<Integer, Integer> entry : factors.entrySet()) {
			Integer sum = 0;
			for (int i = 0; i <= entry.getValue(); i++) {
				sum += (int) Math.pow(entry.getKey(), i);
			}
			mul *= sum;
		}
		return mul;
	}

	public static Map<Integer, Integer> primeFactorsWithCount(int number) {
		int factor = number;
		int last = 2;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		while (factor > 1) {
			for (; last <= factor; last++) {

				if (factor % last == 0) {
					factor = factor / last;
					ArrayUtils.incrementValueInMapOrPut1(last, map);
					break;
				}
			}
		}
		// System.out.println("LIST "+list);
		return map;
	}

	public static Set<Double> getUniquePrimeFactorsOfNumber(double number) {

		Double[] factors = getPrimeFactorsOfNumber(number);

		Set<Double> set = new HashSet<Double>();
		for (int i = 0; i < factors.length; i++) {
			set.add(factors[i]);
		}
		// System.out.println("NUMBER: "+number+ " --- SET "+set);
		return set;
	}

	public static Double getUniqueFactorsMultiplied(double number) {

		return multiplyFactors(getUniquePrimeFactorsOfNumber(number));
	}

	public static double getUniqueFactorsSummed(double number) {

		double sum = 0.0;
		for (double i = 1.0; i <= number / 2.0; i++) {
			if (number % i == 0.0) {
				sum += i;
			}
		}
		return sum;
	}

	public static Double multiplyFactors(Set<Double> factors) {

		double result = 1;
		for (Double i : factors) {
			result *= i;
		}
		return result;
	}

	public static Double sumFactors(Set<Double> factors) {

		double result = 0;
		for (Double i : factors) {
			result += i;
		}
		return result;
	}

	public static Double getLargestPrimeFactorOfNumber(double number) {

		Set<Double> factorsOfNumber = getUniquePrimeFactorsOfNumber(number);

		double max = 0.0;
		for (Double currentFactor : factorsOfNumber) {
			if (max < currentFactor) {
				max = currentFactor;
			}
		}
		return max;
	}
}
