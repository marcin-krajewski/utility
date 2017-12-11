package pl.com.simbit.utility.problems.string;


public class StringPower {

	public static String getPowerForNumberBelow10(int number, int pow) {

		if (number == 0) {
			return "0";
		}
		if (pow == 0) {
			return "1";
		}
		if (pow == 1) {
			return number + "";
		}
		String stringPower = "1";
		for (int i = 0; i < pow; i++) {
			stringPower = StringAsNum.productTwoNumbers(number + "", stringPower);
		}
		return stringPower;
	}

	public static String getLastDigitsPowerForNumberBelow10(int number, int pow, int digits) {

		if (number == 0) {
			return "0";
		}
		if (pow == 0) {
			return "1";
		}
		if (pow == 1) {
			return number + "";
		}
		String stringPower = "1";
		for (int i = 0; i < pow; i++) {
			stringPower = StringUtils.getInstance().getLastStringCharacters(
					StringAsNum.productTwoNumbers(number + "", stringPower), 10);
		}
		return stringPower;
	}
}
