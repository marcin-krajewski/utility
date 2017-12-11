package pl.com.simbit.utility.problems.numbers;

public class SumOfPowers {

	private int power = 2;

	public SumOfPowers() {
		// TODO Auto-generated constructor stub
	}

	public SumOfPowers(int power) {
		this.power = power;
	}

	public double getSumOfPower(double min, double max) {

		double result = 0.0;
		for (double i = min; i <= max; i++) {
			result += Math.pow(i, power);
		}
		return result;
	}

}
