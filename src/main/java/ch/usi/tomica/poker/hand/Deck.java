package ch.usi.tomica.poker.hand;

import org.apache.commons.math3.random.RandomData;
import org.apache.commons.math3.random.RandomDataImpl;

public class Deck extends CardCollection {

	private RandomData rnd;
	 
	/**
	 * Initializes {@code decks} new decks of cards 
	 */
	public Deck(int decks) {
		initializeCardCollecton();
		// Initialize the deck
		rnd = new RandomDataImpl(); 
		for(int i = 1; i <= 52; i++) {
			Card c = new Card();
			c.setValue(i);
			cards.add(c);
		}
	}
	/**
	 * Initialize one deck of cards 
	 */
	public Deck() {
		this(1);
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
	
	public CommunityCards dealCommunityCards(int n) {
		int vals[] = sampleFromDeck(n);
		return new CommunityCards(vals);
	}
	
	public Hand dealHand(int n) {
		int vals[] = sampleFromDeck(n);
		return new Hand(vals);
	}
	
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
	
	public Card[] dealCardArray(int n) {
		if (n > cards.size()) 
			throw new IllegalArgumentException("Not enough cards!");
		
		// TODO Figure out if there is a way to avoid this object copying
		Object sample[] = rnd.nextSample(cards, n);
		Card c[] = new Card[n];
		for (int i=0; i<n; i++) {
			cards.remove(sample[i]);
			c[i] = (Card)sample[i];
		}
		return c;
	}
	

}
