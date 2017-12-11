package pl.com.simbit.utility.problems.string;

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
}
