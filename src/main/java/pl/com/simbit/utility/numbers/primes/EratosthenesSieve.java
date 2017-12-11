package pl.com.simbit.utility.numbers.primes;

import java.util.ArrayList;
import java.util.List;

public class EratosthenesSieve implements IPrimeNumbersInWithBooleansRange {

	public List<Integer> getPrimesBelowNumber(Integer number) {

		// List<Integer> none = new ArrayList<Integer>();
		boolean[] none = new boolean[number + 1];

		Integer sqrt = (int) Math.sqrt(number);

		Integer checkNum = 1;
		while (checkNum++ < sqrt) {
			if (none[checkNum]) {
				continue;
			}
			for (int numToRevert = checkNum * 2; numToRevert <= number; numToRevert += checkNum) {
				none[numToRevert] = true;
			}
		}

		List<Integer> list = new ArrayList<Integer>();
		for (int prime = 2; prime <= number; prime++) {
			if (!none[prime]) {
				list.add(prime);
			}
		}

		return list;
	}

	public boolean[] getPrimeFlagsBelowNumber(Integer number) {
		// List<Integer> none = new ArrayList<Integer>();
		boolean[] none = new boolean[number + 1];

		Integer sqrt = (int) Math.sqrt(number);

		Integer checkNum = 1;
		while (checkNum++ < sqrt) {
			if (none[checkNum]) {
				continue;
			}
			for (int numToRevert = checkNum * 2; numToRevert <= number; numToRevert += checkNum) {
				none[numToRevert] = true;
			}
		}

		boolean[] list = new boolean[number + 1];
		for (int prime = 2; prime <= number; prime++) {
			if (!none[prime]) {
				list[prime] = true;
			}
		}

		return list;
	}
}
