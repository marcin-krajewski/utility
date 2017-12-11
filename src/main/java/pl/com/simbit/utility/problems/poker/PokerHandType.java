package pl.com.simbit.utility.problems.poker;

public enum PokerHandType {
	HighCard(0), OnePair(1), TwoPairs(2), ThreeOfKind(3), Straight(4), Flush(5), FullHouse(6), FourOfKind(7), StraightFlush(
			8), RoyalFlush(9);

	private int priority;

	private PokerHandType(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}
}