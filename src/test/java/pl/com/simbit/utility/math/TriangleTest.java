package pl.com.simbit.utility.math;

import junit.framework.Assert;

import org.junit.Test;

import pl.com.simbit.utility.problems.math.Point;
import pl.com.simbit.utility.problems.math.Triangle;

public class TriangleTest {

	@Test
	public void shouldOriginCheckWorksCorrectTest() {
		Point p1 = new Point(-340, 495);
		Point p2 = new Point(-153, -910);
		Point p3 = new Point(835, -947);

		Assert.assertTrue(Triangle.isOriginInTriangle(p1, p2, p3));

		p1 = new Point(-175, 41);
		p2 = new Point(-421, -714);
		p3 = new Point(574, -645);

		Assert.assertFalse(Triangle.isOriginInTriangle(p1, p2, p3));
	}

}
