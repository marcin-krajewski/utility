package pl.com.simbit.utility.math;

import java.util.ArrayList;
import java.util.List;

public class SequenceNumbers {

	private static SequenceNumbers instance;

	private SequenceNumbers() {
	}

	public static synchronized SequenceNumbers getInstance() {
		if (instance == null) {
			instance = new SequenceNumbers();
		}
		return instance;
	}

	public List<Long> getTriangleNumberBelowMax(Long max) {
		List<Long> triangleNumbers = new ArrayList<Long>();
		Long num = getTriangleNumberForIndex(1L);
		triangleNumbers.add(num);
		for (long index = 2L;; index++) {
			num = getTriangleNumberForIndexAndPrevious(index, num);
			if (num > max) {
				break;
			}
			triangleNumbers.add(num);
		}
		return triangleNumbers;
	}

	public List<Long> getTriangleNumberToIndex(Long maxIndex) {
		List<Long> triangleNumbers = new ArrayList<Long>();
		Long num = getTriangleNumberForIndex(1L);
		triangleNumbers.add(num);
		for (long index = 2L; index <= maxIndex; index++) {
			num = getTriangleNumberForIndexAndPrevious(index, num);
			triangleNumbers.add(num);
		}
		return triangleNumbers;
	}

	public Long getTriangleNumberForIndex(Long index) {
		return index * (index + 1) / 2;
	}

	public Long getTriangleNumberForIndexAndPrevious(Long index, Long previous) {
		return previous + index;
	}

	public Long getPentagonalNumberForIndex(Long index) {
		return index * (3 * index - 1) / 2;
	}

	public Long getPentagonalNumberForIndexAndPrevious(Long index, Long previous) {
		return previous + 3 * index - 2;
	}

	public Long getHexagonalNumberForIndex(Long index) {
		return index * (2 * index - 1);
	}

	public Long getHexagonalNumberForIndexAndPrevious(Long index, Long previous) {
		return previous + 4 * index - 3;
	}
}
