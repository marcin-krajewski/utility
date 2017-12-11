package pl.com.simbit.utility.problems.classes;

import java.lang.reflect.Array;
import java.util.Map;

public class ArrayUtils {

	public static <T> T[] createArrayWithSizeAndValue(int size, T value, Class<?> classValue) {

		T[] array = getArrayForSizeAndClass(size, classValue);
		for (int i = 0; i < size; i++) {
			array[i] = value;
		}

		return array;
	}

	@SuppressWarnings("unchecked")
	private static <T> T[] getArrayForSizeAndClass(int size, Class<?> classValue) {
		return (T[]) Array.newInstance(classValue, size);
	}

	public static <T> void incrementValueInMapOrPut1(T key, Map<T, Integer> map) {
		Integer number = map.get(key);
		if (number == null) {
			map.put(key, 1);
			return;
		}
		map.put(key, number + 1);
	}
}
