package pl.com.simbit.utility.numbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TruncatedNumbers {

	public static List<Integer> getNumbersTruncatedFromLeftAndRight(int number) {

		Set<Integer> numbersSet = new HashSet<Integer>();

		String stringNum = String.valueOf(number);

		int length = stringNum.length();
		for (int i = 0; i < length; i++) {
			numbersSet.add(Integer.parseInt(stringNum.substring(0, i + 1)));
			numbersSet.add(Integer.parseInt(stringNum.substring(i, length)));
		}

		List<Integer> numbers = new ArrayList<Integer>(numbersSet);
		return numbers;
	}
}