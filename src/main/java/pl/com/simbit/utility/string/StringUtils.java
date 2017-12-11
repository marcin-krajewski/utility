package pl.com.simbit.utility.string;

import java.util.Arrays;
import java.util.Comparator;

public class StringUtils {

	private static StringUtils instance;

	private StringUtils() {
	}

	public static synchronized StringUtils getInstance() {
		if (instance == null) {
			instance = new StringUtils();
		}
		return instance;
	}

	public static Comparator<String> getStringComparator() {
		return new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
	}

	public String getLastStringCharacters(String string, int chars) {
		int length = string.length();
		if (length < chars) {
			return string;
		}
		return string.substring(length - chars, length);
	}

	public String stringAt(String input, int index) {
		return input.substring(index, index + 1);
	}

	public String sortCharsInStringAlphabetically(String input) {
		char[] chars = input.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}
