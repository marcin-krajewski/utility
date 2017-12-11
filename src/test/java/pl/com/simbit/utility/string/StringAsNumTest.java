package pl.com.simbit.utility.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringAsNumTest {

    @Test
    public void checkGetStringAsNumArray0IsHigherMaxIsLowerTest() {
        String number = "12345";
        int[] array = StringAsNum.getStringAsNumArray0IsHigherMaxIsLower(number);
        
        assertEquals(array[0], 1);
        assertEquals(array[1], 2);
        assertEquals(array[2], 3);
        assertEquals(array[3], 4);
        assertEquals(array[4], 5);
    }
    
    @Test
    public void checkGetStringAsNumArray0IsLowerMaxIsHigherTest() {
        String number = "12345";
        int[] array = StringAsNum.getStringAsNumArray0IsLowerMaxIsHigher(number);
        
        assertEquals(array[0], 5);
        assertEquals(array[1], 4);
        assertEquals(array[2], 3);
        assertEquals(array[3], 2);
        assertEquals(array[4], 1);
    }
    
    @Test
    public void checkIfClearStringNumberFromLeadingZerosIs0IfStringIsZeros() {
        String number = "000";
        assertEquals("0", StringAsNum.clearStringNumberFromLeadingZeros(number));
        number = "0";
        assertEquals("0", StringAsNum.clearStringNumberFromLeadingZeros(number));
    }
    
    @Test
    public void checkIfClearStringNumberFromLeadingZerosWorksCorrectly() {
        String number = "0001234567890";
        assertEquals("1234567890", StringAsNum.clearStringNumberFromLeadingZeros(number));
    }
    
    @Test
    public void checkIfSumNumbersWorksCorrectly() {
        String[] numbers = new String[] { "12", "23", "34"};
        assertEquals("69", StringAsNum.sumStringNumbers(numbers));
    }
    
    @Test
    public void checkIfSumNumbersWorksCorrectlyIfStringArrayHasOneElement() {
        String[] numbers = new String[] { "12"};
        assertEquals("12", StringAsNum.sumStringNumbers(numbers));
    }
    
    @Test
    public void checkIfSumNumbersReverseWorksCorrectly() {
        String[] numbers = new String[] { "12", "23", "34"};
        assertEquals("96", StringAsNum.sumStringNumbersReverse(numbers));
    }
    
    @Test
    public void checkIfSumNumbersReverseWorksCorrectlyIfStringArrayHasOneElement() {
        String[] numbers = new String[] { "12"};
        assertEquals("21", StringAsNum.sumStringNumbersReverse(numbers));
    }
    
    @Test
    public void checkIfProductTwoNumbersWorksCorrectly() {
        String s1 = "12";
        String s2 = "23";
        
        assertEquals("276", StringAsNum.productTwoNumbers(s1, s2));
    }
    
    @Test
    public void checkIfProductTwoNumbersWorksCorrectlyIfOneOfStringsIs0() {
        String s1 = "12";
        String s2 = "0";
        assertEquals("0", StringAsNum.productTwoNumbers(s1, s2));
        
        s1 = "0";
        s2 = "12";
        assertEquals("0", StringAsNum.productTwoNumbers(s1, s2));
    }
    
    @Test
    public void checkIfProductTwoNumbersWorksCorrectlyIfOneOfStringsIs1() {
        String s1 = "12";
        String s2 = "1";
        assertEquals("12", StringAsNum.productTwoNumbers(s1, s2));

        s1 = "1";
        s2 = "12";
        assertEquals("12", StringAsNum.productTwoNumbers(s1, s2));
    }
    
    @Test
    public void checkIfSumNumbersInStringNumberWorksCorrectly() {
        String number = "00001234567890";
        assertEquals(45, StringAsNum.sumNumbersInStringNumber(number));
    }
}
