package ch.usi.tomica.poker.hand;

import java.util.HashSet;
import java.util.Set;


public class Card implements Comparable<Card>{
	
	//	Numbered cards from 1-52
	private int value;  
	
	public Card() {
	}
	
	public Card(int value) {
		if (value < 1 || value > 52) 
			throw new IllegalArgumentException("Invalid card value!");
		this.value = value;
	}
	
	// Value from 1 - 4 corresponding to Clubs - Spades (alphabetic order)
	public int getSuit() {
		return (int)(Math.ceil((double)value / 13));
	}

	// Ranks are from 1-13, to make it clearer that value 2 = a 'deuce'
	public int getRank() {
		return (value % 13) + 1;
	}
	
	public boolean isAce() {
		return (this.getRank() == 1);
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
		if (rank >= 2 && rank <= 10) {
			s = "" + rank;
		} else {
			switch (rank) {
			case 11:
				s = "J";
				break;
			case 12:
				s = "Q";
				break;
			case 13:
				s = "K";
				break;
			case 1:
				s = "A";
				break;
			}
		}
		
		switch (suit) {
		case 1:
			s += "_Cl";
			break;
		case 2:
			s += "_Di";
			break;
		case 3:
			s += "_Hr";
			break;
		case 4:
			s += "_Sp";
			break;
		}
		
		return s;
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
