package pl.com.simbit.utility.math;

public class Triangle {

	public static boolean isPointInTriangle(Point p1, Point p2, Point p3, Point toCheck) {
		long f1 = calculatePoint(p1, p2, toCheck);
		long f2 = calculatePoint(p2, p3, toCheck);
		long f3 = calculatePoint(p3, p1, toCheck);

		return f1 * f2 > 0 && f2 * f3 > 0;
	}

	public static boolean isOriginInTriangle(Point p1, Point p2, Point p3) {

		Point toCheck = new Point(0, 0);
		return isPointInTriangle(p1, p2, p3, toCheck);
	}

	private static long calculateZero(Point p1, Point p2) {
		Point toCheck = new Point(0, 0);
		return calculatePoint(p1, p2, toCheck);
	}

	private static long calculatePoint(Point p1, Point p2, Point toCheck) {
		return (p2.x - p1.x) * (toCheck.y - p1.y) - (p2.y - p1.y) * (toCheck.x - p1.x);
	}
}
