package pl.com.simbit.utility.poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.com.simbit.utility.poker.Card.Color;
import pl.com.simbit.utility.poker.Card.Type;

public class Poker {

	private Logger logger = LoggerFactory.getLogger(Poker.class);

	private List<Card> cards;

	private Map<Type, Set<Card>> types;
	private Map<Color, Set<Card>> colors;

	public Poker(String... cards) {

		types = new HashMap<Card.Type, Set<Card>>();
		colors = new HashMap<Card.Color, Set<Card>>();

		this.cards = new ArrayList<Card>();
		for (int i = 0; i < 5; i++) {
			this.cards.add(new Card(cards[i]));
			addCardToTypes(this.cards.get(i));
			addCardToColors(this.cards.get(i));
		}
		Collections.sort(this.cards);
	}

	private void addCardToTypes(Card card) {
		addCardToMapWithKey(card.getColor(), colors, card);
	}

	private void addCardToColors(Card card) {
		addCardToMapWithKey(card.getType(), types, card);
	}

	private <T> void addCardToMapWithKey(T key, Map<T, Set<Card>> map, Card cardToAdd) {
		Set<Card> set = map.get(key);
		if (set == null) {
			set = new HashSet<Card>();
			map.put(key, set);
		}
		set.add(cardToAdd);
	}

	public int getTypesSize() {
		return types.size();
	}

	public int getColorsSize() {
		return colors.size();
	}

	public int getTypeSize(Type type) {
		Set<Card> set = this.types.get(type);
		if (set == null) {
			return 0;
		}
		return set.size();
	}

	public int getMaxCountOfOneType() {
		int max = 0;
		for (Entry<Type, Set<Card>> entry : types.entrySet()) {
			int typeSize = entry.getValue().size();
			if (typeSize > max) {
				max = typeSize;
			}
		}
		return max;
	}

	public int getMaxMinCardDiff() {
		int max = 0;
		int min = Type.A.getOrder() + 1;
		for (Entry<Type, Set<Card>> entry : types.entrySet()) {
			int order = entry.getKey().getOrder();
			if (order > max) {
				max = order;
			}
			if (order < min) {
				min = order;
			}
		}
		return max - min;
	}

	public boolean isFromAceToFourStraight() {
		return types.get(Type.A) != null && types.get(Type._2) != null && types.get(Type._3) != null
				&& types.get(Type._4) != null && types.get(Type._5) != null;
	}

	public Type getMaxType() {
		int max = 0;
		Type type = null;
		for (Entry<Type, Set<Card>> entry : types.entrySet()) {
			Type tempType = entry.getKey();
			int order = tempType.getOrder();
			if (order > max) {
				max = order;
				type = tempType;
			}
		}
		return type;
	}

	public Type getMinType() {
		int min = Type.A.getOrder() + 1;
		Type type = null;
		for (Entry<Type, Set<Card>> entry : types.entrySet()) {
			Type tempType = entry.getKey();
			int order = tempType.getOrder();
			if (order < min) {
				min = order;
				type = tempType;
			}
		}
		return type;
	}

	public int getHighCardPriority() {
		int result = 0;
		for (int i = 0; i < 5; i++) {
			result += Math.pow(10, i) * cards.get(i).getType().getOrder();
		}
		return result;
	}

	public int getOnePairPriority() {
		int result = 0;
		for (int i = 0; i < 5; i++) {
			Type type = cards.get(i).getType();
			if (getTypeSize(type) == 2) {
				result += Math.pow(10, 5) * type.getOrder();
			} else {
				result += Math.pow(10, i) * type.getOrder();
			}
		}
		return result;
	}

	public int getTwoPairsPriority() {
		int result = 0;
		int pairPower = 5;
		for (int i = 0; i < 5; i++) {
			Type type = cards.get(i).getType();
			if (getTypeSize(type) == 2) {
				result += Math.pow(10, pairPower++) * type.getOrder();
			} else {
				result += Math.pow(10, i) * type.getOrder();
			}
		}
		return result;
	}

	public int getThreeOfKindPriority() {
		int result = 0;
		int pairPower = 5;
		for (int i = 0; i < 5; i++) {
			Type type = cards.get(i).getType();
			if (getTypeSize(type) == 3) {
				result += Math.pow(10, pairPower++) * type.getOrder();
			} else {
				result += Math.pow(10, i) * type.getOrder();
			}
		}
		return result;
	}

	public int getStraightPriority() {
		if (isFromAceToFourStraight()) {
			return Type._5.getOrder();
		}
		return cards.get(4).getType().getOrder();
	}

	public int getFullHousePriority() {
		int result = 0;
		for (int i = 0; i < 5; i++) {
			Type type = cards.get(i).getType();
			if (getTypeSize(type) == 3) {
				result += Math.pow(10, 3) * type.getOrder();
			} else if (getTypeSize(type) == 2) {
				result += Math.pow(10, 2) * type.getOrder();
			}
		}
		return result;
	}

	public int getFourOfKindPriority() {
		int result = 0;
		for (int i = 0; i < 5; i++) {
			Type type = cards.get(i).getType();
			if (getTypeSize(type) == 4) {
				result += Math.pow(10, 5) * type.getOrder();
			} else {
				result += Math.pow(10, 1) * type.getOrder();
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		return Arrays.asList(cards).toString();
	}
}
