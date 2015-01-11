package algorithm.nlp;

public enum Sentiment {
	VERY_NEGATIVE(0),
	NEGATIVE(1),
	NEUTRAL(2),
	POSITIVE(3),
	VERY_POSITIVE(4);

	private int value;

	Sentiment(int value) {
		this.value = value;
	}
	
	public static Sentiment fromInt(int i) {
		return values()[i];
	}

	public int asInt() {
		return value;
	}
}
