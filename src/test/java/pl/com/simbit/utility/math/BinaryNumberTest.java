package pl.com.simbit.utility.math;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class BinaryNumberTest {
	
	@Test
	@Ignore
	public void checkIfZeroIsCorrect() {
		assertEquals("0", BinaryNumber.getBinaryStringForNumber(0));
	}

    @Test
    public void checkIfDecimalNumberIsCorrectInBinary() {
        assertEquals("1", BinaryNumber.getBinaryStringForNumber(1));
        assertEquals("10000", BinaryNumber.getBinaryStringForNumber(16));
        assertEquals("111111", BinaryNumber.getBinaryStringForNumber(63));
    }
}
