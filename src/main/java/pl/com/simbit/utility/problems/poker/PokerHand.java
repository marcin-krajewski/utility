package pl.com.simbit.utility.problems.poker;

import java.util.List;

public class PokerHand implements Comparable<PokerHand> {

	private Poker poker;
	private PokerHandType type;
	private List<Card.Type> descOrderedTypes;

	public PokerHand(Poker poker) {
		this.poker = poker;
		this.setTypeForPoker(poker);
	}

	private void setTypeForPoker(Poker poker) {
		int colorsSize = poker.getColorsSize();
		int typesSize = poker.getTypesSize();
		int maxTypeCount = poker.getMaxCountOfOneType();
		int maxMinCardDiff = poker.getMaxMinCardDiff();
		Card.Type maxTypeCard = poker.getMaxType();

		PokerHandType type = null;

		switch (typesSize) {
		case 2:
			if (maxTypeCount == 4) {
				type = PokerHandType.FourOfKind;
			} else if (maxTypeCount == 3) {
				type = PokerHandType.FullHouse;
			}
			break;
		case 3:
			if (maxTypeCount == 3) {
				type = PokerHandType.ThreeOfKind;
			} else if (maxTypeCount == 2) {
				type = PokerHandType.TwoPairs;
			}
			break;
		case 4:
			type = PokerHandType.OnePair;
			break;
		case 5:
			if (colorsSize == 1) {
				if (maxMinCardDiff == 4) {
					if (maxTypeCard == Card.Type.A) {
						type = PokerHandType.RoyalFlush;
					} else {
						type = PokerHandType.StraightFlush;
					}
				} else if (poker.isFromAceToFourStraight()) {
					type = PokerHandType.StraightFlush;
				} else {
					type = PokerHandType.Flush;
				}
			} else {
				if (maxMinCardDiff == 4 || poker.isFromAceToFourStraight()) {
					type = PokerHandType.Straight;
				} else {
					type = PokerHandType.HighCard;
				}
			}
			break;
		}

		this.type = type;
	}

	public PokerHandType getType() {
		return type;
	}

	public List<Card.Type> getDescOrderedTypes() {
		return descOrderedTypes;
	}

	public Poker getPoker() {
		return poker;
	}

	public int compareTo(PokerHand pokerHand) {
		int diff = this.getType().getPriority() - pokerHand.getType().getPriority();
		if (diff != 0) {
			return diff;
		}

		switch (type) {
		case HighCard:
		case Flush:
			return this.poker.getHighCardPriority() - pokerHand.getPoker().getHighCardPriority();
		case OnePair:
			return this.poker.getOnePairPriority() - pokerHand.getPoker().getOnePairPriority();
		case TwoPairs:
			return this.poker.getTwoPairsPriority() - pokerHand.getPoker().getTwoPairsPriority();
		case ThreeOfKind:
			return this.poker.getThreeOfKindPriority() - pokerHand.getPoker().getThreeOfKindPriority();
		case Straight:
		case StraightFlush:
			return this.poker.getStraightPriority() - pokerHand.getPoker().getStraightPriority();
		case FullHouse:
			return this.poker.getFullHousePriority() - pokerHand.getPoker().getFullHousePriority();
		case FourOfKind:
			return this.poker.getFourOfKindPriority() - pokerHand.getPoker().getFourOfKindPriority();
		case RoyalFlush:
		default:
			return 0;
		}
	}
}
