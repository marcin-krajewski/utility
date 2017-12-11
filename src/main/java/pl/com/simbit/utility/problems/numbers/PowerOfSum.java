package pl.com.simbit.utility.problems.numbers;

public class PowerOfSum {

	private int power = 2;

	public PowerOfSum() {
		// TODO Auto-generated constructor stub
	}

	public PowerOfSum(int power) {
		this.power = power;
	}

	public double getPowerOfSum(double min, double max) {
		double sum = 0.0;

		for (double i = min; i <= max; i++) {
			sum += i;
		}
		return Math.pow(sum, power);
	}
}
