package pl.com.simbit.utility.problems.numbers;

import java.util.Map;

public class CollatzSequence {

	public static double numberOfSteps(double number, Map<Double, Double> map) {

		double steps = 1.0;
		if (number <= 1.0) {
			return steps;
		}

		if (map.containsKey(number)) {
			return map.get(number);
		}

		while (true) {
			if (number % 2 == 1) {
				number = 1.5 * number + 0.5;
				steps++;
			} else {
				number = number * 0.5;
				steps++;
				if (number == 1.0) {
					break;
				}
			}
			if (map.containsKey(number)) {
				return steps + map.get(number);
			}
		}

		return steps;
	}
}
