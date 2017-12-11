package pl.com.simbit.utility.classes;

public class IntegerDoubleKey extends MapDoubleKey<Integer, Integer, Integer> {

	public void addValue(Integer k1, Integer k2, Integer v) {
		Integer val = get(k1, k2);
		if (val == null) {
			val = 0;
		}
		put(k1, k2, val + v);
	}
}
