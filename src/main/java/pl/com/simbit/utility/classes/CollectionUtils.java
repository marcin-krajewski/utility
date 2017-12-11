package pl.com.simbit.utility.classes;

import java.util.HashSet;
import java.util.List;

public class CollectionUtils {
	public static <T> boolean hasUniqueElements(List<T> collection) {
		return collection.size() == new HashSet<T>(collection).size();
	}

	public static <T> T[] array(List<T> list) {
		return list.toArray((T[]) java.lang.reflect.Array.newInstance(list.get(0).getClass(), list.size()));
	}
}
