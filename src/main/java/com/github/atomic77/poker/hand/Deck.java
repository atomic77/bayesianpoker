package com.github.atomic77.poker.hand;

import org.apache.commons.math3.random.*;

public class Deck extends CardCollection {

	private RandomDataGenerator rnd;
	 
	/**
	 * Initializes a new deck of cards
	 */
	public Deck() {
		initializeCardCollecton();
		rnd = new RandomDataGenerator();
		for(int i = 0; i < 52; i++) {
			Card c = new Card();
			c.setValue(i);
			cards.add(c);
		}
	}

	/**
	 * Deal {@code n} cards ; can be cast to any card-collection type
	 * @param n
	 * @return
	 */
	public Pocket dealPocket(int n) {
		int vals[] = sampleFromDeck(n);
		return new Pocket(vals);
	}
	
	public CardCollection dealCards(int n) {
		int vals[] = sampleFromDeck(n);
		return new CommunityCards(vals);
	}
	
//	public Hand dealHand(int n) {
//		int vals[] = sampleFromDeck(n);
//		return new Hand(vals);
//	}
	
	public Card dealCard() {
		int vals[] = sampleFromDeck(1);
		return new Card(vals[0]);
		
	}
	
	private int[] sampleFromDeck(int n) {
		if (n > cards.size()) 
			throw new IllegalArgumentException("Not enough cards!");
		
		// TODO Figure out if there is a way to avoid this object copying
		int vals[] = new int[n];
		Object sample[] = rnd.nextSample(cards, n);
		Card c[] = new Card[n];
		for (int i=0; i<n; i++) {
			cards.remove(sample[i]);
			vals[i] = ((Card)sample[i]).getValue();
		}
		return vals;
	}
}
