package pl.com.simbit.utility.problems.math;

public class AbundantNumbers {

	public static final boolean isAbundant(Integer number) {
		return PrimeFactor.countOfFactorsWithoutNumber(number) > number;
	}
}
