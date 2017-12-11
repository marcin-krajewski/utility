package pl.com.simbit.utility.numbers.primes;

public class MillerRabinPrime {

	private static final Long MAX1 = 4759123141L;
	private static final Long MAX2 = 341550071728321L;

	public static final boolean isNumberPrimeD(Double number) {
		return isNumberPrimeL(number.longValue());
	}

	public static final boolean isNumberPrimeI(Integer number) {
		return isNumberPrimeL(number.longValue());
	}

	public static final boolean isNumberPrimeL(Long number) {

		if (number % 2 == 0) {
			return false;
		}

		int s = 0;
		Long temp = number - 1;
		Long d = temp;

		while (temp % 2 == 0) {
			s++;
			d /= 2;
			temp /= 2;
		}

		System.out.println("Number fixed to S:" + s + ", D: " + d);

		int as[] = getAArray(number);
		for (int a : as) {
			for (int i = 0; i <= s; i++) {
				long mod = (long) (Math.pow(a, Math.pow(2, i) * d) % number);
				if (mod == 1 || mod == number - 1) {
					return true;
				}
			}
		}

		return false;
	}

	private static int[] getAArray(Long number) {
		if (number < MAX1) {
			return new int[] { 2, 7, 61 };
		} else if (number < MAX2) {
			return new int[] { 2, 3, 5, 7, 11, 13, 17 };
		}
		throw new RuntimeException("Za duża liczba: " + number);
	}

}
