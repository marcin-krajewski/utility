package pl.com.simbit.utility.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringPowerTest {

    @Test
    public void checkIfStringPowerReturns0IfNumberIs0() {
        int number = 0;
        int power = 10;
        assertEquals("0", StringPower.getPowerForNumberBelow10(number, power));
    }
}
