package pl.com.simbit.utility.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void checkIfProductOk() {
		String num1 = "115";
		String num2 = "24";
		String product1 = StringAsNum.productTwoNumbers(num1, num2);
		String product2 = StringAsNum.productTwoNumbers(num2, num1);
		assertEquals("2760", product1);
		assertEquals("2760", product2);
		assertEquals(product1, product2);
	}

	@Test
	public void checkIfGetLastStringCharsWorksCorrectTest() {
		assertEquals("", StringUtils.getInstance().getLastStringCharacters("", 3));
		assertEquals("cde", StringUtils.getInstance().getLastStringCharacters("cde", 3));
		assertEquals("cde", StringUtils.getInstance().getLastStringCharacters("abcde", 3));
	}

	@Test
	public void stringAt() {
		assertEquals("1", StringUtils.getInstance().stringAt("123456789", 0));
		assertEquals("4", StringUtils.getInstance().stringAt("123456789", 3));
		assertEquals("7", StringUtils.getInstance().stringAt("123456789", 6));
		assertEquals("9", StringUtils.getInstance().stringAt("123456789", 8));
	}
}
