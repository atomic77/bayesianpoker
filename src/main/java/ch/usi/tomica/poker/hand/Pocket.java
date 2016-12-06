package ch.usi.tomica.poker.hand;

import java.util.List;

public class Pocket extends CardCollection {
	public final static int OTHER = 0;
	public final static int PAIR = 1;
	public final static int SAMESUIT = 2;
	public final static int CONNECTED = 3;
	private final static String[] pocketNames = {
		"other","pair", "samesuit","connected" };
	
	public Pocket(int vals[]) {
		initializeCardCollecton(vals);
	}
	
	public Pocket() {
		initializeCardCollecton();
	}
	
	public String evaluatePocketHand(CardCollection h) {
		List<Integer> ranks = getRanks(); 
		List<Integer> suits = getSuits();
		
		if(ranks.get(0).equals(ranks.get(1))) {
			return "pair";
		} else if (suits.get(0).equals(suits.get(1))) {
			return "samesuit";
		} else if (Math.abs(ranks.get(0) - ranks.get(1)) == 1) {
			return "connected";
		} else  {
			return "other";
		}
	}
	public static String getPocketStr(int type) {
		if (type < 0 || type > 3) return null;
		return pocketNames[type];
	}
}
