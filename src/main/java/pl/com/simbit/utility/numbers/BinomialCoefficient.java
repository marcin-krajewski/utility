package pl.com.simbit.utility.numbers;

public class BinomialCoefficient {

	public static double getBinomialCoefficient(int n, int k) {
		double res = 1;
		double nMinusK = n - k;
		for (double i = 1.0; i <= k; i++) {
			res *= (nMinusK + i);
			res /= i;
		}
		return res;
	}

	public static boolean isBinomialCoefficientGreaterThan(int n, int k, long num) {
		double res = 1;
		double nMinusK = n - k;
		for (int i = 1; i <= k; i++) {
			res *= (nMinusK + i);
			res /= i;
			if (res > num) {
				return true;
			}
		}
		return false;
	}
}
