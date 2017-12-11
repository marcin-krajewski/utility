package pl.com.simbit.utility.poker;

import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PokerHandsTest {

	private Logger logger = LoggerFactory.getLogger(PokerHandsTest.class);

	@Test
	public void shouldHighCardWorksCorrectTest() {
		PokerHand handForPoker = new PokerHand(new Poker("2C", "KS", "JC",
				"AH", "8D"));

		Assert.assertNotNull(handForPoker);
		Assert.assertEquals(PokerHandType.HighCard, handForPoker.getType());

		handForPoker = new PokerHand(new Poker("2H", "KH", "JH", "AH", "8H"));

		Assert.assertNotNull(handForPoker);
		Assert.assertEquals(PokerHandType.Flush, handForPoker.getType());
	}

	@Test
	public void shouldPairWorksCorrectTest() {
		PokerHand handForPoker = new PokerHand(new Poker("2C", "2S", "JC",
				"AH", "8D"));

		Assert.assertNotNull(handForPoker);
		Assert.assertEquals(PokerHandType.OnePair, handForPoker.getType());
	}

	@Test
	public void shouldTwoPairsWorksCorrectTest() {
		PokerHand handForPoker = new PokerHand(new Poker("2C", "2S", "JC",
				"AH", "JD"));

		Assert.assertNotNull(handForPoker);
		Assert.assertEquals(PokerHandType.TwoPairs, handForPoker.getType());
	}

	@Test
	public void shouldThreeOfKindWorksCorrectTest() {
		PokerHand handForPoker = new PokerHand(new Poker("2C", "2S", "JC",
				"AH", "2D"));

		Assert.assertNotNull(handForPoker);
		Assert.assertEquals(PokerHandType.ThreeOfKind, handForPoker.getType());
	}

	@Test
	public void shouldStraightWorksCorrectTest() {
		PokerHand handForPoker = new PokerHand(new Poker("5C", "3S", "4C",
				"6H", "2D"));

		Assert.assertNotNull(handForPoker);
		Assert.assertEquals(PokerHandType.Straight, handForPoker.getType());

		handForPoker = new PokerHand(new Poker("5C", "3S", "4C", "AH", "2D"));

		Assert.assertNotNull(handForPoker);
		Assert.assertEquals(PokerHandType.Straight, handForPoker.getType());
	}

	@Test
	public void shouldFlushWorksCorrectTest() {
		PokerHand handForPoker = new PokerHand(new Poker("5C", "2C", "4C",
				"KC", "AC"));

		Assert.assertNotNull(handForPoker);
		Assert.assertEquals(PokerHandType.Flush, handForPoker.getType());

		handForPoker = new PokerHand(new Poker("JS", "AS", "4S", "QS", "TS"));

		Assert.assertNotNull(handForPoker);
		Assert.assertEquals(PokerHandType.Flush, handForPoker.getType());
	}

	@Test
	public void shouldFullHouseWorksCorrectTest() {
		PokerHand handForPoker = new PokerHand(new Poker("2C", "2S", "JC",
				"JH", "JD"));

		Assert.assertNotNull(handForPoker);
		Assert.assertEquals(PokerHandType.FullHouse, handForPoker.getType());
	}

	@Test
	public void shouldFourOfKindWorksCorrectTest() {
		PokerHand handForPoker = new PokerHand(new Poker("2C", "2S", "2H",
				"2D", "8D"));

		Assert.assertNotNull(handForPoker);
		Assert.assertEquals(PokerHandType.FourOfKind, handForPoker.getType());
	}

	@Test
	public void shouldStraightFlushWorksCorrectTest() {
		PokerHand handForPoker = new PokerHand(new Poker("5C", "3C", "4C",
				"6C", "2C"));

		Assert.assertNotNull(handForPoker);
		Assert.assertEquals(PokerHandType.StraightFlush, handForPoker.getType());

		handForPoker = new PokerHand(new Poker("5H", "3H", "4H", "AH", "2H"));

		Assert.assertNotNull(handForPoker);
		Assert.assertEquals(PokerHandType.StraightFlush, handForPoker.getType());

		handForPoker = new PokerHand(new Poker("9D", "TD", "KD", "JD", "QD"));

		Assert.assertNotNull(handForPoker);
		Assert.assertEquals(PokerHandType.StraightFlush, handForPoker.getType());
	}

	@Test
	public void shouldRoyalFlushWorksCorrectTest() {
		PokerHand handForPoker = new PokerHand(new Poker("AC", "QC", "JC",
				"TC", "KC"));

		Assert.assertNotNull(handForPoker);
		Assert.assertEquals(PokerHandType.RoyalFlush, handForPoker.getType());

		handForPoker = new PokerHand(new Poker("QH", "AH", "KH", "JH", "TH"));

		Assert.assertNotNull(handForPoker);
		Assert.assertEquals(PokerHandType.RoyalFlush, handForPoker.getType());

		handForPoker = new PokerHand(new Poker("KD", "TD", "AD", "JD", "QD"));

		Assert.assertNotNull(handForPoker);
		Assert.assertEquals(PokerHandType.RoyalFlush, handForPoker.getType());

		handForPoker = new PokerHand(new Poker("KS", "TS", "AS", "JS", "QS"));

		Assert.assertNotNull(handForPoker);
		Assert.assertEquals(PokerHandType.RoyalFlush, handForPoker.getType());
	}

}
