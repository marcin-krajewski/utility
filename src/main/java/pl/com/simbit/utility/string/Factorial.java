package pl.com.simbit.utility.string;

public class Factorial {

	public static double factorial(double num) {
		if (num == 1.0) {
			return num;
		}
		return num * factorial(num - 1);
	}

	public static String factorial(int max) {
		if (max == 0) {
			return "1";
		} else if (max <= 0) {
			return "0";
		}

		String factorial = "1";
		for (int i = 1; i <= max; i++) {
			factorial = StringAsNum.productTwoNumbers(i + "", factorial);
		}
		return factorial;
	}

	public static Integer numberFactorial(int number) {
		try {
			return Integer.parseInt(factorial(number));
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
