package pl.com.simbit.utility.problems.numbers.primes;

import java.util.ArrayList;
import java.util.List;

public class AtkinSieve implements IPrimeNumbersInRange {

	public List<Integer> getPrimesBelowNumber(Integer limit) {
		List<Boolean> list = new ArrayList<Boolean>();

		for (int i = 0; i <= limit; i++) {
			list.add(false);
		}

		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);

		Long sqrt = (long) Math.sqrt(limit);

		int xx, xx3, xx4, yy, nMod12;
		int n;
		for (int x = 1; x <= sqrt; x++) {

			xx = x * x;
			xx3 = xx * 3;
			xx4 = xx3 + xx;
			for (int y = 1; y <= sqrt; y++) {
				yy = y * y;
				n = xx4 + yy;
				if (n <= limit) {
					nMod12 = n % 12;
					if (nMod12 == 1 || nMod12 == 5) {
						list.set(n, !list.get(n));
					}
				}

				n = xx3 + yy;
				if (n <= limit && n % 12 == 7) {
					list.set(n, !list.get(n));
				}
				n = xx3 - yy;
				if (x > y && n <= limit && n % 12 == 11) {
					list.set(n, !list.get(n));
				}
			}
		}

		int nn;
		for (n = 5; n <= sqrt; n++) {
			if (list.get(n)) {
				nn = n * n;
				for (int k = nn; k <= limit; k += nn) {
					list.set(k, false);
				}
			}
		}

		for (n = 5; n <= limit; n++) {
			if (list.get(n)) {
				primes.add(n);
			}
		}

		return primes;
	}
}
