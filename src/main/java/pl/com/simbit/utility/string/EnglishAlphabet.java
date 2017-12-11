package pl.com.simbit.utility.string;

import java.util.HashMap;
import java.util.Map;

public class EnglishAlphabet {

	public static Map<Character, Integer> letters = new HashMap<Character, Integer>();
	static {
		letters.put('A', 1);
		letters.put('B', 2);
		letters.put('C', 3);
		letters.put('D', 4);
		letters.put('E', 5);
		letters.put('F', 6);
		letters.put('G', 7);
		letters.put('H', 8);
		letters.put('I', 9);
		letters.put('J', 10);
		letters.put('K', 11);
		letters.put('L', 12);
		letters.put('M', 13);
		letters.put('N', 14);
		letters.put('O', 15);
		letters.put('P', 16);
		letters.put('Q', 17);
		letters.put('R', 18);
		letters.put('S', 19);
		letters.put('T', 20);
		letters.put('U', 21);
		letters.put('V', 22);
		letters.put('W', 23);
		letters.put('X', 24);
		letters.put('Y', 25);
		letters.put('Z', 26);
	}

	public static Double getStringDoubleValue(String string) {
		return getStringLongValue(string).doubleValue();
	}

	public static Long getStringLongValue(String string) {
		Long value = 0L;
		for (int i = 0; i < string.length(); i++) {
			value += EnglishAlphabet.letters.get(string.charAt(i));
		}
		return value;
	}
}
