package pl.com.simbit.utility.numbers;

import pl.com.simbit.utility.classes.MapDoubleKey;

public class TilesUtil {

	private static TilesUtil instance;

	private TilesUtil() {
	}

	public static synchronized TilesUtil getInstance() {
		if (instance == null) {
			instance = new TilesUtil();
		}
		return instance;
	}

	public long getMovesWithNotReturningColors(int tiles, int len) {
		if (tiles < len) {
			return 0L;
		}
		if (tiles == len) {
			return 1L;
		}

		Long sum = 0L;
		for (int singleNumber = 0; singleNumber < tiles; singleNumber++) {
			for (int colorNumber = 1; colorNumber <= tiles; colorNumber++) {
				if (tiles == (singleNumber + colorNumber * len)) {
					sum += nonReturnMoves(colorNumber, singleNumber, new MapDoubleKey<Integer, Integer, Long>());
				}
			}
		}
		return sum;
	}

	private Long nonReturnMoves(int colors, int single, MapDoubleKey<Integer, Integer, Long> map) {

		if (colors == 0 && single == 0) {
			return 1L;
		}

		if (map.get(colors, single) != null) {
			return map.get(colors, single);
		}

		long moves1 = 0;
		if (colors > 0) {
			moves1 = nonReturnMoves(colors - 1, single, map);
			map.put(colors - 1, single, moves1);
		}
		long moves2 = 0;
		if (single > 0) {
			moves2 = nonReturnMoves(colors, single - 1, map);
			map.put(colors, single - 1, moves2);
		}
		return moves1 + moves2;
	}

	public long getMovesWithReturningColors(int tiles) {

		Long sum = 0L;

		Long[][][][] tab = new Long[tiles + 1][tiles + 1][tiles + 1][tiles + 1];

		for (int green = 0; green < tiles; green++) {
			for (int red = 0; red < tiles; red++) {
				for (int blue = 0; blue < tiles; blue++) {
					for (int single = 0; single <= tiles; single++) {
						if (tiles == (single + 2 * red + 3 * green + 4 * blue)) {
							sum += returnMoves(red, green, blue, single, tab);
						}
					}
				}
			}
		}
		return sum;
	}

	private Long returnMoves(int red, int green, int blue, int single, Long[][][][] tab) {

		if (red == 0 && green == 0 && blue == 0 && single == 0) {
			return 1L;
		}

		if (tab[red][green][blue][single] != null) {
			return tab[red][green][blue][single];
		}

		long sum = 0;
		long moves;

		if (red > 0) {
			moves = returnMoves(red - 1, green, blue, single, tab);
			tab[red - 1][green][blue][single] = moves;
			sum += moves;
		}
		if (green > 0) {
			moves = returnMoves(red, green - 1, blue, single, tab);
			tab[red][green - 1][blue][single] = moves;
			sum += moves;
		}
		if (blue > 0) {
			moves = returnMoves(red, green, blue - 1, single, tab);
			tab[red][green][blue - 1][single] = moves;
			sum += moves;
		}
		if (single > 0) {
			moves = returnMoves(red, green, blue, single - 1, tab);
			tab[red][green][blue][single - 1] = moves;
			sum += moves;
		}
		return sum;
	}
}
