package ch.usi.tomica.poker.hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.math3.random.RandomData;

public class CardCollection {

	protected SortedSet<Card> cards;

	protected void initializeCardCollecton() {
		cards = new TreeSet<Card>();
	}
	
	protected void initializeCardCollecton(int[] vals) {
		initializeCardCollecton();
		for (int i : vals) {
			Card c = new Card(i);
			cards.add(c);
		}
	}
	
	public void addCards(CardCollection col) {
		// TODO THere should be some sanity checking to be sure we don't add
		// copies of the same card
		for (Card c : col.cards) {
			cards.add(c);
		}
	}
	
	public void addCard(Card c) {
		cards.add(c);
	}

	public List<Integer> getSuits() {
		 ArrayList<Integer> suits = new ArrayList<Integer>(7);
		 for(Card c : cards) {
			 suits.add(c.getSuit());
		 }
		 return suits;
	}

	public List<Integer> getRanks() {
		 ArrayList<Integer> ranks = new ArrayList<Integer>(7);
		 for(Card c : cards) {
			 ranks.add(c.getRank());
		 }
		 return ranks;
	}

	public int[] getRankCounts() {
		int[] rankCounts = new int[13];
		for (int i =0; i<13; i++) rankCounts[i] = 0;
		for (int r : getRanks()) {
			rankCounts[r-1]++;
		}
		return rankCounts;
	}

	public int[] getSuitCounts() {
		int[] suitCounts = new int[4];
		for (int i =0; i < 4; i++) suitCounts[i] = 0;
		List<Integer> s = getSuits();
//		for (int r : getSuits()) {
		for (int r : s) {
			suitCounts[r-1]++;
		}
		return suitCounts;
	}

	/**
	 * If collection of cards has n or more cards of the same suit
	 * @param n
	 * @return
	 */
	public boolean hasFlush(int n) {
		for (int rc : getSuitCounts()) {
			if (rc >= n) return true;
		}
		return false;
	}

	/** 
	 * If collection of cards has straight of n cards or more
	 * @param n
	 * @return
	 */
	public boolean hasStraight(int n) {
		int seqLen = 0;
		List<Integer> ranks = getRanks(); // this *should* be sorted
		Collections.sort(ranks);
		for (int i = 0; i < ranks.size(); i++) {
			if (i == 0) continue;
			// FIXME This handles pairs incorrectly!
			if (ranks.get(i) - ranks.get(i-1) == 1) {
				seqLen++;
			} else {
				seqLen = 0;
			}
			if (ranks.size() - i + seqLen < n) return false;
		}
		return seqLen >= n;
	}
	
	public static Hand generateRandomHand(int n, RandomData r) {
		// samples from 0-51
		int [] cardVals = r.nextPermutation(52,n); 
		
		Hand h = new Hand();
		for (int i = 0; i < n; i++) {
			Card c = new Card();
			c.setValue(cardVals[i]+1);
			h.addCard(c);
		}
		
		return h;
	}
	public int numCards() {
		return cards.size();
	}
	
	public String toString() {
		if (cards.size() <= 0) return null;
		StringBuffer sb = new StringBuffer();
		for (Iterator iterator = cards.iterator(); iterator.hasNext();) {
			Card c = (Card) iterator.next();
			sb.append(c.toString() + ", ");
			
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
}
