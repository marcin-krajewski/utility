package pl.com.simbit.utility.poker;

import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card> {

	public enum Type {
		A(13), K(12), Q(11), J(10), _10(9), _9(8), _8(7), _7(6), _6(5), _5(4), _4(3), _3(2), _2(1);

		private int order;

		private Type(int order) {
			this.order = order;
		}

		public int getOrder() {
			return order;
		}

		public static Map<Character, Type> types;

		static {
			types = new HashMap<Character, Card.Type>();
			types.put('A', A);
			types.put('K', K);
			types.put('Q', Q);
			types.put('J', J);
			types.put('T', _10);
			types.put('9', _9);
			types.put('8', _8);
			types.put('7', _7);
			types.put('6', _6);
			types.put('5', _5);
			types.put('4', _4);
			types.put('3', _3);
			types.put('2', _2);
		}
	}

	public enum Color {
		H, C, S, D;

		public static Map<Character, Color> colors;

		static {
			colors = new HashMap<Character, Card.Color>();
			colors.put('H', H);
			colors.put('C', C);
			colors.put('S', S);
			colors.put('D', D);
		}
	}

	private Color color;
	private Type type;

	public Card(String string) {
		this.type = Type.types.get(string.charAt(0));
		this.color = Color.colors.get(string.charAt(1));
		if (type == null || color == null) {
			throw new IllegalArgumentException("String: " + string);
		}
	}

	public Color getColor() {
		return color;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "C: " + type + color + "; ";
	}

	public int compareTo(Card card) {
		return -(card.getType().getOrder() - this.getType().getOrder());
	}
}
