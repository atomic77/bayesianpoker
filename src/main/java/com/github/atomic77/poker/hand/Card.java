package com.github.atomic77.poker.hand;


import com.google.common.collect.ImmutableBiMap;

public class Card implements Comparable<Card>{

	private static final ImmutableBiMap<Integer, String> suitMap =
			ImmutableBiMap.<Integer, String>builder()
					.put(0, "c")
					.put(1, "d")
					.put(2, "h")
					.put(3, "s")
					.build();

    private static final ImmutableBiMap<Integer, String> rankMap =
			ImmutableBiMap.<Integer, String>builder()
					.put(0, "2")
					.put(1, "3")
					.put(2, "4")
					.put(3, "5")
					.put(4, "6")
					.put(5, "7")
					.put(6, "8")
					.put(7, "9")
					.put(8, "T")
					.put(9, "J")
					.put(10, "Q")
					.put(11, "K")
					.put(12, "A")
					.build();

	//	Numbered cards from 1-52
	private int value;  

	public Card() {}
	public Card(int value) {
		if (value < 1 || value > 52) 
			throw new IllegalArgumentException("Invalid card value!");
		this.value = value;
	}

	public Card(String s) {
		String[] parts = s.split("_");
		int rank = rankMap.inverse().get(parts[0]);
		int suit = suitMap.inverse().get(parts[1]);
		this.value = valueFromRankAndSuit(rank, suit);
	}

	private int valueFromRankAndSuit(int rank, int suit) {
		return rank + (suit * 13);
	}

	// Value from 0 - 3 corresponding to Clubs - Spades (alphabetic order)
	public int getSuit() {
		return (int)(Math.floor((double)value / 13));
	}

	// Ranks are from 0-12
	public int getRank() {
		return (value % 13);
	}
	
	public boolean isAce() {
		return (this.getRank() == 12);
	}

	public boolean isSameSuit(Card c) {
		return (this.getSuit() == c.getSuit()); 
	}
	
	public boolean isSameRank(Card c) {
		return (this.getRank() == c.getRank()); 
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getValue() == ((Card)obj).getValue()); 
	}
	
	@Override
	public String toString() {
		String s = null;
		int rank = getRank();
		int suit = getSuit();
		return rankMap.get(rank) + "_" + suitMap.get(suit);
	}
	
	// Getters and setters

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int compareTo(Card o) {
		return (o.getValue() - this.getValue());
	}


}
