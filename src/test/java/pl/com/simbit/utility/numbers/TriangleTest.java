package pl.com.simbit.utility.numbers;

import static org.junit.Assert.*;
import org.junit.Test;

public class TriangleTest {

	@Test
	public void checkNumberOfRightTringlesForPerimeter() {

		assertEquals(3, Triangle.getNumberOfRightANgleTrianglesForPerimeter(120));
	}
}
