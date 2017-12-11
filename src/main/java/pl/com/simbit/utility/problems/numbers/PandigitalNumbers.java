package pl.com.simbit.utility.problems.numbers;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PandigitalNumbers {

	private static Logger logger = LoggerFactory.getLogger(PandigitalNumbers.class);

	private static int MAX = 9;

	private static int bit;

	private static void resetBits() {
		bit = 0;
		for (int i = 0; i <= MAX; i++) {
			bit = setBit(bit, i);
		}
	}

	public static int setBit(int number, int position) {
		return number |= (1 << position);
	}

	public static int unsetBit(int number, int position) {
		return number &= ~(1 << position);
	}

	public static Boolean isBitSet(int number, int position) {
		return (number & (1 << position)) != 0;
	}

	public static void main(String[] args) {
		getAllPandigitalNumbers();
	}

	public static Set<String> getAllPandigitalNumbersForMax(int max) {
		MAX = max;
		return getAllPandigitalNumbers();
	}

	public static Set<String> getAllPandigitalNumbers() {
		resetBits();
		Set<String> numbers = new HashSet<String>();

		for (int i = 0; i <= MAX; i++) {
			bit = unsetBit(bit, i);
			getStr(0, i + "", numbers);
			bit = setBit(bit, i);
		}

		logger.info("C: {}", numbers.size());

		return numbers;
	}

	private static void getStr(int pos, String s, Set<String> numbers) {
		if (pos >= MAX) {
			numbers.add(s);
			return;
		}
		for (int i = 0; i <= MAX; i++) {
			if (isBitSet(bit, i)) {
				bit = unsetBit(bit, i);
				getStr(pos + 1, s + i, numbers);
				bit = setBit(bit, i);
			}
		}
	}
}
