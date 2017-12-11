package pl.com.simbit.utility.math;

import java.util.HashMap;
import java.util.Map;

public class RecurringCycle {

	public static int getReccuringCycleLengthForNumber(double divisor) {
		if (divisor == 1.0) {
			return -1;
		}

		double numberToDivide = 10.0;
		int indexOfResult = 0;
		while (numberToDivide < divisor) {
			numberToDivide *= 10;
			indexOfResult++;
		}

		Map<Double, Integer> subtractionResultsWithIndexOfResult = new HashMap<Double, Integer>();

		int resultOfDivision;
		while (true) {
			resultOfDivision = (int) (numberToDivide / divisor);
			numberToDivide = numberToDivide - resultOfDivision * divisor;

			if (subtractionResultsWithIndexOfResult.containsKey(numberToDivide)) {
				return indexOfResult - subtractionResultsWithIndexOfResult.get(numberToDivide);
			}
			if (numberToDivide == 0.0) {
				return -1;
			}

			subtractionResultsWithIndexOfResult.put(numberToDivide, indexOfResult++);
			numberToDivide *= 10;
			while (numberToDivide < divisor) {
				numberToDivide *= 10;
				indexOfResult++;
			}
		}
	}
}
