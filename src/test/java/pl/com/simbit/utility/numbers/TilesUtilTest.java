package pl.com.simbit.utility.numbers;

import junit.framework.Assert;

import org.junit.Test;

import pl.com.simbit.utility.problems.numbers.TilesUtil;

public class TilesUtilTest {

	@Test
	public void shouldCorrectWellWithoutReturningTest() {
		Assert.assertEquals(0, TilesUtil.getInstance().getMovesWithNotReturningColors(5, 6));
		Assert.assertEquals(1, TilesUtil.getInstance().getMovesWithNotReturningColors(5, 5));
		Assert.assertEquals(7, TilesUtil.getInstance().getMovesWithNotReturningColors(5, 2));
		Assert.assertEquals(2, TilesUtil.getInstance().getMovesWithNotReturningColors(5, 4));
		Assert.assertEquals(3, TilesUtil.getInstance().getMovesWithNotReturningColors(5, 3));
		Assert.assertEquals(5, TilesUtil.getInstance().getMovesWithNotReturningColors(6, 3));
		Assert.assertEquals(12, TilesUtil.getInstance().getMovesWithNotReturningColors(6, 2));
	}

	@Test
	public void shouldCorrectWellWithReturningTest() {
		Assert.assertEquals(15, TilesUtil.getInstance().getMovesWithReturningColors(5));
	}
}
