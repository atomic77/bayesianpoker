package ch.usi.tomica.poker.hand;

import java.util.TreeSet;

public class Hand extends CardCollection {
	public final static int NOTHING = 0;
	public final static int PAIR = 1;
	public final static int TWOPAIR = 2;
	public final static int TRIPLE = 3;
	public final static int STRAIGHT = 4;
	public final static int FLUSH = 5;
	public final static int FULLHOUSE = 6;
	public final static int QUAD = 7;
	public final static int STRAIGHTFLUSH = 8;
	private final static String[] handNames = {
		"nothing","pair", "twopair","triple",
		"straight","flush","fullhouse","quad","straightflush"
		};
	
	public Hand(int vals[]) {
		initializeCardCollecton(vals);
	}
	
	public Hand() {
		initializeCardCollecton();
	}
	
	public static String getHandStr(int type) {
		if (type < 0 || type > 8) return null;
		return handNames[type];
	}
	
	public int evaluateHand() {
		// TODO there must be a better way to do this; can't create an equiv.
		// of an array of function pointers?
		if(isStraightFlush()) return STRAIGHTFLUSH;
		if(isQuad()) return QUAD;
		if(isFullHouse()) return FULLHOUSE;
		if(isFlush()) return FLUSH;
		if(isStraight()) return STRAIGHT;
		if(isTriple()) return TRIPLE;
		if(isTwoPair()) return TWOPAIR;
		if(isPair()) return PAIR;
		return NOTHING;
	}
	
	public boolean isStraightFlush() {
		/* Since the vast majority of hands are not SFs, but we always have to 
		 * check, try to exit as soon as possible and use a more expensive 
		 * computation if we have both */
		if (!hasFlush(5)) return false;
		if (!hasStraight(5)) return false;
		// TODO re-implement from R code
		return false;
	}
	
	public boolean isQuad() {
		for (int rc : getRankCounts()) {
			if (rc == 4) return true;
		}
		return false;
	}
	
	public boolean isFullHouse() {
		int trips = 0;
		int pairs = 0;
		for (int rc : getRankCounts()) {
			if (rc == 2) pairs++;
			if (rc >= 3) trips++;
		}
		return (trips >= 1 && pairs >= 1) || (trips >= 2);
	}
	
	public boolean isStraight() {
		return hasStraight(5);
	}
	
	public boolean isFlush() {
		return hasFlush(5);
	}
	
	public boolean isTriple() {
		for (int rc : getRankCounts()) {
			if (rc == 3) return true;
		}
		return false;
	}
	
	public boolean isTwoPair() {
		int pairs = 0;
		for (int rc : getRankCounts()) {
			if (rc == 2) pairs++;
		}
		return pairs >= 2;
	}
	
	public boolean isPair() {
		for (int rc : getRankCounts()) {
			if (rc == 2) return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String s = "";
		for (Card c : cards) {
			s = s + c + " ";
		}
		return s;
	}


}
