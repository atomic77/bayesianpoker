package ch.usi.tomica.poker;

import org.apache.commons.math3.random.RandomData;
import org.apache.commons.math3.random.RandomDataImpl;
import ch.usi.tomica.poker.hand.Card;
import ch.usi.tomica.poker.hand.Hand;

public class PokerTest {
	  
	static RandomData randomData = new RandomDataImpl(); 
	public static void main(String[] args){
		int n = 1000*1000;
		int [] handCounts = new int[9];
		for (int i=0; i< 9; i++) handCounts[i] = 0;
		Card cc = new Card();
		cc.setValue(51);
		System.out.println(cc);
		System.out.println(cc.getSuit());
		System.out.println(cc.getRank());
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < n; i++) {
			Hand h = Hand.generateRandomHand(7, randomData);
			int val = h.evaluateHand();
			handCounts[val]++;
		}
		
		long end = System.currentTimeMillis();
		System.out.printf("Runtime %.2f s. Evaluated avg %.3f hands / ms \n", 
				(double)(end - start) / 1000, (double) n /(end - start));
		System.out.println("Histogram:");
		for (int i = 0; i<9; i++) {
			System.out.println(i + ": " + handCounts[i] );
		}
	}
}
