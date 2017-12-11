package pl.com.simbit.utility.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeastCommonMultiple {

	public static Double getLeastCommonMultipleForAllInSet(Set<Double> set) {
		Double[] tab = set.toArray(new Double[] {});

		Double res = 1.0;

		for (int i = 0; i < tab.length; i++) {
			res = getLeastCommonMultiple(tab[i], res);
		}

		return res;
	}

	public static Double getLeastCommonMultiple(Double num1, Double num2) {
		Double[] num1factors = PrimeFactor.getPrimeFactorsOfNumber(num1);
		Double[] num2factors = PrimeFactor.getPrimeFactorsOfNumber(num2);

		Map<Double, Integer> map = getFactorsToCompute(num1factors, num2factors);

		Double res = 1.0;
		for (Double d : map.keySet()) {
			res *= Math.pow(d, map.get(d));
		}
		return res;
	}

	public static Map<Double, Integer> getFactorsToCompute(Double[] d1, Double[] d2) {
		Map<Double, Integer> map = new HashMap<Double, Integer>();

		Map<Double, Integer> map1 = getCountsForFactors(d1);
		Map<Double, Integer> map2 = getCountsForFactors(d2);

		for (Double d : map1.keySet()) {
			if (!map2.containsKey(d)) {
				map.put(d, map1.get(d));
				break;
			}
			int val1 = map1.get(d);
			int val2 = map2.get(d);

			map.put(d, Math.max(val1, val2));
		}

		for (Double d : map2.keySet()) {
			if (map.containsKey(d)) {
				continue;
			}
			map.put(d, map2.get(d));
		}
		return map;
	}

	public static Map<Double, Integer> getCountsForFactors(Double[] factors) {
		Map<Double, Integer> numbers = new HashMap<Double, Integer>();
		for (Double d : factors) {
			Integer val = numbers.get(d);
			if (val == null) {
				val = 0;
			}
			numbers.put(d, ++val);
		}
		return numbers;
	}

}
