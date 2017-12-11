package pl.com.simbit.utility.numbers;

public class Triangle {

	public static int getNumberOfRightANgleTrianglesForPerimeter(int perimeter) {
		int numberOfTriangles = 0;
		for (int i = 1; i <= perimeter - 2; i++) {
			for (int j = i + 1; j <= perimeter - 1; j++) {
				for (int k = j + 1; k <= perimeter; k++) {
					if (i + j + k != perimeter) {
						continue;
					}
					if (i * i + j * j != k * k) {
						continue;
					}
					numberOfTriangles++;
				}
			}
		}
		return numberOfTriangles;
	}

}
