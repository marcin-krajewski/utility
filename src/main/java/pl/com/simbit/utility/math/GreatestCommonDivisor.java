package pl.com.simbit.utility.math;

public class GreatestCommonDivisor {

	public static double getGreatestCommonDivisor(double number1, double number2) {

		Double[] factorsNum1 = PrimeFactor.getPrimeFactorsOfNumber(number1);
		Double[] factorsNum2 = PrimeFactor.getPrimeFactorsOfNumber(number2);

		double divisor = 1.0;

		for (Double factor1 : factorsNum1) {
			for (int i = 0; i < factorsNum2.length; i++) {
				Double factor2 = factorsNum2[i];
				if (factorsNum2[i] > 0.0 && factor2.equals(factor1)) {
					divisor *= factor1;
					factorsNum2[i] = 0.0;
					break;
				}
			}
		}

		return divisor;
	}
}
