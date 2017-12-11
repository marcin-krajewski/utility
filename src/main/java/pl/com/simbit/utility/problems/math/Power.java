package pl.com.simbit.utility.problems.math;

public class Power {

	public static Long powerForLastDigits(int number, int power, int digits) {
		if (number == 0) {
			return 0L;
		}
		if (power == 0) {
			return 1L;
		}
		if (power == 1) {
			return (long) number;
		}
		long result = 1;
		long mod = (long) Math.pow(10, digits);
		for (int i = 0; i < power; i++) {
			result = (result * number) % mod;
		}
		return result;
	}
}
