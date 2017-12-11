package pl.com.simbit.utility.numbers;

public class SequenceOfTriangle {

	public static Double getTriangle(Double number) {
		Double sum = 0.0;
		for (double i = 1.0; i <= number; i++) {
			sum += i;
		}
		return sum;
	}
}
